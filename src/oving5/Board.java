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
		
		
		//row
		for(int i=0; i<k; i++){
			board[]
		}
		
		return -1;
	}
	
	
	public List<Square> GetQueensInConflict() {
		return null;
	}
	
	
	public List getOrderedListOfSquares() {
		PriorityQueue<Square> list = new PriorityQueue<Square>();
		return null;
	}
	
}
