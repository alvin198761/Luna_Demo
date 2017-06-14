package com.chat.main.chatpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MessageListview extends JPanel{
	public List<BaseItem> listitem = new ArrayList<>();
	public int hight = 0;
	private int witdh = 580;
	private int hitgt = 600;
	public MessageListview(){
		this.setLayout(null);
		this.setBackground(new Color(244,247,247));
		this.setPreferredSize(new Dimension(witdh, hitgt));
	}

	public void addListItem(List<MessageData> message){
		
		for(int i =0;i<message.size();i++){
			listitem.add(i,new MessageItem(message.get(i)));
			if(message.get(i).isIsself()){
				listitem.get(i).setBounds(witdh-listitem.get(i).GetWith(), hight, listitem.get(i).GetWith(), listitem.get(i).GetHight());	
			}else{
				listitem.get(i).setBounds(0,hight,listitem.get(i).GetWith(), listitem.get(i).GetHight());
			}
		    System.out.println(hight);
			hight = hight + listitem.get(i).GetHight()+30;
			this.add(listitem.get(i));
		}
		if(hight>hitgt){
		this.setPreferredSize(new Dimension(witdh, hight));
		}else{
			this.setPreferredSize(new Dimension(witdh, hitgt));
		}
		updateUI();
	}
	
}
