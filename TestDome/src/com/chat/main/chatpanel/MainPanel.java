package com.chat.main.chatpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MainPanel extends JPanel{
	private JScrollPane jScrollPane;
	private MessageListview listview;
	private List<MessageData> listdata = new ArrayList<>();
	private boolean index = false;
	public MainPanel(){
		setLayout(new BorderLayout(0, 0));
		listview = new MessageListview();
		jScrollPane = new JScrollPane();
		jScrollPane.setBorder(null);
		jScrollPane.setViewportView(listview);
		jScrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(jScrollPane,BorderLayout.CENTER);
	
		JButton but = new JButton("tianijia");
		this.add(but,BorderLayout.SOUTH);
		but.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
               for(int i =0;i<10;i++){
            	   MessageData data = new MessageData();
            	   data.setIsself(index);
            	   data.setContent("hzxdjkasdghasljdglasgbdhagslkjdgasjgbdjasghdbkahsadsadasdasdasdasasdasdasdasdasdasddasdasdsdgfkagsdasfas");
            	   Font font = new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 8+i);
            	   data.setContfont(font);
            	   data.setContcolor(new Color(150,0,0));
            	   index = !index;
            	   data.setMessageType(1);
            	   listdata.add(data);
               }
               listview.addListItem(listdata);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame  fame = new JFrame();
        fame.add(new MainPanel());
        fame.setSize(600, 600);
        fame.setVisible(true);
        
	}
}
