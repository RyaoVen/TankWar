package Event;
import Object.*;
import Rendering.GameRendering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MoveEvent {
    private TankObject ai;
    private TankObject tank;
    private JRootPane rootPane;
    private GameRendering frame;
    private Map<String, Timer> directionTimers; // 使用Map管理定时器

    // 方向常量
    private static final String UP = "UP";
    private static final String DOWN = "DOWN";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";

    public MoveEvent(TankObject tank, GameRendering frame, TankObject ai) {
        this.tank = tank;
        this.ai = ai;
        this.frame = frame;

        this.rootPane = frame.getRootPane();
        this.directionTimers = new HashMap<>();

        // 注册键盘监听
        initKeyBindings();
    }

    private void initKeyBindings() {
        // 使用策略模式注册各个方向的移动
        registerDirection(UP, "W", object -> tank.TankMoveUp(ai,frame.width,frame.height));
        registerDirection(DOWN, "S", object -> tank.TankMoveDown(ai,frame.width,frame.height));
        registerDirection(LEFT, "A", object -> tank.TankMoveLeft(ai,frame.width,frame.height));
        registerDirection(RIGHT, "D", object -> tank.TankMoveRight(ai,frame.width,frame.height));
    }



    private void registerDirection(String direction, String key, ActionListener action) {
        // 注册按键按下事件
        KeyBoardEvent.registerKeyBinding(
                rootPane,
                "pressed " + key,
                "start" + direction,
                () -> startMovement(direction, action)
        );

        // 注册按键释放事件
        KeyBoardEvent.registerKeyBinding(
                rootPane,
                "released " + key,
                "stop" + direction,
                () -> stopMovement(direction)
        );
    }

    private void startMovement(String direction, ActionListener action) {
        // 停止其他方向的移动，确保只能向一个方向移动
        stopAllMovements();

        // 如果已有该方向的定时器在运行，直接返回
        Timer timer = directionTimers.get(direction);
        if (timer != null && timer.isRunning()) {
            return;
        }

        // 创建新定时器并启动
        timer = new Timer(50, action);
        timer.start();
        directionTimers.put(direction, timer);
    }

    private void stopMovement(String direction) {
        Timer timer = directionTimers.get(direction);
        if (timer != null) {
            timer.stop();
            timer = null; // 帮助垃圾回收
            directionTimers.remove(direction);
        }
    }

    public void stopAllMovements() {
        // 停止并清除所有方向的定时器
        for (Timer timer : directionTimers.values()) {
            if (timer != null && timer.isRunning()) {
                timer.stop();
            }
        }
        directionTimers.clear();
    }

    // 在对象销毁时调用，确保资源释放
    public void cleanup() {
        stopAllMovements();
    }
}