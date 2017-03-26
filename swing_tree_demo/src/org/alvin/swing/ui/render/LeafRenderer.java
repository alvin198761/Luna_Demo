/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.ui.render;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.alvin.swing.bean.LeafNode;
import org.alvin.swing.ui.icon.RedIcon;

/**
 *
 * @author Administrator
 */
public class LeafRenderer extends DefaultTreeCellRenderer {

    private RedIcon icon = new RedIcon();

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus); //To change body of generated methods, choose Tools | Templates.
        if (value instanceof LeafNode) {
            this.setIcon(icon);
        }
        return this;
    }

}
