package classes;

public class Vector {

	public static void main(String[] args) 
	{
		System.out.println();
	}
	
	public double x;
	public double y;
	
	public Vector(double pX, double pY){
		x = pX;
		y = pY;
	}
	
	public static Vector rotateVector(Vector vector,  double degrees)
	{
		double x = vector.x;
		double y = vector.y;
		double rad = (degrees / 360 * 2 * Math.PI);
		x = Math.cos(Math.acos(x / vector.getLength()) + rad) * vector.getLength();
		y = Math.sin(Math.asin(y / vector.getLength()) + rad) * vector.getLength();
		return new Vector(x, y);
	}
	
	public static Vector add(Vector vector1, Vector vector2)
	{
		return new Vector(vector1.x + vector2.x, vector1.y + vector2.y);
	}

	public static Vector subtract(Vector vector1, Vector vector2)
	{
		return new Vector(vector1.x - vector2.x, vector1.y - vector2.y);
	}

	public static Vector multiply(Vector vector, double multiplier)
	{
		return new Vector(vector.x * multiplier, vector.y * multiplier);
	}
	
	public static double[] checkForIntersections(Vector pos1, Vector dir1, Vector pos2, Vector dir2)
	{
		double[] returnValue = new double[3];
		
		returnValue[0] = 0;
		//check if directions are parralel and don't have a length of 0
		if(dir1.x/dir2.x != dir1.y/dir2.y && !(dir1.x == 0 && dir2.x == 0 || dir1.y == 0 && dir2.y == 0)&& dir1.getLength() != 0 && dir2.getLength() != 0)
		{
			if (dir1.x == 0)
			{
				returnValue[2] = (pos2.x - pos1.x) / - dir2.x;
				if(dir2.y == 0)
				{
					returnValue[1] = (pos2.y - pos1.y) / dir1.y;
					returnValue[0] = 1;
				}
				else
				{
					returnValue[1] = (pos2.y - pos1.y + dir2.y * returnValue[2]) / dir1.y;
					returnValue[0] = 1;
				}
			}
			else if(dir1.y == 0)
			{
				returnValue[2] = (pos2.y - pos1.y) / - dir2.y;
				if(dir2.x == 0)
				{
					returnValue[1] = (pos2.x - pos1.x) / dir1.x;
					returnValue[0] = 1;
				}
				else
				{
					returnValue[1] = (pos2.x - pos1.x + dir2.x * returnValue[2]) / dir1.x;
					returnValue[0] = 1;
				}
			}
			else if(dir2.x == 0)
			{
				returnValue[1] = (pos2.x - pos1.x) / dir1.x;
				returnValue[2] = (pos2.y - pos1.y - dir1.y * returnValue[1]) / - dir2.y;
				returnValue[0] = 1;
			}
			else if(dir2.y == 0)
			{
				returnValue[1] = (pos2.y - pos1.y) / dir1.y;
				returnValue[2] = (pos2.x - pos1.x - dir1.x * returnValue[1]) / - dir2.x;
				returnValue[0] = 1;
			}
			else
			{
				returnValue[1] = ((pos2.y - pos1.y) - (pos2.x - pos1.x) / (dir2.x / dir2.y)) / (dir1.y - dir1.x / (dir2.x / dir2.y));
				returnValue[2] = (pos2.y - pos1.y - dir1.y * returnValue[1]) / - dir2.y;
			}
		}
		return returnValue;
	}

	public double getLength()
	{
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}
