package classes;
public class Wall {
Vector pos1;
Vector pos2;
public Wall(Vector pPos1, Vector pPos2){
	pos1 = pPos1;
	pos2 = pPos2;
}
public Vector getPos1(){
	return pos1;
}
public Vector getPos2(){
	return pos2;
}
}
