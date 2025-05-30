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
    public String TouchWithScene(int sceneWidth, int sceneHeight) {
        StringBuilder result = new StringBuilder();

        // 精确检测所有边界（使用>=和<=）
        if (this.Axis_X + this.Width >= sceneWidth) {
            result.append("TouchSceneRight");
        }
        if (this.Axis_Y + this.Height >= sceneHeight) {
            if (result.length() > 0) result.append("|");
            result.append("TouchSceneBottom");
        }
        if (this.Axis_X <= 0) {
            if (result.length() > 0) result.append("|");
            result.append("TouchSceneLeft");
        }
        if (this.Axis_Y <= 0) {
            if (result.length() > 0) result.append("|");
            result.append("TouchSceneTop");
        }

        return result.length() > 0 ? result.toString() : "NO";
    }

    public String TouchWithObject(GameObject object) {
        // 计算两物体在X和Y方向上的重叠量
        int overlapX = Math.max(0, Math.min(this.Axis_X + this.Width, object.Axis_X + object.Width)
                - Math.max(this.Axis_X, object.Axis_X));
        int overlapY = Math.max(0, Math.min(this.Axis_Y + this.Height, object.Axis_Y + object.Height)
                - Math.max(this.Axis_Y, object.Axis_Y));

        // 如果没有重叠，返回NO
        if (overlapX == 0 || overlapY == 0) {
            return "NO";
        }

        // 判断主要碰撞方向（重叠量较小的方向）
        if (overlapX < overlapY) {
            if (this.Axis_X < object.Axis_X) {
                return "TouchObjectRight";
            } else {
                return "TouchObjectLeft";
            }
        } else {
            if (this.Axis_Y < object.Axis_Y) {
                return "TouchObjectBottom";
            } else {
                return "TouchObjectTop";
            }
        }
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
