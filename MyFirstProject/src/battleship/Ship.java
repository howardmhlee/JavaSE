package battleship;

public class Ship {
	
	public enum ShipType {
		PATROL, BATTLESHIP, SUBMARINE, DESTROYER, CARRIER
	}
	
	ShipType type;
	int sizeX; 
	int sizeY;
	String name;
	
	public Ship (ShipType type){
		this.type = type;
		init();
	}
	
	public void init (){
		switch (type){
		case PATROL:
			sizeX = 1;
			sizeY = 2;
			break;
		case BATTLESHIP:
			sizeX = 1;
			sizeY = 3;
			break;
		case SUBMARINE:
			sizeX = 1;
			sizeY = 3;
			break;
		case DESTROYER:
			sizeX = 1;
			sizeY = 4;
		case CARRIER:
			sizeX = 1;
			sizeY = 5;
		}
	}
		
	

}
