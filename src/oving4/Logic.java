package oving4;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Logic {
	
	private Board board;
	private Random random;
	
	private int sides;
	
	// The global values used.
	private final double penaltyModifier = 1.5;
	private final int dTemp = 1;
	private int tempMax = 2000;
	private Board best = null;		//Note: Doesn't work properly
	
	/**
	 * The logic class initiation
	 * @param sides				Number of columns and rows
	 * @param maxNumberOfEggs	Max number of eggs in one row/column/diagonally
	 */
	public Logic(int sides, int maxNumberOfEggs){
		this.board = new Board(sides, maxNumberOfEggs, penaltyModifier);
		this.sides = sides;
		random = new Random();
		generateBoard();
		tempMax = sides*5000; //Seting the max value, alter as you like
	}
	
	/**
	 * Generates a board with the maximum valid number of eggs on it.
	 */
	public void generateBoard(){
		for(int i=0; i<board.getMaxScore(); i++) {
			while(true) {
				int r1 = random.nextInt(sides);
				int r2 = random.nextInt(sides);
				if(!board.isEgg(r1, r2)) {
					board.setEgg(r1, r2, true);
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
		//Setting the current Node (P in the description-algorithm for the exercise)
		Board current = board;
		best = board;
		int t = tempMax;
		double q;
		//Only exit if a valid optimal solution is found or the temperature is used up.
		while(current.evaluate() < 1 && t>0) {
			//Generate close neighbors.
			ArrayList<Board> neighbors = getNeighbors(current);
			//Variable for: The highest evaluation number of the neighbors
			double fpMax = 0;
			//Variable for: The best neighbor
			Board pMax = null;
			//Search for the best neighbor
			for(Board n : neighbors) {
				double nScore = n.evaluate();
				if(nScore > fpMax){
					fpMax = nScore;
					pMax = n;
				}
			}
			//The difference between the current and a neighbors evaluation
			q = neighbors.get(0).evaluate()-current.evaluate();
			double temp = (double)t/100 - q;
			//A random generated number in range [0,1]
			double x = Math.random();
			//Exploiting
			if(x>temp){
				current = pMax;
			//Exploring
			} else {
				current = neighbors.get(random.nextInt(neighbors.size()));
			}
			//Change the temperature.
			t -= dTemp;			
			if(fpMax > current.evaluate()) {
//				try{
//					best = pMax.clone();
//				} catch(CloneNotSupportedException e) {
					best = pMax;
//				}
			}
//			System.out.println(current.evaluate());
		}
		System.out.println("Score: "+current.evaluate());
		return best;
	}
	
	/**
	 * Generates semi-random neighbors from the given board
	 * @param b		The board the neigbors will be generated from
	 * @return		An ArrayList containing the neighbors
	 */
	public ArrayList<Board> getNeighbors(Board b) {
		ArrayList<Board> neighbors = new ArrayList<Board>();
		for(int i=0; i<5; i++) {
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
			
			//Try to find a random legal move for the egg.
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
		}
		return neighbors;	
	}
}

/* ------------- Previous not working code kept to draw on later -------------------

	public Board simmulatedAnnealing() {
		System.out.println("Algorithm running");
		Board best = board, current = board;
		for(int temp=500; temp>0; temp--) {
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
			double score = pMax.evaluate();
			if(score <= current.evaluate()){
				current = pMax;
				if(pMax.evaluate() <= best.evaluate()) {
					best = pMax;
					if(pMax.evaluate() == 1)
						return pMax;
				}
			} else if(((current.evaluate()-pMax.evaluate())/temp)> Math.random())
				current = neighbors.get(random.nextInt(neighbors.size()));	
		}
		return best;
	}
	

	
	
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
				double nScore = n.evaluate();
				if(nScore >= fpMax) {
					fpMax = nScore;
					pMax = n;
				}
			}
			double q = fpMax-fP;//((fpMax-fP)/fP);
			double p = (double)tempMax/100 - q;//Math.min(1, Math.pow(Math.E, ((-q)/temp)));
			double x = Math.random();
//			System.out.println(x+" - "+p);
			if(pMax.evaluate()>= current.evaluate())
				best = pMax;
			if(x>p) {
				current = pMax;												//Exploiting
//				System.out.println("asdfghjk");
			}
			else 
				current = neighbors.get(random.nextInt(neighbors.size()));	//Exploring
			temp -=dTemp;
			fP = current.evaluate();
			if(current.evaluate() > best.evaluate())
				best = current;
		}
		System.out.println("Best:"+ best.evaluate());
		return best;
	}



neighbors:

			//Generate semi-random neighbors.
			switch(i) {
			case 0: { n.setEgg(random.nextInt(sides), random.nextInt(sides), false); break;	} 	//remove 1 egg (if exists)
			case 1: {} 																			//Place 1 egg
			case 2: { n.setEgg(random.nextInt(sides), random.nextInt(sides), true); break; }	//Place 1 egg
			case 3: { n.flipEgg(random.nextInt(sides), random.nextInt(sides));	} 				//Inverse 2 eggs
			default: {n.flipEgg(random.nextInt(sides), random.nextInt(sides)); 	} 				//Inverse 1 egg
			}
			neighbors.add(n);




 */


