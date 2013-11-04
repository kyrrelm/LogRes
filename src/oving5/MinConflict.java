package oving5;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class MinConflict {

	private Board board;
	private int maxSteps;
	
	public MinConflict(int maxSteps, Board boardWithInitialValues){
		this.board = boardWithInitialValues;
		this.maxSteps = maxSteps;
	}
	
	
	public boolean solve(){
		Random r = new Random();
		for (int i = 0; i <= maxSteps ; i++) {
			board.updateSquares();
			if(board.isSolved()){
				System.out.println("Number of iterations: "+i);
				return true;
			}
			List<Square> queensInConflict = board.getQueensInConflict();
			PriorityQueue<Square> pq = board.getOrderedQueueOfSquares();

			queensInConflict.get(r.nextInt(queensInConflict.size())).setQueen(false);
			pq.peek().setQueen(true);
		}
		
		return false;
	}
	public void printBoard(){
		System.out.println(board.toString());
	}
	
}