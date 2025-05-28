package Event;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class KeyBoardEvent {
    public static void registerKeyBinding(
            JComponent component,
            String keyStroke,
            String actionName,
            KeyBoardAction action
    ){
        InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = component.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(keyStroke), actionName);

        // 注册按键
        inputMap.put(KeyStroke.getKeyStroke(keyStroke), actionName);
        actionMap.put(actionName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.action();  // 执行自定义动作
            }
        });
    }
}
