import java.util.Scanner;


public class PlayerPersonWithGui extends Player {
	
	private VisibleBoard personVisible = new VisibleBoard();
	private HiddenBoard personHidden = new HiddenBoard();
	private Ships carrier = new Ships("Carrier", 5);
	private Ships submarine = new Ships("Submarine", 4);
	private Ships destroyer = new Ships("Destroyer", 3);
	private Scanner in = new Scanner(System.in);
	GUI b = new GUI();
	
	public PlayerPersonWithGui(String name) {
		super(name);
		
		setShips();
	}
	
	public void setOneShip(Ships s) {

		String sn = b.setShip(s, personHidden.getHidden());
		System.out.println("Running");
		int row = Integer.valueOf(sn)/10;
		int col = Integer.valueOf(sn)%10;
		System.out.println("Stage 1");
		System.out.println(row);
		while(!(personHidden.isValidStarting(row, col))) {
			System.out.println("Invalid starting coordinate, this spot has already been taken.");

			System.out.print("Please enter another starting column for the " + s.getName() + " --> ");
			row = getValid();

			System.out.print("Please enter another starting row for the " + s.getName() + " --> ");
			col = getValid();

		}
		
		sn = b.setShip(s, personHidden.getHidden());
		int endRow = Integer.valueOf(sn)/10;
		int endCol = Integer.valueOf(sn)%10;
		System.out.println(endRow);
		
		String dir = "";
		System.out.println("---");
		System.out.println(row - endRow - 1);
		System.out.println(endRow - row - 1);
		System.out.println(endCol - col - 1);
		System.out.println(col - endCol - 1);
		
		if (row - endRow - 1== -1 * s.getLength()) {
			dir = "down";
		}
		if (endRow - row - 1 == -1 * s.getLength()) {
			dir = "up";
		}
		if (endCol - col + 1== s.getLength()) {
			dir = "right";
		}
		if (col - endCol + 1 == s.getLength()) {
			dir = "left";
		}
		System.out.println(dir);
		System.out.println("dninbdingbidgnbdignb");
		
		if (dir.contentEquals("")) {
			b.sendErrorMessage("You cannot place a ship there. The ship must have a length of " + s.getLength());
			setOneShip(s);
			return;
		}
		
		s.setShipCoordinate(row, col, dir, s.getLength() - 1);
		setShipHidden(s.getCoordinates(), s.getID());
		Board.printBoard(personHidden.getHidden());
		System.out.println(row);
		System.out.println(endRow);
		
	}
	
	public void setShips() {
		Board.printBoard(personHidden.getHidden());
		System.out.println();
		setOneShip(carrier);
		System.out.println();
		setOneShip(submarine);
		System.out.println();
		setOneShip(destroyer);
		
	}
	
	private void setShipHidden(int[][] coord, String id) {
		for(int row = 0; row < coord.length; row++) {
			personHidden.setHiddenBoard(coord[row][0], coord[row][1], id);
		}
	}
	
	
	private int getValid() {
		int test = in.nextInt();
		boolean valid = true;
		
		if(test < 0 || test > 9) {
			valid = false;
		} else {
			valid = true;
		}
		
		
		while(!valid) {
			System.out.print("Invalid coordinate, enter a valid coordinate from 0 to 9--> ");
			
			test = in.nextInt();
			if(test < 0 || test > 9) {
				valid = false;
			} else {
				valid = true;
			}

		}
		
		return test;
	}
	
	private String getValidDirection() {
		String dir = in.next();
		dir = dir.toLowerCase();
		
		boolean valid = (dir.equals("right")) || (dir.equals("left")) || (dir.equals("up")) || (dir.equals("down"));
		
		while(!valid) {
			System.out.print("Invalid direction, please enter left, right, up, or down --> ");

			dir = in.next();
			dir = dir.toLowerCase();
			
			valid = (dir.equals("right")) || (dir.equals("left")) || (dir.equals("up")) || (dir.equals("down"));

		}
		
		return dir;
	
	}
	
	public VisibleBoard getVisible() {
		return personVisible;
	}
	
	public HiddenBoard getHidden() {
		return personHidden;
	}
	
	public void printHidden() {
		Board.printBoard(personHidden.getHidden());
	}
	
	public void printVisible() {
		Board.printBoard(personVisible.getBoard());
	}

	public String[][] getHiddenBoard(){
		return personHidden.getHidden();
	}
	
	
	
}
