package classes;
import java.util.*;

public class Renderer {
	Vector position = new Vector (0, 0);
	double rotation;
	GameObjects attachedGameObject;
	double fieldOfViewDegrees = 90;
	double viewDistance;
	int screenHeight;
	int screenWidth;
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
		// Filterung der W�nde die im sichtfeld liegen
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
		System.out.println(relevantWalls.size());
		
		double[] renderedWallDistances = new double[screenWidth];
 		for (int i = 0; i < screenWidth; i ++)
		{
			double angle = Math.asin((i - (screenWidth / 2))/ screenWidth * 2 * Math.sin(fieldOfViewDegrees / 2 / 360 * Math.PI));
			Vector ray = Vector.multiply(Vector.rotateVector(new Vector(Math.cos(angle),Math.sin(angle)), rotation), viewDistance);
			ArrayList<Double> wallIntersections = new ArrayList<Double>();
			for (int j = 0; j < relevantWalls.size(); j ++)
			{
				double[] intersection = Vector.checkForIntersections(position, ray, relevantWalls.get(j).getPos1(), Vector.subtract(relevantWalls.get(j).getPos2(), relevantWalls.get(j).getPos1()));
				if (intersection[0] != 0 && intersection[1] >= 0 && intersection[2] >= 0 && intersection[2] >=1)
				{
					wallIntersections.add(intersection[1]);
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
				map.mainGUI.drawVerticalLine(i, (int)(screenHeight / nearestIntersection));
			}
		}
	}
}
