package classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends GameObjects implements KeyListener{
	public Player(){
	}

	public void move(){
		
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
			
		}
		else if(arg0.getKeyChar()=='s' || arg0.getKeyChar()=='S'){
			
		}
		else if(arg0.getKeyChar()=='a' || arg0.getKeyChar()=='A'){
			
		}
		else if(arg0.getKeyChar()=='d' || arg0.getKeyChar()=='D'){
			
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
