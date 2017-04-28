/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author tangzhichao
 */
public class CenterPane extends JComponent{
    
    public CenterPane (JComponent compoennt){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createGlue());
        panel.add(compoennt);
        panel.add(Box.createGlue());
        
        this.add(Box.createGlue());
        this.add(panel);
        this.add(Box.createGlue());
    }
}
