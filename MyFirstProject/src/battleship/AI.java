package battleship;

import java.util.Random;

public class AI extends Player {
	
	public class Coord{
		int x;
		int y;
		public Coord(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	boolean[][] checkboard = new boolean[size][size];
	
	public void checked(int x, int y){
		checkboard[x][y] = true;
	}
	
	public void takeShot(){
	}
	
	
	public boolean randomRotate(){
		Random rn = new Random();
		boolean bool = rn.nextBoolean();
		return bool;
	}
	
	public int randomInt(){
		Random rn = new Random();
		int in = rn.nextInt(size);
		return in;
	}
	
	public Coord randomCoord(){
		Coord co = new Coord(randomInt(),randomInt());
		while(checkboard[co.x][co.y]==true){
			co.x = randomInt();
			co.y = randomInt();
		}

		checkboard[co.x][co.y] = true;
		System.out.println(co.x + ":" + co.y);
		
		return co;
	}
	
	
}
