package oving3;

import java.util.Scanner;
import java.util.Timer;

public class KChecker {
	
	private static int NmbrCheckers;
	
	@SuppressWarnings("resource")
	public static void main(String[]args) {
		
		
		//Asking for the size of the problem to solve, as number of checkers pieces.
		Scanner input = new Scanner(System.in);
		System.out.print("How many Checkers pieces shall be used in the algorithm?\nINPUT: ");
		NmbrCheckers = input.nextInt(); 
	
		String startState = ""; //Black = B, red = R, empty = 0, EG: BBB0RRR;
		
		//Creating and filling the checkers-board.
//		Node[] checkers = new Node[NmbrCheckers+1];
		for(int i=0; i<=NmbrCheckers; i++) {
//			Node c;
			if(i==NmbrCheckers/2) {
				startState += "0";
			}
			else if(i < NmbrCheckers/2){
//				c = new Node(null, (i==0 ? null : checkers[i-1]), 0, 0, Color.RED);
				startState += "B";
			}else {
//				c = new Node(null, (i==0 ? null : checkers[i-1]), 0, 0, Color.BLACK);
				startState += "R";
			}
//			checkers[i] = c;
		}
		//Defining the Goal state.
		String goalState = new StringBuilder(startState).reverse().toString();
		
		System.out.println("****Begining calculation****");
		//timing the runtime of the algorithm.
		long startTime = System.nanoTime();
		Timer timer = new Timer();
		Node n0 = new Node(startState);
		System.out.println(startState);
		
		AStarCheckers aStar = new AStarCheckers(n0, goalState); 
//		int result = aStar.Checkers(checkers, startState, goalState); //Execute A* algorithm
//		aStar
		
		aStar.bestFirstSearch();
		long duration = (long)(System.nanoTime() - startTime)/1000000;
		
		//Printing the results.
		System.out.println("The A* algorithm executed in "+duration+" milliseconds");
			
	}
}