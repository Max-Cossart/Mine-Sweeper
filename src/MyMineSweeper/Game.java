package MyMineSweeper;

import java.util.Scanner;

public class Game {
	
	public void begin() {
		System.out.println("Welcome to MineSweeper");
	}
	
	public void startGame() {
		MineSweeper game = new MineSweeper();
		
		game.generateMines(10);
		game.assignNums();
		game.updateGrid();
		game.setCount();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
		String invalidEntry;	
		
		int x;
		int y;
		
		
		if(game.isWon ==  true && game.isDone == true) {
			System.out.println();
			System.out.println("Congratulations, you have won the game!");
			break;
		} else if (game.isWon == false && game.isDone == true){
			System.out.println();
			System.out.println("You stepped on a mine, Game Over.");
			break;
		}
		
		System.out.println("Enter an x Co-Ordinate between 1 - 10");
		while(!scan.hasNextInt()) {			
			invalidEntry = scan.nextLine();
			System.out.println(invalidEntry + " is outside the range, Enter an x Co-Ordinate between 1 - 10");
		}
		x =  scan.nextInt();

		
		
		while(x < 1 || x > 10 || x % 1 != 0) {
			System.out.println(x + " is outside the range, Enter an x Co-Ordinate between 1 - 10");
			x =  scan.nextInt();
		}
		
		System.out.println("Enter a y Co-Ordinate between 1 - 10");
		
		while(!scan.hasNextInt()) {			
			System.out.println("ran");
			invalidEntry = scan.nextLine();
			System.out.println(invalidEntry + " is outside the range, Enter a y Co-Ordinate between 1 - 10 (this should only run once)");
		}
		y =  scan.nextInt();

		
		while(y < 1 || y > 10) {
			System.out.println(y + " is outside the range, Enter a y Co-Ordinate between 1 - 10");
			y =  scan.nextInt();
		}
		
		game.playerTurn(x, y);
		game.updateGrid();
		game.Victory();
		
		}
	}
}























