public class Ships {
	
	private int length;
	private String name;
	private int[][] coordinates;
	
	public Ships(String name, int length) {
		this.name = name;
		this.length = length;
		coordinates = new int[length][2];
	}
	
	public void setShipCoordinate(int startRow, int startCol, String dir, int lengthRemaining) {
		coordinates[0][0] = startRow;
		coordinates[0][1] = startCol;

		if(lengthRemaining == 0) {
			return;
		}
		
		if(dir.equals("up")) {
			coordinates[lengthRemaining][0] = coordinates[0][0] - lengthRemaining;
			coordinates[lengthRemaining][1] = coordinates[0][1];
		}
		
		if(dir.equals("down")) {
			coordinates[lengthRemaining][0] = coordinates[0][0] + lengthRemaining;
			coordinates[lengthRemaining][1] = coordinates[0][1];
		}
		
		if(dir.equals("left")) {
			coordinates[lengthRemaining][0] = coordinates[0][0];
			coordinates[lengthRemaining][1] = coordinates[0][1] - lengthRemaining;
		}
		
		if(dir.equals("right")) {
			coordinates[lengthRemaining][0] = coordinates[0][0];
			coordinates[lengthRemaining][1] = coordinates[0][1] + lengthRemaining;
		}
		
		setShipCoordinate(startRow, startCol, dir, lengthRemaining - 1);
		
		
	}
	
	public boolean isValid(String[][] board, int r, int c) {
		if(board[r][c].equals("-")) {
			return true;
		}
		
		return false;
	}
	
	public int[][] getCoordinates(){
		return coordinates;
	}
	
	public String getID() {
		return name.charAt(0) + "";
	}
	
	public String getName() {
		return name;
	}
	
	public int getLength() {
		return length;
	}

}

