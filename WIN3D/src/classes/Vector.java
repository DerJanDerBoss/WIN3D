package classes;

public class Vector {
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
		x -= Math.cos(degrees / 360 * 2 * Math.PI);
		y += Math.sin(degrees / 360 * 2 * Math.PI);
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
	
	public double getLength()
	{
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}
