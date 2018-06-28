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
	
	Map map;
	
	public MainGUI()
	{
		JPanel field = new JPanel(); 
		getContentPane().add(field);
        setSize(450,450);
        repaint();
		map = new Map(this);
	}
	
	ArrayList<Line2D> lines = new ArrayList<Line2D>();
	ArrayList<Float> colors = new ArrayList<Float>();
	public void clearLines()
	{
		lines = new ArrayList<Line2D>();
		colors = new ArrayList<Float>();
	}
	public void drawVerticalLine(int position, int pHeight, float brightness)
	{
		lines.add( new Line2D.Float(position, getHeight() / 2 + (int)(pHeight / 2), position, getHeight() / 2 - (int)(pHeight / 2)));
		colors.add(brightness);
		repaint();
	}

	public void paint (Graphics g) 
	{
		map.camera.renderImage(getHeight(), getWidth());
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i < lines.size(); i ++) {
			g2.setColor(Color.getHSBColor(0f, 0f, colors.get(i)));
			g2.draw(lines.get(i));
        }
	}
}
