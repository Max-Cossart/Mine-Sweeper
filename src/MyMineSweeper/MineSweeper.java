package MyMineSweeper;

public class MineSweeper {
	
	private String[][] field = new String[10][10];
	private String[][] display = new String[10][10];
	
	public Boolean isWon = false;
	public Boolean isDone = false;
	
	private int count = 0;
	
	private String mine = " * ";
	private String unknown = " ? ";
	private String edge = "|";
	private String divider = "+---";
	
	
	
	
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
				System.out.println("     1   2   3   4   5   6   7   8   9   10");
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
			
			for(int y = 0; y < field.length; y++) {	
				
				int count = 0;
				
				if(field[x][y] != " * ") {
					
					if(x != 0 && y != 0 && x != field.length -1 && y != field[x].length - 1) {
				
						if(field[x - 1][y - 1] == " * ") {
							count++;
						}
						if(field[x][y - 1] == " * ") {
							count++;
						}
						if(field[x + 1][y - 1] == " * ") {
							count++;
						}
						if(field[x - 1][y] == " * ") {
							count++;
						}
						if(field[x + 1][y] == " * ") {
							count++;
						}
						if(field[x - 1][y + 1] == " * ") {
							count++;
						}
						if(field[x][y + 1] == " * ") {
							count++;
						}
						if(field[x + 1][y + 1] == " * ") {
							count++;
						}
					}
					if(x == 0) {
						if(y == 0) {
							if(field[x + 1][y] == " * ") {
								count++;
							}
							if(field[x][y + 1] == " * ") {
								count++;
							}
							if(field[x + 1][y + 1] == " * ") {
								count++;
							}
						} else if (y == field[x].length - 1) {
							if(field[x][y - 1] == " * ") {
								count++;
							}
							if(field[x + 1][y - 1] == " * ") {
								count++;
							}
							if(field[x + 1][y] == " * ") {
								count++;
							}
						} else {
							if(field[x][y - 1] == " * ") {
								count++;
							}
							if(field[x + 1][y - 1] == " * ") {
								count++;
							}
							if(field[x + 1][y] == " * ") {
								count++;
							}
							if(field[x][y + 1] == " * ") {
								count++;
							}
							if(field[x + 1][y + 1] == " * ") {
								count++;
							}
						}
					}
					if (x == field.length - 1) {
						if(y == 0) {
							if(field[x - 1][y] == " * ") {
								count++;
							}
							if(field[x - 1][y + 1] == " * ") {
								count++;
							}
							if(field[x][y + 1] == " * ") {
								count++;
							}
						} else if (y == field.length - 1) {
							if(field[x - 1][y - 1] == " * ") {
								count++;
							}
							if(field[x][y - 1] == " * ") {
								count++;
							}
							if(field[x - 1][y] == " * ") {
								count++;
							}
						} else {
							if(field[x - 1][y - 1] == " * ") {
								count++;
							}
							if(field[x][y - 1] == " * ") {
								count++;
							}
							if(field[x - 1][y] == " * ") {
								count++;
							}
							if(field[x - 1][y + 1] == " * ") {
								count++;
							}
							if(field[x][y + 1] == " * ") {
								count++;
							}
						}
					}
					if(y == 0 && x != 0 && x != field.length-1) {
						if(field[x - 1][y] == " * ") {
							count++;
						}
						if(field[x + 1][y] == " * ") {
							count++;
						}
						if(field[x - 1][y + 1] == " * ") {
							count++;
						}
						if(field[x][y + 1] == " * ") {
							count++;
						}
						if(field[x + 1][y + 1] == " * ") {
							count++;
						}
					}
					if(y == field.length - 1 && x != 0 && x != field.length - 1) {
						if(field[x - 1][y - 1] == " * ") {
							count++;
						}
						if(field[x][y - 1] == " * ") {
							count++;
						}
						if(field[x + 1][y - 1] == " * ") {
							count++;
						}
						if(field[x - 1][y] == " * ") {
							count++;
						}
						if(field[x + 1][y] == " * ") {
							count++;
						}
					}
				}
				
				if (field[x][y] != " * ") {					
					field[x][y] = " " + count + " ";
				}
			}
		}
	}
	
	public void playerTurn(int num1, int num2) {
		int x = num1 - 1;
		int y = num2 - 1;
		
		count--;
		
//		if(field[x][y].equals(" 0 ") == true) {
//			if(field[x - 1][y - 1]) {
//				display[x-1][y-1] = field[x - 1][y - 1];
//			}
//		}
		if(!field[x][y].equals(" * ") == true) {
			display[x][y] = field[x][y];
		}else {
			isDone = true;
			display = field;
		}
	}
	
	public void cascade() {
		
	}
		

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






























