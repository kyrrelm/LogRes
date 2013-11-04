package oving5;

public class Square implements Comparable<Square> {

	private boolean queen;
	private final int posX;
	private final int posY;
	private int numberOfConflicts;
	
	public Square(int posX, int posY){
		
		this.posX = posX;
		this.posY = posY;
		this.queen = false;
	}

	public boolean isQueen() {
		return queen;
	}

	public void setQueen(boolean queen) {
		this.queen = queen;
	}

	public int getNumberOfConflicts() {
		return numberOfConflicts;
	}

	public void setNumperOfConflicts(int numperOfConflicts) {
		this.numberOfConflicts = numperOfConflicts;
	}

	@Override
	public int compareTo(Square o) {
		if(this.numberOfConflicts > o.numberOfConflicts)
			return 1;
		if(this.numberOfConflicts < o.numberOfConflicts)
			return -1;
		return 0;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	
}
