package Object;

import javax.swing.*;
import java.awt.*;

public class AITank extends TankObject {

    private TankObject tank;
    private JFrame frame;


    public AITank(TankObject tank,JFrame frame) {
        this.frame = frame;
        this.tank = tank;
        SetHealth(100);
        SetSpeed(1);
        SetColor(Color.yellow);
        SetHeight(50);
        SetWidth(50);
        setAxis_X(250);
        setAxis_Y(250);
        SetIsLive(true);
    }

    public void BeginMoving() {
        while (true){
            Move();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void Move() {

        int Y = this.Axis_Y - tank.Axis_Y;
        int X = this.Axis_X - tank.Axis_X;

        if (Math.abs(Y) > Math.abs(X)) {
            //先执行Y方向的移动
            if (Y > 0) {
                this.Direction = "Up";
                for (int i = 0; i < 100; i++) {
                    TankMoveUp(tank, frame.getWidth(), frame.getHeight());
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                this.Direction = "Down";
                for (int i = 0; i < 100; i++) {
                    TankMoveDown(tank, frame.getWidth(), frame.getHeight());
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else {
            if (X > 0) {
                this.Direction = "Left";
                for (int i = 0; i < 100; i++) {
                    TankMoveLeft(tank, frame.getWidth(), frame.getHeight());
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                this.Direction = "Right";
                for (int i = 0; i < 100; i++) {
                    TankMoveRight(tank, frame.getWidth(), frame.getHeight());
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }


    }


}
