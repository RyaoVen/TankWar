package Event;
import Object.*;
import Rendering.ObjectRendering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShootEvent {
    private BulletGiving bulletGiving;
    private TankObject tank;
    private JRootPane rootPane;
    private TankObject ai;
    private JFrame frame;

    private boolean IsLoaded;
    private List<ActiveBullet> activeBullets; // 存储所有活动子弹的信息

    // 内部类：存储子弹和对应的计时器
    private class ActiveBullet {
        BulletObject bullet;
        ObjectRendering rendering;
        Timer timer;

        ActiveBullet(BulletObject bullet, ObjectRendering rendering, Timer timer) {
            this.bullet = bullet;
            this.rendering = rendering;
            this.timer = timer;
        }
    }

    ShootEvent(BulletGiving bulletGiving, TankObject tank, TankObject ai, JFrame frame) {
        this.rootPane = frame.getRootPane();
        this.bulletGiving = bulletGiving;
        this.tank = tank;
        this.ai = ai;
        this.frame = frame;
        IsLoaded = true;
        activeBullets = new ArrayList<>(); // 初始化列表

        KeyBoardBand();
    }

    void KeyBoardBand() {
        KeyBoardEvent.registerKeyBinding(
                rootPane,
                "pressed J",
                "startRepeat",
                () -> {
                    if (IsLoaded) {
                        Thread ShootThread = new Thread(this::Shoot);
                        ShootThread.start();
                        IsLoaded = false;
                        Thread reloadThread = new Thread(this::ReLoading);
                        reloadThread.start();
                    }
                }
        );
    }

    private void ReLoading() {
        try {
            Thread.sleep(bulletGiving.BulletGet().getReLoadingTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        IsLoaded = true;
    }

    private void Shoot() {
        BulletObject bullet = bulletGiving.BulletGet();
        bullet.setAxis_X(tank.getAxis_X() + tank.getWidth() / 2);
        bullet.setAxis_Y(tank.getAxis_Y() + tank.getHeight() / 2);
        bullet.SetDirection(tank.getDirection());

        ObjectRendering bulletRendering = new ObjectRendering(bullet, frame);
        bulletRendering.init();
        bullet.ObjectRenderingSet(bulletRendering);

        // 显示初始位置


        // 创建一个final引用，用于在匿名类中访问
        ActiveBullet[] currentBulletRef = new ActiveBullet[1];

        // 为每个子弹创建独立的计时器
        Timer timer = new Timer(50, new ActionListener() {
            String boom = "";

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 移动子弹
                    boom = bullet.BulletMove(ai);

                    // 更新渲染


                    // 检查是否需要停止
                    if (boom.contains("BOOM")) {
                        Timer sourceTimer = (Timer)e.getSource();
                        sourceTimer.stop();

                        // 使用final引用访问ActiveBullet
                        if (currentBulletRef[0] != null) {
                            activeBullets.remove(currentBulletRef[0]);
                        }

                        // 处理伤害结算
                        if (boom.contains("Object")) {
                            tank.HealthChange(bullet);
                        }

                        // 显示爆炸效果
                        bulletRendering.Death();
                        System.out.println(boom);
                    }
                } catch (InterruptedException ex) {
                    Timer sourceTimer = (Timer)e.getSource();
                    sourceTimer.stop();

                    // 使用final引用访问ActiveBullet
                    if (currentBulletRef[0] != null) {
                        activeBullets.remove(currentBulletRef[0]);
                    }

                    throw new RuntimeException(ex);
                }
            }
        });

        // 创建 ActiveBullet 实例并存储到final引用中
        ActiveBullet newBullet = new ActiveBullet(bullet, bulletRendering, timer);
        currentBulletRef[0] = newBullet;

        // 将新创建的子弹添加到活动列表
        activeBullets.add(newBullet);

        // 启动计时器
        timer.start();
    }

    // 新增方法：停止所有活动的子弹
    public void stopAllBullets() {
        for (ActiveBullet activeBullet : new ArrayList<>(activeBullets)) {
            activeBullet.timer.stop();
        }
        activeBullets.clear();
    }
}