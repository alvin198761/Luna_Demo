package com.chat.main.chatpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MessageItem extends BaseItem {
	private MessageData message;
    private List<String> strList = new ArrayList<>();
    private int max = 500;//宽度最大值
	public MessageItem(MessageData messgae) {
		this.message = messgae;
		with = 400;
		hight = 600;
		switch (message.getMessageType()) {
		case 1://文字

             with = SwingUtil.getStringWidth(message.getContent(),message.getContfont())+70;
             hight = SwingUtil.getStringHeight(message.getContent(),message.getContfont())+70;
             if(with<89){
            	 with = 89;//设定最小值
             }
             if(hight<89){
            	 hight = 89;//设定最小值
             }
             if(with>max){
            	 int c = with%max==0?with/max:with/max+1;
            	
            	 int mm = c*3;//间隔；
            	 with = max;//最大值
            	 hight = c*SwingUtil.getStringHeight(message.getContent(),message.getContfont())+70+mm;
             }
//             System.out.println("高度："+hight);
//             System.out.println("宽度："+with);
              
			break;
			
		case 2://图片
			with = 70+50;
			hight = 70+50;
			break;
		case 3:

			break;
		case 4:

			break;
		}
 
		setLayout(null);
		this.setPreferredSize(new Dimension(400, 600));

    	JLabel label = new JLabel();
        ImageIcon icn = SwingUtil.getHeadImageIcon("/com/chat/chatimage/ceshi.jpg", 30, 30);
        label.setIcon(icn);
    	BgImagePanel panel = new BgImagePanel(message,with-50,hight-55);
	    if(message.isIsself()){
	    	label.setBounds(with-40, 10, 30, 30);
	    	panel.setBounds(10, 45, with-50,hight-55);
	    	this.add(panel);
	    	this.add(label);
	    }else{
	     	label.setBounds(10, 10, 30, 30);
	    	panel.setBounds(40,45, with-50,hight-55);
	    	this.add(panel);
	    	this.add(label);
	    	
	    }
	    this.setBackground(new Color(244,247,247));
       this.updateUI();
	}


}
