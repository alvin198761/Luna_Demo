/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.ui.action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.alvin.swing.ui.model.UserInfoModel;

/**
 *
 * @author Administrator
 */
public class AddAction extends AbstractAction{
    
    private UserInfoModel model;

    public AddAction(UserInfoModel model) {
        this.model = model;
        super.putValue(NAME, "添加");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.addBlankRow();
    }
    
}
