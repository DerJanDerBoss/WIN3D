package classes;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

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
	
	ArrayList<Line2D> lines = new ArrayList<Line2D>();
	public void clearLines()
	{
		lines = new ArrayList<Line2D>();
	}
	public void drawVerticalLine(int position, int pHeight)
	{
		lines.add( new Line2D.Float(position, 225 + (int)(pHeight / 2), position, 225 - (int)(pHeight / 2)));
		repaint();
	}

	public void paint (Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i < lines.size(); i ++) {
			g2.draw(lines.get(i));
        }
	}
}
