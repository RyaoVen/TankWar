package Rendering;
import javax.swing.*;

public class GameRendering extends JFrame{

    public int width, height;

public GameRendering(int width, int height){
    this.width = width;
    this.height = height;
    setTitle("TankWar");
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
}
