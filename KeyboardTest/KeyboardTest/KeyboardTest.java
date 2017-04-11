import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author 444716720
 *  软键盘   参考自  http://blog.csdn.net/u012643122/article/details/35986713
 */
public class KeyboardTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField jTextField;
	private Keyboard keyboard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyboardTest frame = new KeyboardTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KeyboardTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		jTextField = new JTextField();
		jTextField.setBounds(350, 50, 200, 30);
		
		keyboard = new Keyboard();
		keyboard.setBounds(100, 100, 555, 221);
		contentPane.add(keyboard);
		contentPane.add(jTextField);
	}

}
