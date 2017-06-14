package com.chat.main.chatpanel;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageData implements Serializable{
	public String name;
	public String sendtime;
	public String handeimage;
	public int messageType;
	public String content;
	public String voicepath;
	public String imagepath;
	public String filepath;
	public String filename;
	public Font contfont;
	public Color contcolor;
	public List<String> sTringList = new ArrayList<>();
	
	public List<String> getsTringList() {
		return sTringList;
	}
	public void setsTringList(List<String> sTringList) {
		this.sTringList = sTringList;
	}
	public boolean isself;
	
	public boolean isIsself() {
		return isself;
	}
	public void setIsself(boolean isself) {
		this.isself = isself;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public String getHandeimage() {
		return handeimage;
	}
	public void setHandeimage(String handeimage) {
		this.handeimage = handeimage;
	}
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVoicepath() {
		return voicepath;
	}
	public void setVoicepath(String voicepath) {
		this.voicepath = voicepath;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Font getContfont() {
		return contfont;
	}
	public void setContfont(Font contfont) {
		this.contfont = contfont;
	}
	public Color getContcolor() {
		return contcolor;
	}
	public void setContcolor(Color contcolor) {
		this.contcolor = contcolor;
	}
	
    
}
