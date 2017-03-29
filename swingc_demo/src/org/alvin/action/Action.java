/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;

/**
 *
 * @author Administrator
 */
public abstract class Action extends AbstractAction {

    public static final int MENU_ICON = 16;
    public static final int TOOL_ICON = 32;
    public static final int ICONIFIABLE = 64;
    public static final Action Separator = new Action("Separator") {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    };
    public Action(String name) {
        putValue(javax.swing.Action.NAME, name);
    }

    public Action(String name, Icon icon) {
        this(name);
        putValue(javax.swing.Action.SMALL_ICON, icon);
    }

    public void changeState() {
        firePropertyChange("enabled", !isEnabled(), isEnabled());
    }

    @Override
    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        super.firePropertyChange(propertyName, oldValue, newValue);
    }
    
	
	 /**
     * 如果你不想你的动作，在toolbar中显示，可以使用这个做为标识，当然，具体的显示工作，还是你自己做
     *
     * @return
     */
    public boolean showInToolbar() {
        return true;
    }
    
}
