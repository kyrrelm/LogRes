package oving4;

import java.util.ArrayList;

public class Logic {
	
	private Board board;
	private int tempMax;
	
	
	public Logic(Board board, int tempMax){
		this.board = board;
		this.tempMax = tempMax;

	}
	
	
	public void saAlgEggs() {

		int temp = tempMax;
		Board current = board;
//		Node current = board.getNode(0,0);
		while(true) {
			double fp = current.evaluate();
			if(score >= 1)
				break;
			ArrayList<Board> neighbors = getNeighbors(current);
			double pMax = 0;
			Node maxP = null;
			for(Node n : neighbors) {
				n.invert();
				double cScore = board.evaluate();
				if(cScore > pMax) {
					pMax = cScore;
					maxP = n;
				} else
					n.invert();
			}
			double q = ((pMax-score)/score);
			double p = Math.min(1, Math.pow(Math.E, ((-q)/temp)));
			double x = Math.random();
			if(x>p)
				current = maxP;
			else
				
			
			
			
			
			
			temp--;
			if(temp < 1)
				break;
		}
		
		
	}
	
	public ArrayList<Board> getNeighbors(Board b) {
		return null;
		
	}

}
