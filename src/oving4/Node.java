package oving4;

public class Node {
	
	private boolean egg = false;
	
	private final int x;
	private final int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public boolean isEgg() {
		return egg;
	}
	
	public void setEgg(boolean egg) {
		this.egg = egg;
	}

	public void invert() {
		this.egg = !egg;
	}
	
	public int[] getLocation() {
		int[] loc = new int[2];
		loc[0] = x;
		loc[1] = y;
		return loc;
	}

}
