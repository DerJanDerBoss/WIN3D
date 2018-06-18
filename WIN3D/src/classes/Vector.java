package classes;

public class Vector {
	public double x;
	public double y;
	public Vector(double pX, double pY){
		x = pX;
		y = pY;
	}
	public static Vector rotateVector(Vector vector,  int degrees)
	{
		double x = vector.x;
		double y = vector.y;
		x -= Math.cos(degrees / 360 * 2 * Math.PI);
		y += Math.sin(degrees / 360 * 2 * Math.PI);
		return new Vector(x, y);
	}

}
