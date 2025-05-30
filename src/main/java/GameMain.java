import Event.*;
import Rendering.*;

import javax.swing.*;

public class GameMain {
    public static void main(String[] args) {
        GameRendering gameRender = new GameRendering(1200, 800);

        GameBegan began = new GameBegan(gameRender);
    }
}
