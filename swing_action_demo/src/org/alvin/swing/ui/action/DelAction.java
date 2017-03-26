/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.LARGE_ICON_KEY;
import static javax.swing.Action.LONG_DESCRIPTION;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import org.alvin.swing.ui.ActionDemoFrame;

/**
 *
 * @author Administrator
 */
public class DelAction extends BaseAction {

    public DelAction() {
        super("删除（D）");
        this.putValue(MNEMONIC_KEY, KeyEvent.VK_D);
        this.putValue(SHORT_DESCRIPTION , "删除操作");
        this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control DELETE"));
        this.putValue(LARGE_ICON_KEY, new ImageIcon(this.getClass().getResource("/resources/del_user_24.png")));
        this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/resources/del_user_16.png")));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public boolean isEnabled() {
        if(ActionDemoFrame.frame == null){
            return false;
        }
        return ActionDemoFrame.frame.getTable().getSelectedRow() != -1;
    }

}
