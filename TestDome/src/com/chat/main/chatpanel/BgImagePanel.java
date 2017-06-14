package com.chat.main.chatpanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.android.ninepatch.NinePatch;

public class BgImagePanel extends JPanel {
    private MessageData messagedata;
    private int mwith;
    private int mhight;
    private JLabel label;
    private List<String> strList = new ArrayList<>();
	public BgImagePanel(MessageData message,int withm, int hightm) {
		this.setLayout(null);
		this.messagedata = message;
		this.mwith = withm-17;
		this.mhight = hightm;
		this.setBackground(new Color(244,247,247));
		
//		JLabel labelq = new JLabel();
        int x = -1;
        if(messagedata.isIsself()){
        	x = 8;
        }else{
        	x=10;
        }
        
		switch (message.getMessageType()) {
		case 1:
		
			int  with = SwingUtil.getStringWidth(messagedata.getContent(),message.getContfont());
	        int   hight = SwingUtil.getStringHeight(messagedata.getContent(),message.getContfont());
	        int dd = with/messagedata.getContent().length();
	        
	        if(with<=mwith){
	        label = new JLabel();
	    	label.setText(messagedata.getContent());
			label.setFont(messagedata.getContfont());
			label.setForeground(messagedata.getContcolor());
			label.setBounds(x,7, with+10, hight+10);
	        }else{
	        	label = null;
	        	JIMSendTextPane jimSendTextPane = new JIMSendTextPane();
	        	if(!messagedata.isIsself()){
	        		jimSendTextPane.setBackground(new Color(119,181,225));
	        	}
	        	jimSendTextPane.setText(messagedata.getContent());
	        	jimSendTextPane.setFont(messagedata.getContfont());
	        	jimSendTextPane.setForeground(messagedata.getContcolor());
	        	jimSendTextPane.setBounds(x, 7, mwith, mhight);
	        	this.add(jimSendTextPane);   
	        }
			break;

		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		}
		if(label!=null){
		this.add(label);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			NinePatch ninePatch;
			if (messagedata.isIsself()) {
				ninePatch = NinePatch.load(
						getClass().getResource(
								"/com/chat/chatimage/witecolor.9.png"), true);
			} else {
				ninePatch = NinePatch.load(
						getClass().getResource(
								"/com/chat/chatimage/bulecolor.9.png"), true);
			}
			ninePatch.draw((Graphics2D) g, 0, 0, getWidth(), getHeight());
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}
	private int getXindex(int with,int contontwith){
		return (with-contontwith)/2;
	}
	
	/**
	 * 给文字分行显示
	 * @param content
	 * @param num
	 */
	public void getStringList(String content, int num) {
		strList.clear();
		StringBuffer str = new StringBuffer(content);
		int start = 0;
		int end = start + num;
		while (true) {
			if (start >= str.length() || str.length() < num){
				return;
			}
			String temp = str.substring(start, end);
			strList.add(temp);
			start = end;
			end = end + num;
			if (end >= str.length()) {
				end = str.length();
			}
		}
	}
}