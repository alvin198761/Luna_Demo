/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.ui.action;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ActionManager {

    private static Map<Class<? extends BaseAction>, BaseAction> actionMap = new HashMap<>();

    public static BaseAction getAction(Class<? extends BaseAction> clazz) {
        if (actionMap.containsKey(clazz)) {
            return actionMap.get(clazz);
        }
        BaseAction action = (BaseAction) AccessController.doPrivileged((PrivilegedAction<BaseAction>) () -> {
            try {
                return clazz.newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(ActionManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ActionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        });
        actionMap.put(clazz, action);
        return action;
    }

    public static void firePropertyChanged() {
        actionMap.values().forEach(action -> action.fireEnabledPropertyChanged());
    }

}
