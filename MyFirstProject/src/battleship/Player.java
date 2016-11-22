package battleship;
import java.util.*;

import battleship.Ship.ShipType;

public class Player {
	
	ArrayList<Ship> gamePieces = new ArrayList<Ship>();
	
	int size = 5;
	boolean[][] board = new boolean[size][size];
	
	public Player(){
		gamePieces.add(new Ship(ShipType.PATROL));
		gamePieces.add(new Ship(ShipType.PATROL));
		gamePieces.add(new Ship(ShipType.BATTLESHIP));
		//gamePieces.add(new Ship(ShipType.BATTLESHIP));
		//gamePieces.add(new Ship(ShipType.SUBMARINE));
		//gamePieces.add(new Ship(ShipType.DESTROYER));
		//gamePieces.add(new Ship(ShipType.CARRIER));
	}
	
	public Ship activeShip(){
		return gamePieces.get(0);
	}
	
	public void placeShip(int x, int y){
		if(checkValidPosition(x,y)){
			for(int i = 0; i < activeShip().sizeX; i++){
				board[x][y+i] = true;  
			}
			for(int i = 0; i < activeShip().sizeY; i++){
				board[x+i][y] = true;
			}
			print();
			gamePieces.remove(0);
		} else {
			System.out.println("Cannot Place Ship Here.");
		}
	}
	
	public void takeShots(int x, int y){
		System.out.println(board[y][x]);
	}
	
	public boolean checkValidPosition(int x, int y){
		if(size<x+activeShip().sizeY || size<y+activeShip().sizeX){
			return false;
		}
		
		for(int i = 0; i < activeShip().sizeX; i++){
			if(board[x][y+i]==true){
				return false;
			}
		}
		for(int i = 0; i < activeShip().sizeY; i++){
			if(board[x+i][y]==true){
				return false;
			}
		}
		return true;
	}
	
	public void print(){	
		for (int r = 0; r<board.length;r++){
		    for (int c = 0; c <board.length;c++){
		        System.out.print (" " + board[r][c]);
		        if(board[r][c]){
		        	System.out.print("  |"); 
		        } else {
		        	System.out.print(" |");
		        }
		    }
		    System.out.println();
		}
		System.out.println();
	}
	
	public boolean lost(){
		for (int r = 0; r<board.length;r++){
		    for (int c = 0; c <board.length;c++){
		    	if(board[r][c] == true){
		    		return false;
		    	}
		    }
		}
		return true;
	}
}
