package Object;

import Rendering.ObjectRendering;

public class TankObject extends GameObject{
    private int Health;
    private ObjectRendering objectRendering;

    //坦克移动方法

    public String TankMoveDown(GameObject object,int sceneWidth, int sceneHeight){
        if (!(TouchWithScene(sceneWidth,sceneHeight).contains("TouchSceneBottom"))&&!(TouchWithObject(object).equals("TouchObjectBottom"))){
            MoveDown();
            objectRendering.ReSet();
        }else return "Stop";
        return null;
    }
    public String TankMoveUp(GameObject object,int sceneWidth, int sceneHeight){
        if (!(TouchWithScene(sceneWidth,sceneHeight).contains("TouchSceneTop"))&&!(TouchWithObject(object).equals("TouchObjectTop"))){
            MoveUp();
            objectRendering.ReSet();
        }else return "Stop";
        return null;

    }
    public String TankMoveLeft(GameObject object,int sceneWidth, int sceneHeight){
        if (!(TouchWithScene(sceneWidth,sceneHeight).contains("TouchSceneLeft"))&&!(TouchWithObject(object).equals("TouchObjectLeft"))){
            MoveLeft();
            objectRendering.ReSet();
        }else return "Stop";
        return null;
    }
    public String TankMoveRight(GameObject object,int sceneWidth, int sceneHeight){
        if (!(TouchWithScene(sceneWidth,sceneHeight).contains("TouchSceneRight"))&&!(TouchWithObject(object).equals("TouchObjectRight"))){
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

    public void SetHealth(int health){
        Health = health;
    }

    public void ObjectRenderingSet(ObjectRendering objectRendering){
        this.objectRendering = objectRendering;
    }

    //TODO： 1.完善坦克伤害的结算机制 2.完善坦克被摧毁的死亡机制 3.完善游戏的结算机制
}
