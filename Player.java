import java.util.*;

public abstract class Player{
	
	private String name;

	public Player(String name) {
		this.name = name;
	}	
	
	public abstract void setShips();
	
	public String getName() {
		return name;
	}
}

