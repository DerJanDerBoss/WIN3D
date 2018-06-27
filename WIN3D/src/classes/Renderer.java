package classes;
import java.util.*;


public class Renderer {
	public Vector position = new Vector (0, 0);
	public double rotation;
	GameObjects attachedGameObject;
	double fieldOfViewDegrees = 100;
	double viewDistance;
	int screenHeight = 450;
	int screenWidth = 450;
	public Map map;
	
	public void attachToGameobject(GameObjects obj)
	{
		attachedGameObject = obj;
	}
	public void updateTransform(Vector pos, double rot)
	{
		position = pos;
		rotation = rot;
	}
	public void updateTransform()
	{
		if (attachedGameObject != null) 
		{
			position = attachedGameObject.getPos();
			rotation = attachedGameObject.getRot();
		}
	}
	
	public void renderImage()
	{
		// Filterung der Wände die im sichtfeld liegen
		ArrayList<Wall> relevantWalls = new ArrayList<Wall>();
		for (int i = 0; i < map.wallList.size(); i ++)
		{
			Vector vec1 = Vector.subtract(map.wallList.get(i).getPos1(), position);
			Vector vec2 = Vector.subtract(map.wallList.get(i).getPos2(), position);
			vec1 = Vector.rotateVector(vec1, - rotation);
			vec2 = Vector.rotateVector(vec2, - rotation);
			double angle1 = Math.atan(vec1.y / vec1.x) / Math.PI * 360;
			double angle2 = Math.atan(vec1.y / vec1.x) / Math.PI * 360;
			if (angle1 >= 180)
			{
				angle1 = 180 - angle1;
			}
			if (angle2 >= 180)
			{
				angle2 = 180 - angle1;
			}
			
			if(Math.abs(angle1) <= fieldOfViewDegrees || Math.abs(angle2) <= fieldOfViewDegrees)
			{
				relevantWalls.add(map.wallList.get(i));
			}
		}
		System.out.println("relevant Walls: " + relevantWalls.size());
		
		double[] renderedWallDistances = new double[screenWidth];
		map.mainGUI.clearLines();
 		for (int i = 0; i < screenWidth; i ++)
		{
			double angle = (i - (double)(screenWidth / 2)) / (double)screenWidth * fieldOfViewDegrees / 360 * 2 * Math.PI;
			System.out.println(angle + " " + angle * 360 / 2 / Math.PI);
			Vector ray = Vector.rotateVector(new Vector(Math.cos(angle),Math.sin(angle)), rotation);
			ArrayList<Double> wallIntersections = new ArrayList<Double>();
			for (int j = 0; j < relevantWalls.size(); j ++)
			{
				double[] intersection = Vector.checkForIntersections(position, ray, relevantWalls.get(j).getPos1(), Vector.subtract(relevantWalls.get(j).getPos2(), relevantWalls.get(j).getPos1()));
				//System.out.println("row: " + i);
				//System.out.println("collision?: " + intersection[0]);
				//System.out.println("distance: " + intersection[1]);
				//System.out.println("posOnWall: " +  intersection[2]);
				
				if (intersection[0] != 0 && intersection[1] >= 0 && intersection[2] >= 0 && intersection[2] <=1)
				{
					wallIntersections.add(intersection[1]);
					//System.out.println("visible Wall");
				}
			}
			if(wallIntersections.size() > 0){
				double nearestIntersection = wallIntersections.get(0);
				for (int j = 1; j < wallIntersections.size(); j ++)
				{
					if (wallIntersections.get(j) < nearestIntersection)
					{
						nearestIntersection = wallIntersections.get(j);
					}
				}
				renderedWallDistances[i] = nearestIntersection;
				map.mainGUI.drawVerticalLine(i, (int)(screenHeight / (nearestIntersection - (0 * Math.abs(Math.cos(angle))))));
			}
		}
	}
}
