package classes;

public class Vector {
public double x;
public double y;
public Vector(double pX, double pY){
	x = pX;
	y = pY;
}
public void setX(double pX){
	pX = x;
}
public void setY(double pY){
	pY = y;
}
	public static Vector rotateVector(Vector vector,  int degrees)
	{
		double x = vector.x;
		double y = vector.y;
		x -= Math.cos(degrees / 360 * 2 * Math.PI);
		y += Math.sin(degrees / 360 * 2 * Math.PI);
		return new Vector(x, y);
	}
	public void add(Vector vector)
	{
		x += vector.x;
		y += vector.y;
	}
	
	public void subtract(Vector vector)
	{
		x -= vector.x;
		y -= vector.y;
	}
	
	public void multiply(double multiplier)
	{
		x *= multiplier;
		y *= multiplier;
	}
}
