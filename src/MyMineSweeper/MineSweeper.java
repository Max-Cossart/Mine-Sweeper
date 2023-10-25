package MyMineSweeper;

import java.util.Arrays;

public class MineSweeper {
	
	private String[][] field = new String[10][10];
	private String[][] display = new String[10][10];
	
	public static final String GREY_BACKGROUND = "\u001B[47m";
	public static final String BLACK_TEXT = "\u001B[30m";
	public static final String WHITE_TEXT = "\u001B[37m";
	
	private int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	
	public Boolean isWon = false;
	public Boolean isDone = false;
	
	private int count = 0;
	
	private String mine = " * ";
	private String unknown = " ? ";
	private String edge = "|" + BLACK_TEXT;
	private String divider = "+---" + BLACK_TEXT;
	

	
	
	
	public MineSweeper() {
		
		for(int x = 0; x < display.length; x++) {
			
			for(int y = 0; y < display[x].length; y++) {
				
				display[x][y] = unknown;
				field[x][y] = unknown;
			}
		}
	}
	
	
	public void printGame(String[][] arr) {
		System.out.println();
		for(int x = 0; x < arr.length; x++) {
			if(x == 0) {				
				System.out.println(GREY_BACKGROUND + BLACK_TEXT + "     1   2   3   4   5   6   7   8   9   10");
			}
				System.out.println("   " + divider.repeat(arr.length) + "+");
				
			for(int y = 0; y < arr[x].length; y++) {
				if(y == 0 ) {
					if(x == arr.length - 1) { 
						System.out.print(x + 1  + " " + edge + arr[x][y] + edge);
					} else {
						System.out.print(x + 1 + "  "  + edge + arr[x][y] + edge);
					}
				} else {
					System.out.print(arr[x][y] + edge);
				}
			}
			System.out.println();
			if (x == arr.length - 1) {
			System.out.print("   " + divider.repeat(arr.length) + "+");
			System.out.println();
			}
		}
	}
	
	
	public void generateMines(int n) {
		for(int i = 0; i < n; i++) {
			
			while(true) {
				
			int x = 0;
			int y = 0;
			
			x = (int) Math.floor(Math.random() * 10);
			y = (int) Math.floor(Math.random() * 10);
			
			if(!field[x][y].equals(mine)) {
				field[x][y] = mine;
				break;
			}
			}
		}
	}
	
	public void updateGrid() {
		printGame(display);
	}
	
	
	public void assignNums() {
		for(int x = 0; x < field.length; x++) {
			for(int y = 0; y < field[x].length; y++) {					
				
				if(field[x][y].equals(" * ")) {
					continue;
				}
				
				int counter = 0;
				for(int[] direction : directions) {
					int newX = x + direction[0];
					int newY = y + direction[1];
					if(newX >= 0 && newX <= field.length - 1 && newY >= 0 && newY <= field[x].length - 1) {
						
						if(field[newX][newY].equals(mine)) {
							counter++;
					}
				}
					field[x][y] = " " + counter + " ";
				}
			}
		}
	}
	
	public void assignColours() {
		
		for(int x = 0; x < field.length; x++) {
			for(int y = 0; y < field[x].length; y++) {	
				if(field[x][y].equals(" 0 ")) { 
					display[x][y] = display[x][y] + WHITE_TEXT;
				}
			}	
		}
	}
	
	
//	public void assignNums() {
//		for(int x = 0; x < field.length; x++) {
//			
//			for(int y = 0; y < field.length; y++) {	
//				
//				int count = 0;
//				
//				if(field[x][y] != " * ") {
//					
//					if(x != 0 && y != 0 && x != field.length -1 && y != field[x].length - 1) {
//				
//						if(field[x - 1][y - 1] == " * ") {
//							count++;
//						}
//						if(field[x][y - 1] == " * ") {
//							count++;
//						}
//						if(field[x + 1][y - 1] == " * ") {
//							count++;
//						}
//						if(field[x - 1][y] == " * ") {
//							count++;
//						}
//						if(field[x + 1][y] == " * ") {
//							count++;
//						}
//						if(field[x - 1][y + 1] == " * ") {
//							count++;
//						}
//						if(field[x][y + 1] == " * ") {
//							count++;
//						}
//						if(field[x + 1][y + 1] == " * ") {
//							count++;
//						}
//					}
//					if(x == 0) {
//						if(y == 0) {
//							if(field[x + 1][y] == " * ") {
//								count++;
//							}
//							if(field[x][y + 1] == " * ") {
//								count++;
//							}
//							if(field[x + 1][y + 1] == " * ") {
//								count++;
//							}
//						} else if (y == field[x].length - 1) {
//							if(field[x][y - 1] == " * ") {
//								count++;
//							}
//							if(field[x + 1][y - 1] == " * ") {
//								count++;
//							}
//							if(field[x + 1][y] == " * ") {
//								count++;
//							}
//						} else {
//							if(field[x][y - 1] == " * ") {
//								count++;
//							}
//							if(field[x + 1][y - 1] == " * ") {
//								count++;
//							}
//							if(field[x + 1][y] == " * ") {
//								count++;
//							}
//							if(field[x][y + 1] == " * ") {
//								count++;
//							}
//							if(field[x + 1][y + 1] == " * ") {
//								count++;
//							}
//						}
//					}
//					if (x == field.length - 1) {
//						if(y == 0) {
//							if(field[x - 1][y] == " * ") {
//								count++;
//							}
//							if(field[x - 1][y + 1] == " * ") {
//								count++;
//							}
//							if(field[x][y + 1] == " * ") {
//								count++;
//							}
//						} else if (y == field.length - 1) {
//							if(field[x - 1][y - 1] == " * ") {
//								count++;
//							}
//							if(field[x][y - 1] == " * ") {
//								count++;
//							}
//							if(field[x - 1][y] == " * ") {
//								count++;
//							}
//						} else {
//							if(field[x - 1][y - 1] == " * ") {
//								count++;
//							}
//							if(field[x][y - 1] == " * ") {
//								count++;
//							}
//							if(field[x - 1][y] == " * ") {
//								count++;
//							}
//							if(field[x - 1][y + 1] == " * ") {
//								count++;
//							}
//							if(field[x][y + 1] == " * ") {
//								count++;
//							}
//						}
//					}
//					if(y == 0 && x != 0 && x != field.length-1) {
//						if(field[x - 1][y] == " * ") {
//							count++;
//						}
//						if(field[x + 1][y] == " * ") {
//							count++;
//						}
//						if(field[x - 1][y + 1] == " * ") {
//							count++;
//						}
//						if(field[x][y + 1] == " * ") {
//							count++;
//						}
//						if(field[x + 1][y + 1] == " * ") {
//							count++;
//						}
//					}
//					if(y == field.length - 1 && x != 0 && x != field.length - 1) {
//						if(field[x - 1][y - 1] == " * ") {
//							count++;
//						}
//						if(field[x][y - 1] == " * ") {
//							count++;
//						}
//						if(field[x + 1][y - 1] == " * ") {
//							count++;
//						}
//						if(field[x - 1][y] == " * ") {
//							count++;
//						}
//						if(field[x + 1][y] == " * ") {
//							count++;
//						}
//					}
//				}
//				
//				if (field[x][y] != " * ") {					
//					field[x][y] = " " + count + " ";
//				}
//			}
//		}
//	}
	
	public void playerTurn(int num1, int num2) {
		int x = num1 ;
		int y = num2 ;
		
		count--;
		
		if(!field[x][y].equals(" * ") == true) {
			
			display[x][y]  = field[x][y];
			
			if(field[x][y].equals(" 0 ")) {
				for(int[] direction : directions) {
					int newX = x + direction[0];
					int newY = y + direction[1];
					if(newX >= 0 && newX <= field.length - 1 && newY >= 0 && newY <= field[x].length - 1) {
							
						if(display[newX][newY].equals(" ? ")) {
							this.playerTurn(newX, newY);

						}
					}
				}
			}
			
		}else {
			isDone = true;
			display = field;
		}
	}
	
//	public void cascade(int x, int y) {
//
//		for(int[] direction : directions) {
//			int newX = x + direction[0];
//			int newY = y + direction[1];
//			if(newX >= 0 && newX <= field.length - 1 && newY >= 0 && newY <= field[x].length - 1) {
//
//					
//				if(display[newX][newY].equals(unknown)) {
//					this.playerTurn(newX, newY);
//
//
//				}
//			}
//		}
//
//		
////		for(int[] direction : directions) {
////			int newX = x + direction[0];
////			int newY = y + direction[1];
////			if(newX >= 0 && newX <= field.length - 1 && newY >= 0 && newY <= field[x].length - 1) {
////				display[newX][newY] = field[newX][newY];				
////				if(field[newX][newY].equals(" 0 ")) {
////					System.out.println("also a zero");
////				}
////			}
////		}
//		
//	}
		

	public void setCount() {
		for(int x = 0; x < field.length; x++) {
			for(int y = 0; y < field.length; y++) {
				if(field[x][y] != " * ") {
					count++;
				}
			}
		}
	}
	
	public void Victory() {
		if(count == 0) {
			isWon = true;
			isDone = true;
		}
	}
	
	
	
}






























