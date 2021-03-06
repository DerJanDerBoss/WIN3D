package classes;
import java.util.*;


public class Renderer {
	public Vector position = new Vector (0, 0);
	public double rotation;
	GameObjects attachedGameObject;
	double fieldOfViewDegrees = 60;
	double viewDistance;
	public Map map;
	
	public void attachToGameobject(GameObjects obj)
	{
		attachedGameObject = obj;
	}
	public void updateTransform(Vector pos, double rot)
	{
		position = pos;
		rotation = rot;
		while(rotation < 0 || rot > 360)
		{
			if(rotation < 0) 
			{
				rotation += 360;
			}
			else if(rotation > 360)
			{
				rotation -= 360;
			}
		}
	}
	public void updateTransform()
	{
		if (attachedGameObject != null) 
		{
			position = attachedGameObject.getPos();
			rotation = attachedGameObject.getRot();
		}
	}
	
	public void renderImage(double screenHeight, double screenWidth)
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
		//System.out.println("relevant Walls: " + relevantWalls.size());
		
		double[] renderedWallDistances = new double[(int)screenWidth];
		map.mainGUI.clearLines();
 		for (int i = 0; i < screenWidth; i ++)
		{
			//double angle = (i - (double)(screenWidth / 2)) / (double)screenWidth * fieldOfViewDegrees / 360 * 2 * Math.PI;
			double angle = Math.asin(((i - screenWidth / 2) / screenWidth) * 2 * Math.sin(fieldOfViewDegrees / 2 / 360 * 2 * Math.PI));
			System.out.println();
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
					wallIntersections.add(intersection[1] * ray.getLength());
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
				double projectionDistance = nearestIntersection - (0.1 * Math.cos(angle));
				System.out.println(0.75f / (float)projectionDistance + " " + (float)projectionDistance);
				map.mainGUI.drawVerticalLine(i, (int)(screenHeight / projectionDistance), 0.75f / (float)projectionDistance);
			}
		}
	}
}
