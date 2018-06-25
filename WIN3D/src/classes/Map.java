package classes;
import java.util.*;

public class Map {
	public static ArrayList<Wall> wallList = new ArrayList<Wall>();
	public static ArrayList<GameObjects> objectList = new ArrayList<GameObjects>();
	static Player player;
	static Renderer camera;

	public static void main(String[] args){
		//player = new Player();
		camera = new Renderer();
		//camera.attachToGameobject(player);
		boolean running = true;
		boolean graphicalDebugMode = true;
		while(running == true){
			//player.move();
			camera.renderImage();
			if(graphicalDebugMode)
			{
				
			}
		}
	}
	
	public static void addWall(double pos1X, double pos1Y, double pos2X, double pos2Y)
	{
		wallList.add(new Wall(new Vector(pos1X, pos1Y), new Vector(pos2X, pos2Y)));
	}
}
