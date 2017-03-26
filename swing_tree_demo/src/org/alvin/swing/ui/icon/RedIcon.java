/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.ui.icon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

/**
 *
 * @author Administrator 自定义 图标示例
 */
public class RedIcon implements Icon {

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Color color = g.getColor();
        g.setColor(Color.red);
        g.drawRect(0, 0, getIconWidth(), getIconHeight());
        g.fillRect(0, 0, getIconWidth(), getIconHeight());
        g.setColor(color);
    }

    @Override
    public int getIconWidth() {
        return 16;
    }

    @Override
    public int getIconHeight() {
        return 16;
    }

}
