import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gif.Gif;

/**
 * @author 444716720
 *  swing显示GIF图的示例
 */
public class Test extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		Gif gif = new Gif(new File("images/出票.gif"), 20); //参数1文件路径，参数2gif图速度  
		gif.setBounds(0, 0, 172, 172);
		Gif gif1 = new Gif(new File("images/出票.gif"), 80);
		gif1.setBounds(200, 0, 172, 172);
		contentPane.add(gif);
		contentPane.add(gif1);
	}

}
