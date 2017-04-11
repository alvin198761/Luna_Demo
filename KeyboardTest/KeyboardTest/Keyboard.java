

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.swing.SwingUtilities2;  

public class Keyboard extends JPanel {
	private static final long serialVersionUID = 1L;  

	//软键盘大小  
	private static Dimension popupSize = new Dimension(555, 221);  
	private static Color backColor = new Color(138, 138, 138);  

	protected SoftKeyBoardPanel softKeyBoardPanel;  

	public Keyboard() {  
		softKeyBoardPanel = new SoftKeyBoardPanel();  
		softKeyBoardPanel.setBounds(0, 0, 555, 221);
		setLayout(null);
		add(softKeyBoardPanel);  
		
	}  

	public SoftKeyBoardPanel getSoftKeyBoardPanel() {  
		return softKeyBoardPanel;  
	}  

	// 软键盘面板  
	public static class SoftKeyBoardPanel extends JPanel implements ActionListener {  

		private static final long serialVersionUID = 1L;

		RowPanel[] rows;  
		KeyStatus status = KeyStatus.normal;  

		public SoftKeyBoardPanel() {  
			initSoftKeyBoardPanel();  
		}  

		// 初始化  
		private void initSoftKeyBoardPanel() {  
			setLayout(null);  
			setBackground(backColor);  

			JPanel proxyPanel = new JPanel(new GridLayout(3, 0, 0, 0));// 3行一列，0水平间隙，1垂直间隙  
			proxyPanel.setLocation(3, 12);  
			proxyPanel.setSize(popupSize.width - 6, popupSize.height - 7);  
			add(proxyPanel);  

			rows = new RowPanel[] { new RowPanel(RowType.first), new RowPanel(RowType.second), new RowPanel(RowType.third) };  
			for (int i = 0; i < rows.length; i++) {  
				proxyPanel.add(rows[i]);  
			}  
		}  

		// 重写paint绘制想要的效果  
		@Override  
		public void paint(Graphics g) {  
			super.paint(g);  
			Graphics2D g2d = (Graphics2D) g;  
			ImageTool.setAntiAliasing(g2d);// 抗锯齿  
		}  

		// 处理所有软键盘点击事件  
		@Override  
		public void actionPerformed(ActionEvent e) {  
			KeyLable keyLable = (KeyLable) e.getSource();  
			if (keyLable.isCapsLock()) {  
				boolean pressed = keyLable.isPressed();  

				if (keyLable.isCapsLock()) {  
					clickCapsLock();  
				}  
				pressed = !pressed;  
				keyLable.setPressed(pressed);  

				notifyKeyLabel();  
			} else if (keyLable.isBackSpace()) {  
				clickBackSpace();  
			} else if (keyLable.isCommKey()) {  
				String key;  
				if (status == KeyStatus.normal || status == KeyStatus.capsLock) {  
					key = keyLable.getLowerLeftKey() == null ? keyLable.getCenterKey() : keyLable.getLowerLeftKey();  
				} else {  
					key = "";  
				}  
				clickCommKey(key);  
			}  
		}  

		// 通知KeyLabel更新状态  
		public void notifyKeyLabel() {  
			for (RowPanel rowPanel : rows) {  
				for (KeyLable keyLable : rowPanel.getKeys()) {  
					keyLable.setStatus(status);  
				}  
			}  
		}  

		// 重置键盘， 清除按压状态，并将键盘恢复至初始状态  
		public void reset() {  
			for (RowPanel rowPanel : rows) {  
				for (KeyLable keyLable : rowPanel.getKeys()) {  
					keyLable.reset();  
				}  
			}  
			status = KeyStatus.normal;  
		}  

		// 更改状态  
		public void clickCapsLock() {  
			if (status == KeyStatus.capsLock) {  
				status = KeyStatus.normal;  
			} else if (status == KeyStatus.normal) {  
				status = KeyStatus.capsLock;  
			} else {  
				status = KeyStatus.normal;  
			}  
		}  

		// 点击了删除键， 删除一个字符  
		public static void clickBackSpace() {  
			String text = KeyboardTest.jTextField.getText();  
			if (text != null && text.length() > 0) {  
				KeyboardTest.jTextField.setText(new String(text.substring(0,text.length()-1)));  
			}  
		}  

		// 点击了普通的键，添加一个字符  
		public void clickCommKey(String key) { 
			if (key != null) {  
				if (key.length() > 1) {// 可有可无的检查  
					key = key.substring(0, key.length() - 1);  
				}  
				String text = KeyboardTest.jTextField.getText();  
				String string = (text == null ? "" : new String(text));  
				KeyboardTest.jTextField.setText(string + key);  
				System.out.println("新添加的字符：" + key);  
				System.out.println("添加后的密码：" + string + key);  
			}  
		}  

		public RowPanel[] getRows() {  
			return rows;  
		}  

		public class RowPanel extends JPanel {  
			private static final long serialVersionUID = 1L;

			RowType rowType;  
			KeyLable[] keys;  

			public RowPanel(RowType rowType) {  
				this.rowType = rowType;  
				initRowPanel();  
			}  

			private void initRowPanel() {  
				setOpaque(true);  
				setLayout(new FlowLayout(FlowLayout.CENTER, 6, 0));// 水平间隙1，垂直间隙0  
				setBackground(backColor);  
				if (rowType == RowType.first) {  

					KeyLable key1 = new KeyLable("q", SoftKeyBoardPanel.this);  
					KeyLable key2 = new KeyLable("w", SoftKeyBoardPanel.this);  
					KeyLable key3 = new KeyLable("e", SoftKeyBoardPanel.this);  
					KeyLable key4 = new KeyLable("r", SoftKeyBoardPanel.this);  
					KeyLable key5 = new KeyLable("t", SoftKeyBoardPanel.this);  
					KeyLable key6 = new KeyLable("y", SoftKeyBoardPanel.this);  
					KeyLable key7 = new KeyLable("u", SoftKeyBoardPanel.this);  
					KeyLable key8 = new KeyLable("i", SoftKeyBoardPanel.this);  
					KeyLable key9 = new KeyLable("o", SoftKeyBoardPanel.this);  
					KeyLable key10 = new KeyLable("p", SoftKeyBoardPanel.this);  


					keys = new KeyLable[] { key1, key2, key3, key4, key5, key6, key7, key8, key9, key10 };  

					for (KeyLable key : keys) {  
						this.add(key); 
					}  

				} else if (rowType == RowType.second) {  
					KeyLable key1 = new KeyLable("a", SoftKeyBoardPanel.this);  
					KeyLable key2 = new KeyLable("s", SoftKeyBoardPanel.this);  
					KeyLable key3 = new KeyLable("d", SoftKeyBoardPanel.this);
					KeyLable key4 = new KeyLable("f", SoftKeyBoardPanel.this);  
					KeyLable key5 = new KeyLable("g", SoftKeyBoardPanel.this);  
					KeyLable key6 = new KeyLable("h", SoftKeyBoardPanel.this);  
					KeyLable key7 = new KeyLable("j", SoftKeyBoardPanel.this);  
					KeyLable key8 = new KeyLable("k", SoftKeyBoardPanel.this);  
					KeyLable key9 = new KeyLable("l", SoftKeyBoardPanel.this);

					keys = new KeyLable[] { key1, key2, key3, key4, key5, key6, key7, key8, key9};  

					for (KeyLable key : keys) {  
						this.add(key); 
					}   

				} else if (rowType == RowType.third) {  
					KeyLable key1 = new KeyLable("z", SoftKeyBoardPanel.this);  
					KeyLable key2 = new KeyLable("x", SoftKeyBoardPanel.this);  
					KeyLable key3 = new KeyLable("c", SoftKeyBoardPanel.this);  
					KeyLable key4 = new KeyLable("v", SoftKeyBoardPanel.this);  
					KeyLable key5 = new KeyLable("b", SoftKeyBoardPanel.this);  
					KeyLable key6 = new KeyLable("n", SoftKeyBoardPanel.this);  
					KeyLable key7 = new KeyLable("m", SoftKeyBoardPanel.this); 

					KeyLable key8 = new KeyLable("删除", true, SoftKeyBoardPanel.this);// 功能键，位置固定在最右  
					key8.setPreferredSize(new Dimension(70, 50));  //功能键大小

					KeyLable key12 = new KeyLable("大小写", true, SoftKeyBoardPanel.this);
					key12.setPreferredSize(new Dimension(70, 50)); //功能键大小

					keys = new KeyLable[] { key12, key1, key2, key3, key4, key5, key6, key7, key8 };  
					
					for (KeyLable key : keys) {  
						this.add(key); 
					}  
				} 
			}
			
			public KeyLable[] getKeys() {  
				return keys;  
			}  
		}  
	}  

	// 键标签  
	public static class KeyLable extends JLabel {  

		private static final long serialVersionUID = 1L;

		// 用String而不是char考虑有功能键显示的是文字，不想再多一个字段了  
		String centerKey;  
		String lowerLeftKey;  
		boolean isBackSpace;  
		boolean isCapsLock;  
		boolean isPressed;  
		KeyStatus status = KeyStatus.normal;  
		Dimension size = new Dimension(45, 50);  //按键大小
		Color keyBorderFocusColor = new Color(162, 162, 157);  
		Color keyBackColor = new Color(253, 255, 255);  
		Font boldFont = new Font("微软雅黑", Font.PLAIN, 18);  //字母大小
		Color boldColor = new Color(0, 0, 57);  
		Font plainFont = new Font("微软雅黑", Font.PLAIN, 10);  
		Color plainColor = new Color(156, 157, 197);  

		public KeyLable(String centerKey, ActionListener action) {  
			this(centerKey, null, action);  
		}  

		public KeyLable(String centerKey, String lowerLeftKey, ActionListener action) {  
			this(centerKey, lowerLeftKey, false, action);  
		}  

		public KeyLable(String centerKey, boolean isFunctionKey, ActionListener action) {  
			this(centerKey, null, isFunctionKey, action);  
		}  

		public KeyLable(String centerKey, String lowerLeftKey, boolean isFunctionKey, final ActionListener action) {  
			this.centerKey = centerKey;  
			this.lowerLeftKey = lowerLeftKey;  
			if (isFunctionKey) {// 这个变量主要是提高效率  
				if (centerKey.contains("删除")) {  
					isBackSpace = true;  
				} else if (centerKey.contains("大小写")) { 
					isCapsLock = true;  
				}  
			}  
			setOpaque(true);// 不透明  
			setBackground(keyBackColor);  
			setPreferredSize(size);  

			addMouseListener(new MouseAdapter() {  
				public void mouseEntered(MouseEvent e) {  
					KeyLable.this.setBackground(keyBorderFocusColor);// 鼠标悬浮时的背景色  
				}  

				public void mouseExited(MouseEvent e) {  
					// 如果不是Shift和CapsLock键则还原背景色，或者是Shift和CapsLock键但是不是按压状态也要还原背景色  
					if (!KeyLable.this.isCapsLock || (!isPressed)) {  
						KeyLable.this.setBackground(keyBackColor);  
					}  
				}  

				public void mouseClicked(MouseEvent e) {  
					// 创建一个ActionEvent将KeyLable对象作为Source  
					action.actionPerformed(new ActionEvent(KeyLable.this, ActionEvent.ACTION_PERFORMED, e.getID() + ""));  
				}  
			});  
		}  

		@Override  
		protected void paintComponent(Graphics g) {  
			super.paintComponent(g);// 完成背景色的绘制  

			Graphics2D g2d = (Graphics2D) g;  
			ImageTool.setAntiAliasing(g2d);// 抗锯齿  

			BasicStroke stroke1 = new BasicStroke(3);   
			// 创建宽度是1的笔画对象  
			g2d.setStroke(stroke1); 
			ImageTool.drawRoundRect(g2d, this.getWidth(), this.getHeight(), 0, null, new Paint[] { new Color(54, 112, 184, 50), new Color(54, 112, 184, 30), new Color(54, 112, 184, 10) });
			if (getMousePosition() != null) {// 如果鼠标正在这个键的范围内，绘制圆角边框  
				g2d.setPaint(keyBorderFocusColor);  
				g2d.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 4, 4);
			}  

			if (status == KeyStatus.normal || status == KeyStatus.capsLock) {  
				if (lowerLeftKey == null) {  
					g2d.setFont(boldFont);  
					g2d.setPaint(boldColor);  
					SwingUtilities2.drawStringUnderlineCharAt(this, g2d, centerKey, -1, isCommKey() ? 8 : 4, 17);  

				} else {  
					g2d.setFont(plainFont);  
					g2d.setPaint(plainColor);  
					SwingUtilities2.drawStringUnderlineCharAt(this, g2d, centerKey, -1, 12, 15);  

					g2d.setFont(boldFont);  
					g2d.setPaint(boldColor);  
					SwingUtilities2.drawStringUnderlineCharAt(this, g2d, lowerLeftKey, -1, 3, 20);  
				}  
			}
		}  

		public String getCenterKey() {  
			return centerKey;  
		}  

		public String getLowerLeftKey() {  
			return lowerLeftKey;  
		}  

		public boolean isBackSpace() {  
			return isBackSpace;  
		}  

		public boolean isCapsLock() {  
			return isCapsLock;  
		}  

		public void setPressed(boolean isPressed) {  
			this.isPressed = isPressed;  
		}  

		public boolean isPressed() {  
			return isPressed;  
		}  

		public boolean isCommKey() {  
			return !isBackSpace && !isCapsLock;  
		}  

		// 重置  
		public void reset() {  
			this.isPressed = false;  
			if (isCapsLock) {  
				KeyLable.this.setBackground(keyBackColor);  
			} else if (isCommKey()) {  
				if (lowerLeftKey == null) {  
					centerKey = centerKey.toLowerCase();  
				}  
			}  
			status = KeyStatus.normal;  
			repaint();  
		}  

		// 设置状态  
		public void setStatus(KeyStatus status) {  
			if (isCommKey() && this.status != status) {  
				if (status == KeyStatus.capsLock) {  
					if (lowerLeftKey == null) {  
						if (Character.isUpperCase(centerKey.charAt(0))) {  
							centerKey = centerKey.toLowerCase();  
						} else {  
							centerKey = centerKey.toUpperCase();  
						}  
					}  
				} else if (status == KeyStatus.normal) {  
					if (lowerLeftKey == null) {  
						centerKey = centerKey.toLowerCase();  
					}  
				}  
				this.status = status;  
				repaint();  
			}  
		}  
	}  

	public static enum RowType {  
		first, second, third
	}  

	public static enum KeyStatus {  
		normal, capsLock
	}  
}  

