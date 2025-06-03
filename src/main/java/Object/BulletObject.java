package Object;

import Rendering.ObjectRendering;

import java.awt.*;

import static java.lang.Thread.sleep;

public class BulletObject extends GameObject{
    private int Damage;
    private int ExplosionRange;
    private int ReLoadingTime;

    private ObjectRendering objectRendering;

    //子弹移动函数
    public BulletObject(Color color, int height,int width,int speed,int damage , int reLoadingTime , int SetExplosionRange, boolean isLive){
        SetColor(color);
        SetHeight(height);
        SetWidth(width);
        SetSpeed(speed);
        SetDamage(damage);
        SetReLoadingTime(reLoadingTime);
        SetExplosionRange(SetExplosionRange);
        SetIsLive(isLive);
    }

    public String BulletMove(GameObject object) throws InterruptedException {
//
           if(!(TouchWithScene(1200,800).equals("NO"))){
               return "BOOM With Scene";
           }else if(!(TouchWithObject(object).equals("NO"))){
               return "BOOM With Object";
           }
           else {
            switch (Direction){
                case "Up": MoveUp();objectRendering.ReSet();Thread.sleep(5); break;
                case "Down": MoveDown();objectRendering.ReSet();Thread.sleep(5);break;
                case "Left": MoveLeft();objectRendering.ReSet();Thread.sleep(5);break;
                case "Right": MoveRight();objectRendering.ReSet();Thread.sleep(5);break;
            }
        }
        return "NO";
    }

    public void ObjectRenderingSet(ObjectRendering objectRendering){
        this.objectRendering = objectRendering;
    }



    @Override
    public int getOthers(){
        return Damage;
    }

    public int getReLoadingTime(){
        return ReLoadingTime;
    }

    //

    public void SetDamage(int damage){
        Damage = damage;
    }

    public void SetExplosionRange(int range){
        ExplosionRange = range;
    }

    public void SetReLoadingTime(int time){
        ReLoadingTime = time;
    }
}
