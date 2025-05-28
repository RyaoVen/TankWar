package Rendering;

import java.awt.*;
import Object.*;

import javax.swing.*;

public class ObjectRendering extends SceneRendering{
    protected JFrame frame;

    protected GameObject object;

    public ObjectRendering(GameObject object){
        super(object.getWidth(),object.getHeight());
        this.object = object;
    }
    @Override
    public void init(){
        frame.add(this);
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
//TODO： 1.完善被摧毁时的动画 2.完善转向的绘图