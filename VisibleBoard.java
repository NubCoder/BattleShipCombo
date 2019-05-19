
public class VisibleBoard extends Board {
	
	private String[][] visible = new String[getLength()][getLength()];
	private final String HIT = "X";
	private final String MISS = "O";
	private final String EMPTY = "-";
	
	public VisibleBoard() {
		for(int row = 0; row < visible.length; row++) {
			for(int col = 0; col < visible[row].length; col++) {
				visible[row][col] = EMPTY;
			}
		}
	}
	
	public void hit(int r, int c) {
		visible[r][c] = HIT;
	}

	public void miss(int r, int c) {
		visible[r][c] = MISS;
	}
	
	public boolean alreadyShot(int r, int c) {
		if(visible[r][c].equals(EMPTY)) {
			return false;
		}
		
		return true;
	}
	
	public String[][] getBoard(){
		return visible;
	}

}
