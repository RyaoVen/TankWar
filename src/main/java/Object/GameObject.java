package Object;
import java.awt.*;
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
    protected Color color;

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
        if (abs((this.Axis_X+this.Width/2)-(object.Axis_X+this.Width/2))<(this.Width+object.Width)/2){
            if (this.Axis_X>object.Axis_X)return "TouchObjectRight";
            if (this.Axis_X<object.Axis_X)return "TouchObjectLeft";
        };
        if (abs((this.Axis_Y+this.Height/2)-(object.Axis_Y+this.Height/2))<(this.Height+object.Height)/2){
            if (this.Axis_Y>object.Axis_Y)return "TouchObjectBottom";
            if (this.Axis_Y<object.Axis_Y)return "TouchObjectTop";
        };
        return null;
    }

    //传参函数


    public int getAxis_X(){
        return this.Axis_X;
    }
    public int getAxis_Y(){
        return this.Axis_Y;
    }
    public int getWidth(){
        return this.Width;
    }
    public int getHeight(){
        return this.Height;
    }
    public Color getColor(){
        return this.color;
    }


    //移动函数

    public void MoveUp(){
        this.Axis_Y-=Speed;
    }
    public void MoveDown(){
        this.Axis_Y+=Speed;
    }
    public void MoveLeft(){
        this.Axis_X-=Speed;
    }
    public void MoveRight(){
        this.Axis_X+=Speed;
    }
    public int getOthers(){
        return 0;
    }

    //设参函数群

    public void SetDirection(String Direction){
        this.Direction = Direction;
    }

    public void SetSpeed(int Speed){
        this.Speed = Speed;
    }

    public void SetWidth(int Width){
        this.Width = Width;
    }

    public void SetHeight(int Height){
        this.Height = Height;
    }

    public void setAxis_X(int Axis_X){
        this.Axis_X = Axis_X;
    }

    public void setAxis_Y(int Axis_Y){
        this.Axis_Y = Axis_Y;
    }

    public void SetColor(Color color){
        this.color = color;
    }

    public void SetIsLive(boolean IsLive){
        this.IsLive = IsLive;
    }

}
