package classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends GameObjects implements KeyListener{
	public Player(){
	}

	public void move(){
		move(new Vector(0, 1));
		System.out.println("Position: x = "+pos.x+" y = "+pos.y);
	}
	public void rotate(float value){
		
	}
	public void shoot(){
		
	}
	public void interact(){
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyChar()=='w' || arg0.getKeyChar()=='W'){
			System.out.println("W was pressed!");
		}
		else if(arg0.getKeyChar()=='s' || arg0.getKeyChar()=='S'){
			//move (new Vector(0, -1));
			System.out.println("S was pressed!");
		}
		else if(arg0.getKeyChar()=='a' || arg0.getKeyChar()=='A'){
			//move (new Vector(-1, 0));
			System.out.println("A was pressed!");
		}
		else if(arg0.getKeyChar()=='d' || arg0.getKeyChar()=='D'){
			//move (new Vector(1, 0));
			System.out.println("D was pressed!");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
