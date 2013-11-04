package oving5;

import java.util.List;
import java.util.PriorityQueue;

public class Board {

	public final int k;
	
	private Square[][] board;
	
	public Board(int k) {
		this.k = k;
		board = new Square[k][k];
		//Initializing the board with squares.
		for(int y=0; y<k; y++){
			for(int x=0; x<k; x++){
				board[y][x] = new Square(x, y);
			}
		}
	}
	
	public int checkSquare(Square s) {
		
		int conflicts = 0;

		int sX = s.getPosX();
		int sY = s.getPosY();
		
		for(int i=0; i<k; i++){
			//row
			if(board[sY][i].isQueen()) {
				if(s.getPosX() != i)
					conflicts++;
			}
			//column
			if(board[i][sX].isQueen()) {
				if(s.getPosY() != i)
					conflicts++;
			}
			//diagonals
			if(!(sX+i<k)){
				if(!(sY+i<k)){
				}
			}
		}
		
		return -1;
	}
	
	
	public List<Square> getQueensInConflict() {
		return null;
	}
	
	
	public PriorityQueue getOrderedListOfSquares() {
		PriorityQueue<Square> list = new PriorityQueue<Square>();
		return list;
	}
	
}
