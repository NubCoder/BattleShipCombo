import java.util.Random;

public class Board {


	private final int LENGTH = 10;
	

	
	public Board() {
		
	}
	
	public static void printBoard(String[][] board) {
		System.out.print("  ");
		for(int row = 0; row < board.length; row++) {
			System.out.print(row + " ");
		}
		System.out.println();
		
		for(int row = 0; row < board.length; row++) {
			System.out.print(row + " ");
			for(int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	public int getLength() {
		return LENGTH;
	}


	
	
	
	
}
