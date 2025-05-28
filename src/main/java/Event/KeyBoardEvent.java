package Event;

import javax.swing.*;

public class KeyBoardEvent {
    public static void registerKeyBinding(
            JFrame component,
            String keyStroke,
            String actionName,
            KeyBoardAction action
    ){
        InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = component.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(keyStroke), actionName);
    }
}
