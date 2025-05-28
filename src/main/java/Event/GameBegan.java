package Event;

import Object.*;

import javax.swing.*;


public class GameBegan {
    TankObject tank;
    AITank ai;
    JFrame frame;
    BulletGiving bulletGiving;

    GameBegan(JFrame frame){
        this.frame = frame;

        TankGiving tank_gamer_giving = new TankGiving();

        bulletGiving = new BulletGiving();
        tank = tank_gamer_giving.TankGet();

        MoveEvent moveEvent = new MoveEvent(tank,frame);
        ShootEvent shootEvent = new ShootEvent(bulletGiving,tank,frame.getRootPane());
    }
}
