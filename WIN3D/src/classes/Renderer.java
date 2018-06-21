package classes;
import java.util.*;

public class Renderer {
	Vector position;
	double rotation;
	double fieldOfViewDegrees;
	double viewDistance;
	int screenHeight;
	int screenWidth;
	Map map;
	
	public void renderImmage()
	{
		// Filterung der W�nde die im sichtfeld liegen
		ArrayList<Wall> relevantWalls = new ArrayList<Wall>();
		for (int i = 0; i < map.wallList.size(); i ++)
		{
			Vector vec1 = Vector.subtract(relevantWalls.get(i).getPos1(), position);
			Vector vec2 = Vector.subtract(relevantWalls.get(i).getPos2(), position);
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
		
		for (int i = 0; i < screenWidth; i ++)
		{
			double angle = Math.asin((i - (screenWidth / 2))/ screenWidth * 2 * Math.sin(fieldOfViewDegrees / 2 / 360 * Math.PI));
			Vector ray = Vector.multiply(Vector.rotateVector(new Vector(Math.cos(angle),Math.sin(angle)), rotation), viewDistance);
			for (int j = 0; j < relevantWalls.size(); i ++)
			{
				
			}
		}
	}
}
