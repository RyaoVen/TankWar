package Object;

import Rendering.ObjectRendering;

public class TankObject extends GameObject{
    private int Health;
    private ObjectRendering objectRendering;

    //坦克移动方法

    public String TankMoveDown(GameObject object){
        if (!(TouchWithScene(Width,Height).equals("TouchSceneBottom"))&&!(TouchWithObject(object).equals("TouchObjectBottom"))){
            MoveDown();
            objectRendering.ReSet();
        }else return "Stop";
        return null;
    }
    public String TankMoveUp(GameObject object){
        if (!(TouchWithScene(Width,Height).equals("TouchSceneTop"))&&!(TouchWithObject(object).equals("TouchObjectTop"))){
            MoveUp();
            objectRendering.ReSet();
        }else return "Stop";
        return null;

    }
    public String TankMoveLeft(GameObject object){
        if (!(TouchWithScene(Width,Height).equals("TouchSceneLeft"))&&!(TouchWithObject(object).equals("TouchObjectLeft"))){
            MoveLeft();
            objectRendering.ReSet();
        }else return "Stop";
        return null;
    }
    public String TankMoveRight(GameObject object){
        if (!(TouchWithScene(Width,Height).equals("TouchSceneRight"))&&!(TouchWithObject(object).equals("TouchObjectRight"))){
            MoveRight();
        objectRendering.ReSet();
        }else return "Stop";
        return null;
    }

    //坦克销毁方法
    public void HealthChange(GameObject object){
        Health-=object.getOthers();
    }

    @Override
    public int getOthers(){
        return Health;
    }
}
