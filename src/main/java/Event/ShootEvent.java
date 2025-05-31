package Event;
import Object.*;
import Rendering.ObjectRendering;

import javax.swing.*;

public class ShootEvent {
   private BulletGiving bulletGiving;
   private TankObject tank;
   private JRootPane rootPane;
   private TankObject ai;
   private JFrame frame;


   private boolean IsLoaded;



   ShootEvent(BulletGiving bulletGiving, TankObject tank,TankObject ai ,JFrame frame) {
       this.rootPane = frame.getRootPane();
       this.bulletGiving = bulletGiving;
       this.tank = tank;
       this.ai = ai;
       this.frame = frame;
       IsLoaded = true;

       KeyBoardBand();
   }

   void KeyBoardBand(){
       KeyBoardEvent.registerKeyBinding(
               rootPane,
               "pressed J",
               "startRepeat",
               () -> {
                   if(IsLoaded){
                       Thread ShootThread = new Thread(this::Shoot);
                       ShootThread.start();
                       IsLoaded = false;
                       Thread reloadThread = new Thread(this::ReLoading);
                       reloadThread.start();
                   }
               }
       );
   }

    private void ReLoading(){
        try {
            Thread.sleep(bulletGiving.BulletGet().getReLoadingTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        IsLoaded = true;
    }

    private void Shoot(){

       /*
       * 多开一个线程
       * 实例化一个子弹类的渲染类
       * 循环执行子弹的飞行直到爆炸
       */
        BulletObject Bullet = bulletGiving.BulletGet();
        Bullet.setAxis_X(tank.getAxis_X()+tank.getWidth()/2);
        Bullet.setAxis_Y(tank.getAxis_Y()+tank.getHeight()/2);
        Bullet.SetDirection(tank.getDirection());
        ObjectRendering bullet = new ObjectRendering(Bullet,frame);
        bullet.init();
        Bullet.ObjectRenderingSet(bullet);
        String boom;
        do{
            try {
                boom = Bullet.BulletMove(ai);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(boom.contains("BOOM"));
        if (boom.contains("Object")){
            tank.HealthChange(Bullet);
        }

        //TODO ： 1.完善子弹的生命周期 2.解决伤害的结算

   }

}
