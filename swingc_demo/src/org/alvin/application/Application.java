/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.application;

import org.alvin.ui.ThinClientMainFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author zctang 2015-10-16
 */
public class Application {

    public static ThinClientMainFrame mainFrame;
    public static final String logoIcon = "/resource/main.png";
    public static final String bgIcon = "/resource/bg.jpg";
    //

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainFrame = new ThinClientMainFrame();
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setVisible(true);
            }
        });
    }
}
