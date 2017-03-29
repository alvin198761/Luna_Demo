/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.action;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.KeyStroke;
import org.jdesktop.application.ResourceConverter;
 

/**
 *
 * @author zctang 2015-10-18
 */
public class ActionManager {

    /**
     * Action的初始化和管理
     */
    private static Map<Class, Action> actionMap = new HashMap<Class, Action>();

    public static Action getAction(Class<? extends Action> clazz) {
        Action action = actionMap.get(clazz);
        if (action == null) {
            try {
                action = clazz.newInstance();
                actionMap.put(clazz, action);
            } catch ( Exception ex) {
                ex.printStackTrace();
            }
        }
        return action;
    }

    public static void injectActions(ResourceBundle resourceBundle, javax.swing.Action... actions) {
        for (javax.swing.Action action : actions) {
            injectAction(action, action.getValue("Name").toString(), resourceBundle);
        }
    }

    public static void injectAction(javax.swing.Action paramAction, String paramString, ResourceBundle resourceBundle) {
        if (paramAction == null) {
            throw new IllegalArgumentException();
        }
        if (!paramString.matches("\\w+")) {
            return;
        }
        paramString = paramString + ".Action.";
        String text = paramString + "text";
        if (resourceBundle.containsKey(text)) {
            String name = resourceBundle.getString(text);
            paramAction.putValue("Name", name);
            paramAction.putValue("MnemonicKey", null);
            paramAction.putValue("SwingDisplayedMnemonicIndexKey", Integer.valueOf(-1));
        }
        text = paramString + "mnemonic";
        if (resourceBundle.containsKey(text)) {
            String name = resourceBundle.getString(text);
            int key = getMnemonicKey(name);
            paramAction.putValue("MnemonicKey", key);
            String temp = paramAction.getValue("Name").toString();
            paramAction.putValue("Name", temp + "(" + name.trim().toUpperCase() + ")");
        }
        Icon icon = null;
        text = paramString + "smallIcon";
        if (resourceBundle.containsKey(text)) {
            String value = resourceBundle.getString(text);
            if (value != null) {
                value = value.trim();
            }
            icon = getIcon(value);
            paramAction.putValue("SmallIcon", icon);
        }
        text = paramString + "largeIcon";
        if (resourceBundle.containsKey(text)) {
            String value = resourceBundle.getString(text);
            if (value != null) {
                value = value.trim();
            }
            icon = getIcon(value);
            paramAction.putValue("SwingLargeIconKey", icon);
        }
        KeyStroke localKeyStroke = null;
        text = paramString + "accelerator";
        if (resourceBundle.containsKey(text)) {
            localKeyStroke = getKeyStroke(resourceBundle.getString(text));
        }
        paramAction.putValue("AcceleratorKey", localKeyStroke);
        String shortDescription = null;
        text = paramString + "shortDescription";
        if (resourceBundle.containsKey(text)) {
            shortDescription = resourceBundle.getString(text);
        }
        paramAction.putValue("ShortDescription", shortDescription);
    }

    public static Icon getIcon(String path) {
        try {
            return new javax.swing.ImageIcon(ActionManager.class.getResource(path));
        } catch (Exception e) {
            System.out.println(path);
            return null;
        }
    }

    public static int getMnemonicKey(String key) {
        key = key.trim().toUpperCase();
        int n = key.charAt(0) - 'A';
        return KeyEvent.VK_A + n;
    }

    public static KeyStroke getKeyStroke(String key) {
        return KeyStroke.getKeyStroke(key);
    }

    public static Float getFloat(String paramString) {
        return (Float) getObject(paramString, Float.class);
    }

    public static Double getDouble(String paramString) {
        return (Double) getObject(paramString, Double.class);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getObject(String paramString, Class<T> paramClass) {
        try {
            Object obj = ResourceConverter.forType(paramClass).parseString(paramString, null);
            return (T) obj;
        } catch (ResourceConverter.ResourceConverterException exception) {
        }
        return null;
    }
}
