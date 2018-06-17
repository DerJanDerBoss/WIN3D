package classes;
import java.util.*;
//teets
public class Map {
	ArrayList<Wall> wallList = new ArrayList<Wall>();
	ArrayList<GameObjects> objectList = new ArrayList<GameObjects>();
	Player player;
		public Map(){
			
}
		public static void main(String[] args){
			player = new Player();
			boolean running = true;
			while(running == true){
				player.move();
			}
		}
}
