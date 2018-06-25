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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
		
        
		setTitle("WIN 3D");
		/*
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 686);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		*/
		
		
		//Erstellung der Benutzeroberfläche
		
		JPanel field = new JPanel(); 
		getContentPane().add(field);
        setSize(450,450);
        
        
        //Knopf
        
		JButton button = new JButton("Drück mich!");
        field.add(button);
        
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				field.repaint();
				
				/*
				field.removeAll();
				field.revalidate();
				field.repaint();
				*/
			}
		});
	}
	
	// Methode zum zeichnen der Linie
	
		public void paint(Graphics g) 
		{
	        Graphics2D g2 = (Graphics2D) g;
	        Line2D lin = new Line2D.Float(100, 100, 250, 260);
	        g2.draw(lin);
		}
	

}
