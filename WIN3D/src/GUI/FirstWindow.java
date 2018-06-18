package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;

public class FirstWindow extends JFrame {

	private JPanel contentPane;

	/** in workspace
	 * Launch the application.
	 * was passiert eigentlichss
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWindow frame = new FirstWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**in random
	 * Create the frames.
	 * jetztaaber tolles ding
	 */
	public FirstWindow() {
		setTitle("Tolles Ding");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 686);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblTestlabel = new JLabel("TestLabel17");
		lblTestlabel.setBackground(new Color(255, 255, 0));
		contentPane.add(lblTestlabel, BorderLayout.WEST);
	}

}
