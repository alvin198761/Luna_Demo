package com.chat.main.chatpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class SwingUtil {
    private static AffineTransform atf = new AffineTransform();

    private static FontRenderContext frc = new FontRenderContext(atf, true,
            true);

    public static int getStringHeight(String str, Font font) {
        if (str == null || str.isEmpty() || font == null) {
            return 0;
        }
        return (int) font.getStringBounds(str, frc).getHeight();

    }

    public static int getStringWidth(String str, Font font) {
        if (str == null || str.isEmpty() || font == null) {
            return 0;
        }
        return (int) font.getStringBounds(str, frc).getWidth();
    }

    /**
     * 将形如“#FFFFFF”的颜色转换成Color
     * 
     * @param hex
     * @return
     */
    public static Color getColorFromHex(String hex) {
        if (hex == null || hex.length() != 7) {
            try {
                throw new Exception("不能转换这种类型的颜色");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        int r = Integer.valueOf(hex.substring(1, 3), 16);
        int g = Integer.valueOf(hex.substring(3, 5), 16);
        int b = Integer.valueOf(hex.substring(5), 16);
        return new Color(r, g, b);
    }
	public static ImageIcon getHeadImageIcon(String head, int width, int height) {
		ImageIcon headImageIcon = null;
		if (head == null || head.equals("") || head.equals("null")) {
			headImageIcon = new ImageIcon(SwingUtil.class.getResource("/com/chat/views/usermainimage/ceshi.jpg"));//默认加载头像
		} else {
			try {
				if(head.indexOf("http")>=0){
				headImageIcon = new ImageIcon(new URL(head));
				}else{
					try {
						headImageIcon = new ImageIcon(SwingUtil.class.getResource(head));
					} catch (Exception e) {
						// TODO: handle exception
						if(headImageIcon==null){
							headImageIcon =new ImageIcon(head);
						}
					}
				
				
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		headImageIcon.setImage(headImageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		
		return headImageIcon;
	}
}
