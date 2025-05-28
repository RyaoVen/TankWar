package Event;
import Object.*;

import javax.swing.*;

public class MoveEvent {

    private TankObject tank;
    private JRootPane rootPane;
    private static Timer timer_MoveUp;
    private static Timer timer_MoveDown;
    private static Timer timer_MoveLeft;
    private static Timer timer_MoveRight;


    MoveEvent(TankObject tank, JFrame frame) {
        this.tank = tank;
        this.rootPane = frame.getRootPane();

        //注册键盘监听

        MoveUp();
        MoveDown();
        MoveLeft();
        MoveRight();
    }
    private void MoveUp() {

        KeyBoardEvent.registerKeyBinding(
                rootPane,
                "pressed W",
                "startRepeat",
                () -> {
                    timer_MoveUp = new Timer(100, e -> tank.MoveUp());
                    timer_MoveUp.start();
                }
        );
        KeyBoardEvent.registerKeyBinding(
                rootPane,
                "released W",
                "stopRepeat",
                () -> {
                    if (timer_MoveUp != null && timer_MoveUp.isRunning()) {
                        timer_MoveUp.stop();
                    }
                }

        );
    }


    private void MoveDown() {

        KeyBoardEvent.registerKeyBinding(
                rootPane,
                "pressed S",
                "startRepeat",
                () -> {
                    timer_MoveDown = new Timer(100, e -> tank.MoveDown());
                    timer_MoveDown.start();
                }
        );
        KeyBoardEvent.registerKeyBinding(
                rootPane,
                "released S",
                "stopRepeat",
                () -> {
                    if (timer_MoveDown != null && timer_MoveDown.isRunning()) {
                        timer_MoveDown.stop();
                    }
                }

        );
    }private void MoveLeft() {

        KeyBoardEvent.registerKeyBinding(
                rootPane,
                "pressed A",
                "startRepeat",
                () -> {
                    timer_MoveLeft = new Timer(100, e -> tank.MoveLeft());
                    timer_MoveLeft.start();
                }
        );
        KeyBoardEvent.registerKeyBinding(
                rootPane,
                "released A",
                "stopRepeat",
                () -> {
                    if (timer_MoveLeft != null && timer_MoveLeft.isRunning()) {
                        timer_MoveLeft.stop();
                    }
                }

        );
    }private void MoveRight() {

        KeyBoardEvent.registerKeyBinding(
                rootPane,
                "pressed D",
                "startRepeat",
                () -> {
                    timer_MoveRight = new Timer(100, e -> tank.MoveRight());
                    timer_MoveRight.start();
                }
        );
        KeyBoardEvent.registerKeyBinding(
                rootPane,
                "released D",
                "stopRepeat",
                () -> {
                    if (timer_MoveRight != null && timer_MoveRight.isRunning()) {
                        timer_MoveRight.stop();
                    }
                }

        );
    }
}
