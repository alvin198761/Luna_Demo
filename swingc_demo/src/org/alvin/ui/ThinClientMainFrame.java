/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.ui;

import org.alvin.application.Application;
import craky.componentc.CRootPaneUI.ImageDisplayMode;
import craky.componentc.JCButton;
import craky.componentc.JCFrame;
import craky.componentc.JCToggleButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Administrator
 */
public class ThinClientMainFrame extends JCFrame {

    private ConnectionManagerPanel connectionManager;
    private KeqiUserManagerPanel keqiUserManagerPanel;
    private ProtocolSettingPanel protocolSettingPanel;
    private JPanel mainPanel;

    public ThinClientMainFrame() {
        setTitle("SwingC demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 420);
        setResizable(false);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/resource/logo.png")).getImage());
        JPanel content = (JPanel) getContentPane();
        setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/resource/bg.jpg")).getImage());
        setImageDisplayMode(ImageDisplayMode.SCALED);
        setImageAlpha(0.5f);
        //
        content.setLayout(new BorderLayout());
        content.setBorder(new EmptyBorder(0, 2, 5, 2));
        //
        mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        //
        content.add(buttonPanel, BorderLayout.NORTH);
        content.add(mainPanel, BorderLayout.CENTER);
        //
        initButtonPanel(buttonPanel);
    }

    private void initButtonPanel(JPanel buttonPanel) {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        final ButtonGroup group = new ButtonGroup();
        final JCToggleButton accountBtn = new JCToggleButton("User");
        accountBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/remoteUser.jpg")));
        accountBtn.setPreferredSize(new Dimension(84, 78));
        accountBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(connectionManager);
                mainPanel.updateUI();
            }
        });
        group.add(accountBtn);
        initButtons(accountBtn);
        buttonPanel.add(accountBtn);
        //
        JCToggleButton keqiAccounBtn = new JCToggleButton("Role");
        keqiAccounBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/keqiUser.jpg")));
        keqiAccounBtn.setPreferredSize(new Dimension(84, 78));
        initButtons(keqiAccounBtn);
        group.add(keqiAccounBtn);
        buttonPanel.add(keqiAccounBtn);
        keqiAccounBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(keqiUserManagerPanel);
                mainPanel.updateUI();
            }
        });
        //
        JCToggleButton protocolBtn = new JCToggleButton("Protocol");
        protocolBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/protocolSetting.jpg")));
        protocolBtn.setPreferredSize(new Dimension(84, 78));

        initButtons(protocolBtn);
        group.add(protocolBtn);
        buttonPanel.add(protocolBtn);
        protocolBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(protocolSettingPanel);
                mainPanel.updateUI();
            }
        });
        //
        JCButton settingBtn = new JCButton("Setting");
        settingBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/sysSetting.png")));
        settingBtn.setPreferredSize(new Dimension(84, 78));
        settingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        initButtons(settingBtn);
        group.add(settingBtn);
        buttonPanel.add(settingBtn);

        JCButton aboutBtn = new JCButton("Aboute");
        aboutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/house.png")));
        aboutBtn.setPreferredSize(new Dimension(84, 78));
        initButtons(aboutBtn);
        group.add(aboutBtn);
        buttonPanel.add(aboutBtn);
        //
        connectionManager = new ConnectionManagerPanel();
        mainPanel.removeAll();
        mainPanel.add(connectionManager);
        mainPanel.updateUI();
        accountBtn.setSelected(true);

        keqiUserManagerPanel = new KeqiUserManagerPanel();
        protocolSettingPanel = new ProtocolSettingPanel();
    }

    private void initButtons(AbstractButton button) {
        button.setPreferredSize(new Dimension(84, 78));
        button.setFocusable(false);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setIconTextGap(0);
        if (button instanceof JCToggleButton) {
            JCToggleButton ctb = (JCToggleButton) button;
            ctb.setPaintPressDown(false);
            ctb.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/tab_button_normal.png")).getImage());
            ctb.setRolloverImage(new javax.swing.ImageIcon(getClass().getResource("/resource/tab_button_chosen.png")).getImage());
            ctb.setSelectedImage(new javax.swing.ImageIcon(getClass().getResource("/resource/tab_button_chosen.png")).getImage());
        } else if (button instanceof JCButton) {
            JCButton ctb = (JCButton) button;
            ctb.setPaintPressDown(false);
            ctb.setImage(new javax.swing.ImageIcon(getClass().getResource("/resource/tab_button_normal.png")).getImage());
            ctb.setRolloverImage(new javax.swing.ImageIcon(getClass().getResource("/resource/tab_button_chosen.png")).getImage());
            ctb.setPressedImage(new javax.swing.ImageIcon(getClass().getResource("/resource/tab_button_chosen.png")).getImage());
        }
    }

}
