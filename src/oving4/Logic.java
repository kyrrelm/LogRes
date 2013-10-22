package oving4;

import java.util.ArrayList;
import java.util.Random;

public class Logic {
	
	private Board board;
	private Random random;
	
	private int sides;
	
	// The global values used.
	private final double penaltyModifier = 1.5;
	private final int dTemp = 1;
	private final int tempMax = 2000;
	
	
	public Logic(int sides, int maxNumberOfEggs){
		this.board = new Board(sides, maxNumberOfEggs, penaltyModifier);
		this.sides = sides;
		random = new Random();
		generateBoard(board);
		
	}
	
	public void generateBoard(Board b){
		System.out.println(board.getMaxScore());
		for(int i=0; i<board.getMaxScore(); i++) {
			while(true) {
				int r1 = random.nextInt(sides);
				int r2 = random.nextInt(sides);
				if(b.isEgg(r1, r2)) {
					b.setEgg(r1, r2, true);
					break;
				}	
			}
		}
	}
	
	
	/**
	 * The Simmulated Annealing Algorithm!
	 * @return	Returns the best board solution found.
	 */
	public Board saAlgorithm() {
		System.out.println("Algorithm running...");
		Board current = board;
		Board best = current;
		int temp = tempMax;
		double fP = current.evaluate();
		while(fP < 1 && temp != 0) {
			System.out.println(fP);
			ArrayList<Board> neighbors = getNeighbors(current);
			double fpMax = 0;
			Board pMax = null;
			for(Board n : neighbors) {
				double nScore = board.evaluate();
				if(nScore > fpMax) {
					fpMax = nScore;
					pMax = n;
				}
			}
			double q = ((fpMax-fP)/fP);
			double p = Math.min(1, Math.pow(Math.E, ((-q)/temp)));
			double x = Math.random();
//			System.out.println(x+" - "+p);
			if(x>p) {
				current = pMax;	
				System.out.println("asdfghjk");//Exploiting
			}
			else 
				current = neighbors.get(random.nextInt(neighbors.size()));	//Exploring
			temp = temp - dTemp;
			fP = current.evaluate();
/*			if(current.evaluate() > best.evaluate())
				best = current;
*/		}
		System.out.println("Best:"+ best.evaluate());
		return current;
	}
	
	/**
	 * Generates semi-random neighbors from the given board
	 * @param b		The board the neigbors will be generated from
	 * @return		An ArrayList containing the neighbors
	 */
	public ArrayList<Board> getNeighbors(Board b) {
		ArrayList<Board> neighbors = new ArrayList<Board>();
		for(int i=0; i<7; i++) {
			Board n = null;
			
			//Try to clone the Board
			try {
				n = b.clone();
			} catch (CloneNotSupportedException e) {
				System.out.println("Fail! Hva skjer?");
				e.printStackTrace();
			}
			
			//Find a random egg.
			int eggX = 0;
			int eggY = 0;
			while(true){
				int rx = random.nextInt(sides);
				int ry = random.nextInt(sides);
				if(n.isEgg(rx, ry)){
					eggX = rx;
					eggY = ry;
					break;
				}
			}
			
			//Try to find a legal move.
			while(true) {
				int r1 = random.nextInt(sides);
				int r2 = random.nextInt(sides);
				if(!n.isEgg(r1, r2)) {
					n.setEgg(r1, r2, true);
					n.setEgg(eggX, eggY, false);
					break;
				}	
			}
			neighbors.add(n);
			
			//Generate semi-random neighbors.
/*			switch(i) {
			case 0: { n.setEgg(random.nextInt(sides), random.nextInt(sides), false); break;	} 	//remove 1 egg (if exists)
			case 1: {} 																			//Place 1 egg
			case 2: { n.setEgg(random.nextInt(sides), random.nextInt(sides), true); break; }	//Place 1 egg
			case 3: { n.flipEgg(random.nextInt(sides), random.nextInt(sides));	} 				//Inverse 2 eggs
			default: {n.flipEgg(random.nextInt(sides), random.nextInt(sides)); 	} 				//Inverse 1 egg
			}
			neighbors.add(n);
*/		}
		return neighbors;	
	}
}
