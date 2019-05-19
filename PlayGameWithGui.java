import java.util.Scanner;


public class PlayGameWithGui {
	
	private PlayerPersonWithGui p;
	private Scanner in = new Scanner(System.in);
	private ComputerPerson c;
	private int turn = 0;
	private static GUI g = new GUI();
	
	
	public PlayGameWithGui() {
		preGame();
		currentGame();
		
	}
	
	public void preGame() {
		
		String name = g.preQuestions();
		System.out.println(name);
		p = new PlayerPersonWithGui(name);
		c = new ComputerPerson("bot");
		
		
		
		
		
	}
	
	public void currentGame() {
		
		
		
		System.out.println("\nYour opponents board: ");
		c.printVisible();
		System.out.println();

		
		while(!c.getHidden().hasLost() && !p.getHidden().hasLost()) {
			
			if (turn % 2 == 0) {
				String sbn = g.printBoard(p.getHiddenBoard(), c.getComputerVisibleBoard());
				System.out.println("Input received");
				onePersonTurn(Integer.parseInt(sbn)/10, Integer.parseInt(sbn)%10);
			} else {
				oneBotTurn();
				
			}
			
		}
		
		if(p.getHidden().hasLost() == false) {
			System.out.println("Congratulations, you've won!");
			g.sendErrorMessage("Congratulations!!! You won!!!");
		} else {
			System.out.println("Better luck next time!");
			g.sendErrorMessage("Better luck next time!");
		}
		
	}
	
	public void onePersonTurn(int potentialRow, int potentialCol) {
		turn++;
		boolean already = c.getVisible().alreadyShot(potentialRow, potentialCol);
		
		while(already) {
			turn--;
			return;
		}
		
		boolean hit = c.getHidden().didHit(potentialRow, potentialCol);
		if(hit) {
			c.getVisible().hit(potentialRow, potentialCol);
			c.getHidden().hit(potentialRow, potentialCol);
			System.out.println();
			System.out.println("Nice job, you hit the opponent's ship!");

		} else {
			c.getVisible().miss(potentialRow, potentialCol);
			System.out.println();
			System.out.println("Try again next time!");
		}
		
		c.printVisible();
		System.out.println();
	}
	
	private void oneBotTurn() {
		turn++;
		int potentialCol = c.getValid();
		int potentialRow = c.getValid();
		
		boolean already = p.getVisible().alreadyShot(potentialRow, potentialCol);
		
		while(already) {
			potentialCol = c.getValid();
			potentialRow = c.getValid();
			already = p.getVisible().alreadyShot(potentialRow, potentialCol);
			
		}
		
		boolean hit = p.getHidden().didHit(potentialRow, potentialCol);
		if(hit) {
			p.getVisible().hit(potentialRow, potentialCol);
			p.getHidden().hit(potentialRow, potentialCol);
			System.out.println();
			System.out.println("Oh no, the opponent hit your ship!");
			
		} else {
			p.getVisible().miss(potentialRow, potentialCol);
			p.getHidden().miss(potentialRow, potentialCol);
			System.out.println();
			System.out.println("The opponent missed your ship!");
		}
		
		p.printHidden();
		System.out.println();

	}
	
	private int getRow() {
		System.out.print("Row --> ");
		int potentialRow = in.nextInt();
		
		while(potentialRow < 0 || potentialRow > 9) {
			System.out.print("Invalid row, please enter a row from 0 to 9 --> ");
			potentialRow = in.nextInt();
		}
		
		return potentialRow;
	}
	
	private int getCol() {
		System.out.print("Column --> ");
		int potentialCol = in.nextInt();
		
		while(potentialCol < 0 || potentialCol > 9) {
			System.out.print("Invalid column, please enter a column from 0 to 9 --> ");
			potentialCol = in.nextInt();
		}
		
		return potentialCol;
	}
	
	
	public static void main(String args[]) {
		PlayGameWithGui pg = new PlayGameWithGui();
	}
}
