
package org.app.view;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

/**
 * 
 * Swing托盘demo
 *
 */
public class TrapDemo
{
	
	public static void main( String [] args )
	{
		//【1】实现托盘功能
		SystemTray tray;// 定义系统托盘
		
		TrayIcon trayIcon;// 定义系统托盘图标
		
		PopupMenu popup = new PopupMenu();// 定义系统托盘图标弹出菜单
		
		MenuItem mi = new MenuItem( "菜单项" );
		
		popup.add( mi );// 将菜单项添加到菜单
		
		// 判断系统是否托盘 
		if( SystemTray.isSupported() )
		{
			tray = SystemTray.getSystemTray();// 通过静态方法得到系统托盘
			Image image = Toolkit.getDefaultToolkit().getImage( "icon.jpg" );// 加载图像
			trayIcon = new TrayIcon( image, "应用名称", popup );// 创建TrayIcon对象得到托盘图标
			trayIcon.setImageAutoSize( true );// 设置托盘图标自动设置尺寸
			
			try
			{
				// 将托盘图标设置到系统托盘中
				tray.add( trayIcon );
				// 为托盘图标注册监听器
				// trayIcon.addActionListener(this);
			}
			catch (Exception e)
			{
			}
		}
		
	}
}
