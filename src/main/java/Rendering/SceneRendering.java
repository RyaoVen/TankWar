package Rendering;

import javax.swing.*;
import java.awt.*;

public class SceneRendering extends JPanel {
    //大小
    protected int Width;
    protected int Height;

    //颜色
    protected Color color = Color.WHITE;

    SceneRendering(int width, int height) {
        this.Width = width;
        this.Height = height;
    }


    public void init(){
        setBounds(0,0,Width,Height);
        setBackground(color);
        setVisible(true);
    }
}
