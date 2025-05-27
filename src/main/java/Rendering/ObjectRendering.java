package Rendering;

import java.awt.*;
import Object.*;

public class ObjectRendering extends SceneRendering{

    GameObject object;

    ObjectRendering(GameObject object){
        super(object.getWidth(),object.getHeight());
        this.object = object;
    }
    @Override
    public void init(){
        setBounds(object.getAxis_X(),object.getAxis_Y(),Width,Height);
        setBackground(object.getColor());
        setVisible(true);
    }
    public void ReSet(){
        setBounds(object.getAxis_X(),object.getAxis_Y(),Width,Height);
    }
    public void Death(){
        setVisible(false);
    }
}
