package classes;
import java.util.*;

public class Map {
	public ArrayList<Wall> wallList = new ArrayList<Wall>();
	public ArrayList<GameObjects> objectList = new ArrayList<GameObjects>();
	Player player;
	Renderer camera;
	public MainGUI mainGUI;
	public Map(MainGUI pMainGUI){
		wallList = new ArrayList<Wall>();
		objectList = new ArrayList<GameObjects>();
		mainGUI = pMainGUI;
		//player = new Player();
		camera = new Renderer();
		camera.map = this;
		//camera.attachToGameobject(player);
		boolean running = true;
		boolean graphicalDebugMode = true;
		addWall(2, -1, 2, 1);
		addWall(2, 1, -2, 1);
		addWall(-2, 1, 4, 1);
		//while(running == true){
			//player.move();
			//mainGUI.clearLines();
			//mainGUI.drawVerticalLine(100, 100);
			//mainGUI.drawVerticalLine(200, 100);
			camera.updateTransform(new Vector(-3, 0), camera.rotation);
			camera.renderImage();
			if(graphicalDebugMode)
			{
				
			}
		//}
	}
	
	public void addWall(double pos1X, double pos1Y, double pos2X, double pos2Y)
	{
		wallList.add(new Wall(new Vector(pos1X, pos1Y), new Vector(pos2X, pos2Y)));
	}
}
