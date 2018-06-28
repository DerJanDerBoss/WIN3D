package classes;//tests

public class GameObjects {
	Vector pos;
	double rot;
	public GameObjects(){
	pos = new Vector(0, 0);
	}
	
	public void update()
	{
		
	}
	
	public Vector getPos(){
		return pos;
	}
	public void move(Vector deltaPosition){
		pos.x = pos.x + deltaPosition.x;
		pos.y = pos.y + deltaPosition.y;
	}
	public double getRot() 
	{
		return rot;
	}
	public void rotate(double deltaRotation) 
	{
		rot *= deltaRotation;
		while(rot < 0 || rot > 360)
		{
			if(rot < 0) 
			{
				rot += 360;
			}
			else if(rot > 360)
			{
				rot -= 360;
			}
		}
	}
}
