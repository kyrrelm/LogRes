package oving4;

public class Logic {
	
	private Board board;
	
	public Logic(Board board){
		this.board = board;
	}
	
	
	public void saAlgEggs() {
		boolean current = board.get(0,0);
		int temp = 500;
		while(true) {
			temp--;
			if(temp == 0)
				break;
			
		}
	}
/*	
	public void saAlgorithm() {
		//StartPos
		boolean[][] array;
		boolean current = array[0][0];
		int temp = 500;
		int num = board.getEggs();
		if(num >= target)
		
		
		
		
	}
*/
}
