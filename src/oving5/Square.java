package oving5;

public class Square {

	private boolean queen;
	private final int posX;
	private final int posY;
	private int numperOfConflicts;
	
	public Square(int posX, int posY){
		
		this.posX = posX;
		this.posY = posY;
	}

	public boolean isQueen() {
		return queen;
	}

	public void setQueen(boolean queen) {
		this.queen = queen;
	}

	public int getNumperOfConflicts() {
		return numperOfConflicts;
	}

	public void setNumperOfConflicts(int numperOfConflicts) {
		this.numperOfConflicts = numperOfConflicts;
	}
	
	
}
