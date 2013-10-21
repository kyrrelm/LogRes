package oving4;

public class Board {

	
	private final int width;
	private final int height;
	private final int maxNumberOfEggs;
	private boolean[][] board;

	public Board(int width, int height, int maxNumberOfEggs){
		this.width = width;
		this.height = height;
		this.maxNumberOfEggs = maxNumberOfEggs;
		board = new  boolean[height][width]; 
	}
	public void insertEgg(int width, int height){
		board[height][width] = true;
	}
	public void removeEgg(int width, int height){
		board[height][width] = false;
	}
	public boolean hasEgg(int width, int height){
		return board[height][width];
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
}
