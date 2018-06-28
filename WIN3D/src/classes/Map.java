package classes;
import java.util.*;

public class Map {
	public ArrayList<Wall> wallList = new ArrayList<Wall>();
	public ArrayList<GameObjects> objectList = new ArrayList<GameObjects>();
	Player player;
	public Renderer camera;
	public MainGUI mainGUI;
	public Map(MainGUI pMainGUI){
		wallList = new ArrayList<Wall>();
		objectList = new ArrayList<GameObjects>();
		mainGUI = pMainGUI;
		addWall(2, -1, 2, 1);
		addWall(2, 1, 0, 1);
		addWall(2, -1, 4, -1);
		addWall(4, -1, 4, -5);
	}
	public void performTick()
	{
		for (int i = 0; i < objectList.size(); i ++)
		{
			objectList.get(i).update();
		}
	}
	public void addWall(double pos1X, double pos1Y, double pos2X, double pos2Y)
	{
		wallList.add(new Wall(new Vector(pos1X, pos1Y), new Vector(pos2X, pos2Y)));
	}
}
