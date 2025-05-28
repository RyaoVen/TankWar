package Object;

import java.awt.*;

public class BulletGiving {
    private BulletObject bullet;
    private int BulletKind;

    public BulletGiving() {
    InitKindOne();
    BulletKind = 1;
    }

    public BulletObject BulletGet(){
        if(bullet == null){
            switch (BulletKind){
                case 1:InitKindTow();break;
                case 2:InitKindThree();break;
                case 3:InitKindOne();break;
            }
        }
        return bullet;
    }

    public void TruncateBullet(){
        switch (BulletKind){
            case 1:InitKindTow();BulletKind = 2;break;
            case 2:InitKindThree();BulletKind = 3;break;
            case 3:InitKindOne();BulletKind = 1;break;
        }
    }

    private void InitKindOne(){

        if(!(bullet == null)){
            bullet = null;
        }

        bullet = new BulletObject();

        bullet.SetColor(Color.orange);
        bullet.SetHeight(5);
        bullet.SetWidth(5);
        bullet.SetSpeed(5);
        bullet.SetDamage(5);
        bullet.SetReLoadingTime(100);
        bullet.SetExplosionRange(8);
        bullet.SetIsLive(true);

    }

    private void InitKindTow(){

        if(!(bullet == null)){
            bullet = null;
        }

        bullet = new BulletObject();

        bullet.SetColor(Color.YELLOW);
        bullet.SetHeight(8);
        bullet.SetWidth(8);
        bullet.SetSpeed(8);
        bullet.SetDamage(10);
        bullet.SetReLoadingTime(250);
        bullet.SetExplosionRange(12);
        bullet.SetIsLive(true);

    }

    private void InitKindThree(){

        if(!(bullet == null)){
            bullet = null;
        }

        bullet = new BulletObject();

        bullet.SetColor(Color.red);
        bullet.SetHeight(10);
        bullet.SetWidth(10);
        bullet.SetSpeed(12);
        bullet.SetDamage(25);
        bullet.SetReLoadingTime(1000);
        bullet.SetExplosionRange(20);
        bullet.SetIsLive(true);

    }
}
