package classes;//tests

public class GameObjects {
Vector pos;

public Vector getPos(){
	return pos;
}
public void movePos(Vector position){
	pos.x = pos.x + position.x;
	pos.y = pos.y + position.y;
}
}
