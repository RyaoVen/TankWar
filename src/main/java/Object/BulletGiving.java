package Object;

import java.awt.*;

public class BulletGiving {
    private int BulletKind;

    public BulletGiving() {
    InitKindOne();
    BulletKind = 1;
    }


    public BulletObject BulletGet(){
            switch (BulletKind){
                case 1:InitKindTow();break;
                case 2:InitKindThree();break;
                case 3:InitKindOne();break;
            }
            return InitKindOne();

    }

    public void TruncateBullet(){
        switch (BulletKind){
            case 1:BulletKind = 2;break;
            case 2:BulletKind = 3;break;
            case 3:BulletKind = 1;break;
        }
    }

    private BulletObject InitKindOne(){
return new BulletObject(Color.orange,5,5,5,5,100,8,true);
    }

    private BulletObject InitKindTow(){
return new BulletObject(Color.YELLOW,8,8,8,10,250,12,true);
    }

    private BulletObject InitKindThree(){
return new BulletObject(Color.red,10,10,12,25,1000,20,true);
    }
}
