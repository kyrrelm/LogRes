package oving4;

import java.io.Serializable;

public class Board implements Cloneable {


	
	private final int lengthOfSides;
	private final int maxNumberOfEggs;
	private boolean[][] board;
	private final int maxScore;
	private final double penaltyModifier;

	public Board(int lengthOfSides, int maxNumberOfEggs, double penaltyModifier){
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
	
	/**
	 * This is the actual object function.
	 * @return a value between 0.0001 and 1
	 */
	public double evaluate() {
		return (Math.max(((double)getNumberOfEggs()-(double)calculateNumberOfFaults()*penaltyModifier), 0.0001)/(double)maxScore);
	}
	/**
	 * 
	 * @return number of eggs on the board
	 */
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
	/**
	 * This method calculates the number of violations of max eggs per row/column/diagonal
	 * @return
	 */
	private int calculateNumberOfFaults(){
		int numberOfFaults = 0;
		for (int i = 0; i < board.length; i++) {
			if (!isColumnLegal(i))
				numberOfFaults++;
			if (!isRowLegal(i))
				numberOfFaults++;
			if (!isDiagonalLegalRightToLeft(0, i))
				numberOfFaults++;
			if (i > 0 && !isDiagonalLegalRightToLeft(i, board[0].length-1))
				numberOfFaults++;
			if (!isDiagonalLegalLeftToRight(0, i))
				numberOfFaults++;
			if (i > 0 && !isDiagonalLegalLeftToRight(i, 0));
		}
		return numberOfFaults;
	}
	/**
	 * Checks if a column is legal
	 * @param column
	 * @return
	 */
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
	/**
	 * Cheks if a row is legal
	 * @param row
	 * @return
	 */
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
	/**
	 * checks if a diagonal going from left down to right is legal
	 * @param height
	 * @param width
	 * @return
	 */
	private boolean isDiagonalLegalLeftToRight(int height, int width){
		int count = 0;
		if(height == 0){
			for (int i = 0; i < board.length-width; i++) {
				if(board[i][width+i])
					count++;
			}
		}else{
			for (int i = 0; i < board.length-height; i++) {
				if (board[height+i][i]) {
					count++;
				}
			}
		}
		if(count > maxNumberOfEggs)
			return true;
		return true;
	}
	/**
	 * checks if a diagonal is legal going from right down to left
	 * @param height
	 * @param width
	 * @return
	 */
	private boolean isDiagonalLegalRightToLeft(int height, int width){
		int count = 0;
		if(height == 0){
			for (int i = 0; i <= width; i++) {
				if(board[i][width-i])
					count++;
			}
		}else{
			for (int i = 0; i < board.length-height; i++) {
				if (board[height+i][width-i]) {
					count++;
				}
			}
		}
		if (count > maxNumberOfEggs)
			return false;
		return true;
	}
	
	public void flipEgg(int x, int y) {
		board[y][x] = !board[y][x];
	}
	
	public int getMaxScore() {
		return maxScore;
	}
	public boolean[][] getArray(){
		return board;
	}
	
	@Override
	protected Board clone() throws CloneNotSupportedException {
		return (Board) super.clone();
	}
}
