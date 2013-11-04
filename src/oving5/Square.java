package oving5;

public class Square implements Comparable<Square> {

	private boolean queen;
	private final int posX;
	private final int posY;
	private int numperOfQueensAttacking;

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

	public int getNumperOfQueensAttacking() {
		return numperOfQueensAttacking;
	}

	public void setNumperOfQueensAttacking(int numperOfQueensAttacking) {
		this.numperOfQueensAttacking = numperOfQueensAttacking;
	}

	@Override
	public int compareTo(Square o) {
		if(this.numperOfQueensAttacking > o.numperOfQueensAttacking)
			return 1;
		if(this.numperOfQueensAttacking < o.numperOfQueensAttacking)
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
