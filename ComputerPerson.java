import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Random.*;

public class ComputerPerson extends Player {
	
	private VisibleBoard personVisible = new VisibleBoard();
	private HiddenBoard personHidden = new HiddenBoard();
	private ArrayList <Ships> shipList = new ArrayList <Ships>();

	private Random r = new Random();
	
	public ComputerPerson(String name) {
		super(name);
		shipList.add(new Ships("Carrier", 5));
		shipList.add(new Ships("Submarine", 4));
		shipList.add(new Ships("Destroyer", 3));

		setShips();

	}
	
	public void setOneShip(Ships s) {
		int row = getValid();
		
		int col = getValid();
		
		while(!(personHidden.isValidStarting(row, col))) {
			row = getValid();

			col = getValid();

		}
		
		String dir = getValidDirection();
		
		while(!(personHidden.isValidDirection(row, col, s.getLength(), dir))) {
			dir = getValidDirection();
		}
		
		s.setShipCoordinate(col, row, dir, s.getLength() - 1);
		setShipHidden(s.getCoordinates(), s.getID());

		
	}
	
	public void setShips() {
		Iterator i = shipList.iterator();
		
		while(i.hasNext()) {
			System.out.println();
			setOneShip((Ships)i.next());
			
		}
		
	}
	
	private void setShipHidden(int[][] coord, String id) {
		for(int row = 0; row < coord.length; row++) {
			personHidden.setHiddenBoard(coord[row][0], coord[row][1], id);
		}
	}
	
	public int getValid() {

		int test = r.nextInt(10);
		
		boolean valid = true;
		
		if(test < 0 || test > 9) {
			valid = false;
		} else {
			valid = true;
		}
		
		
		while(!valid) {
			
			test = r.nextInt(10);
			if(test < 0 || test > 9) {
				valid = false;
			} else {
				valid = true;
			}

		}

		return test;
	}
	
	private String getValidDirection() {
		String dir = "";
		
		int dirIndex = r.nextInt(4);
		if(dirIndex == 0) {
			dir = "left";
		}

		if(dirIndex == 1) {
			dir = "up";
		}

		if(dirIndex == 2) {
			dir = "right";
		}

		if(dirIndex == 3) {
			dir = "down";
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
	
	public String[][] getComputerVisibleBoard(){
		return personVisible.getBoard();
	}
	
	
	
}
