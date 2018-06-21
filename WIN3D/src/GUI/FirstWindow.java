package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;

public class FirstWindow extends JFrame {


	private JPanel contentPane;

	/** 
	 * Launch the application.
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

	/**
	 * Create the frames.
	 */
	public FirstWindow() 
	{
        
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		setTitle("Tolles Ding");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 10, 10);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblTestlabel = new JLabel("TestLabel17");
		lblTestlabel.setBackground(new Color(100, 100, 100));
		contentPane.add(lblTestlabel, BorderLayout.WEST);
		
		
		 
		JPanel panelx = new JPanel();
		contentPane.add(panelx, BorderLayout.NORTH);
        getContentPane().add(panelx);
        setSize(500,500);
        
        JButton button =new JButton("Drück mich!");
        panelx.add(button);
	}

	    public void paint(Graphics g) 
	    {
	        Graphics2D g2 = (Graphics2D) g;
	        Line2D lin = new Line2D.Float(100, 100, 200, 100);
	        g2.draw(lin);
	    }
	    
	    public void button(JButton b)
	    {
	    	
	    }
}


