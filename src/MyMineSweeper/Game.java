package MyMineSweeper;

import java.util.Scanner;

public class Game {
	
	public static final String BLACK_BACKGROUND = "\u001B[40m";
	public static final String WHITE_TEXT = "\u001B[37m";
	
	public void begin() {
		System.out.println(BLACK_BACKGROUND + WHITE_TEXT +  "Welcome to MineSweeper");
	}
	
	public void startGame() {
		MineSweeper game = new MineSweeper();
		
		game.generateMines(10);
		game.assignNums();
		game.updateGrid();
		game.setCount();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
		
		int x = 1;
		int y = 1;
		
		
		if(game.isWon ==  true && game.isDone == true) {
			System.out.println();
			System.out.println(BLACK_BACKGROUND + WHITE_TEXT + "Congratulations, you have won the game!");
			break;
		} else if (game.isWon == false && game.isDone == true){
			System.out.println();
			System.out.println("You stepped on a mine, Game Over.");
			break;
		}
		
		System.out.println(BLACK_BACKGROUND + WHITE_TEXT + "Enter an x Co-Ordinate between 1 - 10");

		x =  scan.nextInt();

		
		while(x < 1 || x > 10) {		
				System.out.println(x + " is outside the range, Enter an x Co-Ordinate between 1 - 10");
			x =  scan.nextInt();
		}
		
		System.out.println("Enter a y Co-Ordinate between 1 - 10");
		
		y =  scan.nextInt();

		while(y < 1 || y > 10) {
			System.out.println(y + " is outside the range, Enter a y Co-Ordinate between 1 - 10");
			y =  scan.nextInt();
		}
		
		game.playerTurn(x - 1 , y - 1);
		game.updateGrid();
		game.Victory();
		
		}
	}
}























