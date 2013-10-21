package oving4;

public class Board {

	
	private final int lengthOfSides;
	private final int maxNumberOfEggs;
	private boolean[][] board;
	private final int maxScore;
	private final int penaltyModifier;

	public Board(int lengthOfSides, int maxNumberOfEggs, int penaltyModifier){
		this.lengthOfSides = lengthOfSides;
		this.maxNumberOfEggs = maxNumberOfEggs;
		board = new boolean[lengthOfSides][lengthOfSides];
		this.maxScore = lengthOfSides*maxNumberOfEggs;
		this.penaltyModifier = penaltyModifier;
		
		
	}
	public void setEgg(int width, int height, boolean b){
		board[height][width] = b;
	}
	public boolean isEgg(int width, int height){
		return board[height][width];
	}
	public double evaluate() {
		return (getNumberOfEggs()-calculateNumberOfFaults()*penaltyModifier)/maxNumberOfEggs;
	}
	private int getNumberOfEggs() {
		int n = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j]) {
					n++;
				}
			}
		}
		return n;
	}
	private int calculateNumberOfFaults(){
		int numberOfFaults = 0;
		for (int i = 0; i < board.length; i++) {
			if (!isColumnLegal(i))
				numberOfFaults++;
			if (!isRowLegal(i))
				numberOfFaults++;
		}
		return numberOfFaults;
	}
	public boolean isColumnLegal(int column){
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][column]) {
				count++;
			}
		}
		if (count > maxNumberOfEggs) {
			return false;
		}
		return true;
	}
	public boolean isRowLegal(int row){
		int count = 0;
		for (int i = 0; i < board[row].length; i++) {
			if (board[row][i]) {
				count++;
			}
		}
		if (count > maxNumberOfEggs) {
			return false;
		}
		return true;
	}
	public boolean isDiagonalLegal(int height, int width){
		return true;
//		int count = 0;
//		if(height == 0){
//			for (int i = 0; i <= Math.min(height, width); i++) {
//				if(board[i][width-i])
//					count++;
//			}
//		}
//		
//		int ii = width;
//		int uu = height;
//		if(height > width) {
//			ii = height;
//			uu = width;
//		}
//		
//		for(int u=0; u<=ii;u++) {
//			count = 0;
//			for(int j=0+u, i=0; i+u<height; i++, j++) {
//				if(board[i][j+u])
//					count++;
//				if(count>2) {
//					return false;
//				}
//			}
		}
}
