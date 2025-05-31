package Event;

import Object.*;
import Rendering.GameRendering;
import Rendering.ObjectRendering;

import javax.swing.*;


public class GameBegan {
    TankObject tank;
    AITank ai;
    JFrame frame;
    BulletGiving bulletGiving;

    public GameBegan(GameRendering frame){
        this.frame = frame;

        TankGiving tank_gamer_giving = new TankGiving();

        bulletGiving = new BulletGiving();
        tank = tank_gamer_giving.TankGet();
        this.ai = new AITank(tank,frame);
        ObjectRendering tank_rendering = new ObjectRendering(tank,frame);
        tank.ObjectRenderingSet(tank_rendering);

        MoveEvent moveEvent = new MoveEvent(tank,frame,ai);
        ShootEvent shootEvent = new ShootEvent(bulletGiving,tank,ai,frame);


        ObjectRendering ai_rendering = new ObjectRendering(ai,frame);
        ai.ObjectRenderingSet(ai_rendering);
        ai_rendering.init();
        tank_rendering.init();

        Thread ai_move = new Thread(ai::BeginMoving);
        ai_move.start();


    }
}
