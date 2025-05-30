package Object;

import java.awt.*;

public class TankGiving {
    private TankObject tank;

    public TankGiving() {
        tank = new TankObject();
        tank.SetHealth(100);
        tank.SetSpeed(1);
        tank.SetColor(Color.green);
        tank.SetHeight(50);
        tank.SetWidth(50);
        tank.setAxis_X(50);
        tank.setAxis_Y(50);
        tank.SetIsLive(true);
    }

    public TankObject TankGet() {
        return tank;
    }
}
