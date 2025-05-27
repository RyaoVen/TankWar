package Object;

import Rendering.ObjectRendering;

public class BulletObject extends GameObject{
    private int Damage;
    private int ExplosionRange;

    private ObjectRendering objectRendering;

    //子弹移动函数

    public String BulletMove(GameObject object){
        if ((TouchWithScene(Width,Height)==null)|| TouchWithObject(object)==null){
            return "BOOM";
        }else {
            switch (Direction){
                case "UP": MoveUp();objectRendering.ReSet();break;
                case "DOWN": MoveDown();objectRendering.ReSet();break;
                case "LEFT": MoveLeft();objectRendering.ReSet();break;
                case "RIGHT": MoveRight();objectRendering.ReSet();break;
            }
        }
        return null;
    }

    @Override
    public int getOthers(){
        return Damage;
    }
}
