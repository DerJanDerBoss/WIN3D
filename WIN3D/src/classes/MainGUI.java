package classes;
import java.awt.*;
import java.awt.geom.Line2D;

import javax.swing.*;


public class MainGUI extends JFrame{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainGUI()
	{
		JPanel field = new JPanel(); 
		getContentPane().add(field);
        setSize(450,450);
        repaint();
		Map map = new Map(this);


	}
	
	static int posX;
	static int height;
	public void drawVerticalLine(int position, int pHeight)
	{
		posX = position;
		height = pHeight;
		repaint();
	}

	public void paint (Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(posX, 100, posX, 260);
        g2.draw(lin);
	}
}
