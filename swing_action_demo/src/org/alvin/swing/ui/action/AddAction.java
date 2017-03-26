/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.ui.action;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import org.alvin.swing.ui.ActionDemoFrame;

/**
 *
 * @author Administrator
 */
public class AddAction extends BaseAction {

    public AddAction() {
        super("添加（A）");
        this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
        this.putValue(SHORT_DESCRIPTION , "添加操作");
        this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control shift N"));
        this.putValue(LARGE_ICON_KEY, new ImageIcon(this.getClass().getResource("/resources/add_user_24.png")));
        this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/resources/add_user_16.png")));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window window = SwingUtilities.windowForComponent((Component) e.getSource());
        JOptionPane.showMessageDialog(window, "添加动作,清除选中。。");
        ActionDemoFrame.frame.getTable().clearSelection();
    }

}
