
public class HiddenBoard extends Board{
	
	private String[][] hidden = new String[getLength()][getLength()];
	private final String EMPTY = "-";
	private final String HIT = "X";
	private final String MISS = "O";
	
	public HiddenBoard() {
		for(int row = 0; row < hidden.length; row++) {
			for(int col = 0; col < hidden[row].length; col++) {
				hidden[row][col] = EMPTY;
			}
		}
	}
	
	public void hit(int r, int c) {
		hidden[r][c] = HIT;
	}

	public void miss(int r, int c) {
		hidden[r][c] = MISS;
	}

	public void setHiddenBoard(int r, int c, String id) {
		hidden[r][c] = id;
	}
	
	public String[][] getHidden(){
		return hidden;
	}
	
	public boolean hasLost() {
				
		int counter = 0;
		for (int row = 0; row < hidden.length; row++) {
			for (int col = 0; col < hidden[row].length; col++) {
				if (hidden[row][col].equals(HIT)) {
					counter++;
				}
			}
		}
		System.out.println(counter);
		if (counter == 12) {
			return true;
		}
		return false;
	}
	
	public boolean isValidStarting(int r, int c) {
		if(hidden[r][c].equals(EMPTY)) {
			return true;
		}
		
		return false;
	}
	
	public boolean isValidDirection(int c, int r, int length, String dir) {
		String direction = dir.toLowerCase();
		int dirCase = 0;
		
		if(direction.equals("up")) {
			dirCase = 1;
		}
		
		if(direction.equals("down")) {
			dirCase = 2;
		}

		if(direction.equals("left")) {
			dirCase = 3;
		}

		if(direction.equals("right")) {
			dirCase = 4;
		}
		
		switch(dirCase) {
			case 1:
				if(r < length - 1) {
					return false;
				}
				
				for(int x = 0; x < length; x++) {
					if(!(hidden[r - x][c].equals(EMPTY))) {
						return false;
					}
				}
				
				return true;
				
			case 2:
				if(r > getLength() - length) {
					return false;
				}
				
				for(int x = 0; x < length; x++) {
					if(!(hidden[r + x][c].equals(EMPTY))) {
						return false;
					}
				}
				
				return true;
				
			case 3:
				if(c <  length - 1) {
					return false;
				}
				
				for(int x = 0; x < length; x++) {
					if(!(hidden[r][c - x].equals(EMPTY))) {
						return false;
					}
				}
				
				return true;

			case 4:
				if(c > getLength() - length) {
					return false;
				}
				
				for(int x = 0; x < length; x++) {
					if(!(hidden[r][c + x].equals(EMPTY))) {
						return false;
					}
				}
				
				return true;
			
			default:
				return false;
				

		}
	}
	
	public boolean didHit(int r, int c) {
		
		if(hidden[r][c].equals(EMPTY)) {
			return false;
		}
		
		return true;
	}


}
