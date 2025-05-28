package Event;
import Object.*;
import Rendering.ObjectRendering;

import javax.swing.*;

public class ShootEvent {
   private BulletObject bullet;
   private TankObject tank;
   private JRootPane rootPane;


   private boolean IsLoaded;



   ShootEvent(BulletObject bullet, TankObject tank, JRootPane rootPane) {
       this.rootPane = rootPane;
       this.bullet = bullet;
       this.tank = tank;
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
                       IsLoaded = false;
                       Thread reloadThread = new Thread(this::ReLoading);
                   }
               }
       );
   }

    private void ReLoading(){
        try {
            Thread.sleep(bullet.getReLoadingTime());
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
        BulletObject Bullet = new BulletObject();
        ObjectRendering bullet = new ObjectRendering(Bullet);
        Bullet.ObjectRenderingSet(bullet);
        while (!Bullet.BulletMove(tank).equals("BOOM"));

        //TODO ： 完善子弹的生命周期：1.解决传入的tank对象 2.解决伤害的结算 3.完成供弹类，完善弹药类的参数注入

   }

}
