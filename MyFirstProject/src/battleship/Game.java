package battleship;

import java.util.*;

import battleship.AI.Coord;

//import battleship.Ship.ShipType;

public class Game {

	int playerTurn = 0;
	int phase = 0;
		
	//ArrayList<Ship> player1 = new ArrayList<Ship>();
	//ArrayList<Ship> player2 = new ArrayList<Ship>();
	
	Player player1 = new Player();
	Player player2 = new Player();
	Player activePlayer;
	boolean aiactive = false;
	
	
	Scanner sc; 
	boolean end = false;
	

	public static void main(String[] args) {
		Game game = new Game();
	
		System.out.println("AI?");
		game.sc = new Scanner(System.in);
		boolean a = game.sc.nextBoolean();
		if(a){
			game.player2 = new AI();
			game.aiactive = true;
		}
		
		System.out.println("Placing Phase: Player 1");
		game.activePlayer = game.player1;
		game.placingPhase();
		
		System.out.println("Placing Phase: Player 2");
		game.activePlayer = game.player2;
		game.placingPhase();
		
		game.activePlayer = game.player1;
		
		while(!game.end){
			if(game.activePlayer == game.player1){
				System.out.println("Attack Phase: Player 1");
				game.player2.print();
			} else {
				System.out.println("Attack Phase: Player 2");
				game.player1.print();
			}
			
			int x = 0,y =0;
			if(game.activePlayer == game.player1 || (game.activePlayer==game.player2 && !game.aiactive)){
				System.out.println("Input X");
				game.sc = new Scanner(System.in);
				x = game.sc.nextInt();
				System.out.println("Input Y");
				game.sc = new Scanner(System.in);
				y = game.sc.nextInt();
			} else if(game.aiactive && game.activePlayer == game.player2){
				Coord co = ((AI)game.activePlayer).randomCoord();
				x = co.x;
				y = co.y;
			}
			
			if(game.takeShot(x, y)){
				System.out.println(game.takeShot(x,y));
				System.out.println("Hit");
				if(game.activePlayer == game.player1){
					game.player2.board[x][y] = false; 
				} else {
					game.player1.board[x][y] = false;
				}
			} else {
				System.out.println("Miss");
				if(game.activePlayer == game.player1){
					game.activePlayer = game.player2;
				}else {
					game.activePlayer = game.player1;
				}
			}
			//game.player2.print();
			System.out.println("x:" + x + "y: " + y);
			System.out.println("---------------------------------");
			game.winConditions();
		}

	}
	
	public void winConditions(){
		if(player1.lost()){
			end = true;
			System.out.println("Player 2 Win");
		} 
		if(player2.lost()) {
			end = true;
			System.out.println("Player 1 Win");
		}
	}
	
	public void placingPhase(){
		while(activePlayer.gamePieces.size()>0){
			System.out.println(activePlayer.activeShip()+": "+activePlayer.activeShip().sizeX+"x"+activePlayer.activeShip().sizeY);
			
			if(activePlayer == player1 || (activePlayer==player2 && !aiactive)){
				System.out.println("Rotate?");
				sc = new Scanner(System.in);
				if(sc.nextBoolean()){
					rotateShip();
				} 
			}else 
			
			
			if(aiactive && activePlayer == player2){
				//System.out.println(((AI) player2).randomRotate());
				if(((AI)player2).randomRotate()){
					rotateShip();
				}
			}
			
			if(activePlayer == player1 || (activePlayer==player2 && !aiactive)){
				System.out.println("Input X");
				sc = new Scanner(System.in);
				int x = sc.nextInt();
				System.out.println("Input Y");
				sc = new Scanner(System.in);
				int y = sc.nextInt();
				
				placeShip(x, y);
			} else if (aiactive && activePlayer == player2){
				int x = ((AI)player2).randomInt();
				int y = ((AI)player2).randomInt();
				placeShip(x,y);
			}
			
			//activePlayer.print();
		}
		activePlayer.print();
	}
	
	
	public void assignGamePieces(){
		//player1.add(new Ship(ShipType.PATROL));
	}
	
	public void rotateShip(){  //orientation true = horizontal, false = vertical
		int newY, newX;
		newX = activePlayer.activeShip().sizeY;
		newY = activePlayer.activeShip().sizeX;
		activePlayer.activeShip().sizeX = newX;
		activePlayer.activeShip().sizeY = newY;
		System.out.println(activePlayer.activeShip().sizeX + "x" + activePlayer.activeShip().sizeY);
	}
	
	public void placeShip(int x, int y){
		activePlayer.placeShip(x, y);
	}
	
	public boolean takeShot(int x,int y){
		if(activePlayer != player1){
			return player1.board[x][y];
		} else {
			return player2.board[x][y];
		}
	}

	
	
	

	
	

}
