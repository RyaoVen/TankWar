package Object;
import java.math.*;

import static java.lang.Math.abs;

public class GameObject {

    //坐标
    protected int Axis_X;
    protected int Axis_Y;

    //大小
    protected int Width;
    protected int Height;

    //颜色
    protected String Color;

    //物理量
    protected int Speed;
    protected String Direction;

    //是否存活
    protected boolean IsLive;


    //函数
    String TouchWithScene(int SceneWidth, int SceneHeight) {
        if ((this.Axis_X + this.Width) > SceneWidth) return "TouchSceneRight";
        if ((this.Axis_Y + this.Height) > SceneHeight) return "TouchSceneBottom";
        if (this.Axis_X < 0) return "TouchSceneLeft";
        if (this.Axis_Y < 0) return "TouchSceneTop";
        return null;
    }

    String TouchWithObject(GameObject object) {
        if (abs(this.Axis_X - object.Axis_X) > (this.Width + object.Width)){
            if (this.Axis_X>object.Axis_X)return "TouchObjectRight";
            if (this.Axis_X<object.Axis_X)return "TouchObjectLeft";
        };
        return null;
    }

}
