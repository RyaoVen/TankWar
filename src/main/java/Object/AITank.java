package Object;

import java.awt.*;

public class AITank extends TankObject {
public AITank(){
    SetHealth(100);
    SetSpeed(10);
    SetColor(Color.yellow);
    SetHeight(50);
    SetWidth(50);
    setAxis_X(250);
    setAxis_Y(250);
    SetIsLive(true);
}
}
