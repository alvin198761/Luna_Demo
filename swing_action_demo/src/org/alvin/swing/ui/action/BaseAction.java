/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.ui.action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;

/**
 *
 * @author Administrator
 */
public abstract class BaseAction  extends AbstractAction{

    public BaseAction(String name) {
        super(name);
    }

    public void fireEnabledPropertyChanged(){
        this.firePropertyChange("enabled", true, false);
    }
}
