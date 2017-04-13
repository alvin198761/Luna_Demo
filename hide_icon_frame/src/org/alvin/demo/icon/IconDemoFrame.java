/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.demo.icon;

import java.awt.image.BufferedImage;

/**
 *
 * @author tangzhichao
 */
public class IconDemoFrame extends javax.swing.JFrame {

    /**
     * Creates new form IconDemoFrame
     */
    public IconDemoFrame() {
        initComponents();
        setSize(200, 300);
//        this.setIconImage( new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE));   // or
        this.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IconDemoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
