package com.msg;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TextArea;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel;


/**
 * 
 * 创建闪动的托盘图像
 * @author Everest
 *
 */
public class BickerTray extends JFrame implements Runnable {

	private static final long serialVersionUID = -3115128552716619277L;

	private SystemTray sysTray;// 当前操作系统的托盘对象
	private TrayIcon trayIcon;// 当前对象的托盘

	private ImageIcon icon = null;
	private TextArea ta = null;
	
	private static int count = 1; //记录消息闪动的次数
	private boolean flag = false; //是否有新消息
	private static int times = 1; //接收消息次数

	public BickerTray() {
		this.createTrayIcon();// 创建托盘对象
		Image image = this.getToolkit().getImage(getRes("com/img/f32.gif"));
		this.setIconImage(image);
		init();
	}

	public URL getRes(String str){
    	 return this.getClass().getClassLoader().getResource(str);
    }
	
	/**
	 * 初始化窗体的方法
	 */
	public void init() {
		this.setTitle("消息盒子");
		ta = new TextArea("");
		ta.setEditable(false);
		this.add(ta);
		this.setSize(400, 400);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// 添加窗口最小化事件,将托盘添加到操作系统的托盘
		/*this.addWindowListener(new WindowAdapter() {
			public void windowIconified(WindowEvent e) {
				addTrayIcon();
			}
		});*/
		addTrayIcon();
		this.setVisible(true);
	}

	/**
	 * 添加托盘的方法
	 */
	public void addTrayIcon() {
		try {
			sysTray.add(trayIcon);// 将托盘添加到操作系统的托盘
			setVisible(false);    // 使得当前的窗口隐藏
			new Thread(this).start();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 创建系统托盘的对象 步骤: 
	 * 1,获得当前操作系统的托盘对象 
	 * 2,创建弹出菜单popupMenu 
	 * 3,创建托盘图标icon
	 * 4,创建系统的托盘对象trayIcon
	 */
	public void createTrayIcon() {
		sysTray = SystemTray.getSystemTray();// 获得当前操作系统的托盘对象
		icon = new ImageIcon(getRes("com/img/f17.gif"));// 托盘图标
		PopupMenu popupMenu = new PopupMenu();// 弹出菜单
		MenuItem mi = new MenuItem("open");
		MenuItem exit = new MenuItem("exist");
		popupMenu.add(mi);
		popupMenu.add(exit);
		// 为弹出菜单项添加事件
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta.setText(ta.getText()+"\n==============================================\n 《通知》 今天下午4:00到大礼堂开会。 \n 第"+times+"次接收时间："+ new Date().toLocaleString()); // 设置通知消息内容
				BickerTray.this.setExtendedState(JFrame.NORMAL);
				BickerTray.this.setVisible(true); // 显示窗口
				BickerTray.this.toFront(); //显示窗口到最前端
				flag = false;  //消息打开了
				count = 0; times++;
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		trayIcon = new TrayIcon(icon.getImage(), "消息盒子", popupMenu);
		/** 添加鼠标监听器，当鼠标在托盘图标上双击时，默认显示窗口 */
		trayIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { // 鼠标双击
					ta.setText(ta.getText()+"\n==============================================\n 《通知》 今天下午4:00到大礼堂开会。 \n 第"+times+"次接收时间："+ new Date().toLocaleString()); // 设置通知消息内容
					BickerTray.this.setExtendedState(JFrame.NORMAL);
					BickerTray.this.setVisible(true); // 显示窗口
					BickerTray.this.toFront();
					flag = false;  //消息打开了
					count = 0; times++;
				}
			}
		});
	}

	/**
	 * 线程控制闪动 
	 */
	public void run() {
		while (true) {
			if(flag){ // 有新消息
				try {
					if(count == 1){
						// 播放消息提示音
						//AudioPlayer p = new AudioPlayer(getRes("file:com/sound/Msg.wav"));
						//p.play(); p.stop();
						try {
							AudioClip p = Applet.newAudioClip(new URL("file:sound/msg.wav"));
							p.play();
						} catch (MalformedURLException e) {
							e.printStackTrace();
						}
					}
					// 闪动消息的空白时间
					this.trayIcon.setImage(new ImageIcon("").getImage());
					Thread.sleep(500);
					// 闪动消息的提示图片
					this.trayIcon.setImage(icon.getImage());
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				count++;
			}else{ // 无消息或是消息已经打开过
				this.trayIcon.setImage(icon.getImage());
				try {
					Thread.sleep(20000);
					flag = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel(new SubstanceBusinessBlueSteelLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BickerTray();
			}
		});
	}

}
