package oving3;

import java.util.ArrayList;

public class AStarCheckers extends AStarAlgorithm {
	
	private String goal;
	
	public AStarCheckers(Node n, String goal) {
		super(n);
		this.goal = goal;
		
	}
	
	//Name sais it all. The red Pieces will get a better score if they are closer to the left, and opposite for black.
	protected void calculateEstimatedCostToGoal(Node n) {
		int cost = 0;
		String state = n.getState();
		
		for(int i=0; i< state.length(); i++) {
			switch(state.charAt(i)) {
			case 'B':{ cost -=i; break;}
			case 'R': cost +=i;
			}
			n.setEstimatedCostToGoal(cost);
		}
	}
	
	//Generating all the Nodes children.
	protected void generateChildren(Node n) {
		char[] state = n.getState().toCharArray();
		
		int empty = -29;
		for (int i=0; i<state.length; i++) {
			if(state[i]== '0')
				empty = i;
		}
		char[] newState = new char[n.getState().length()];
		
		//This is pretty bad with reoccurring blocks of code, should have made another method to reduce reoccurrance.
		if(empty > 1) {
			newState = state.clone();
			change(empty, empty-2, newState);
			n.addChild(new Node(new String(newState)));
		} if(empty > 0) {
			newState = state.clone();
			change(empty, empty-1, newState);
			n.addChild(new Node(new String(newState)));
		} if(empty < state.length-1) {
			newState = state.clone();
			change(empty, empty+1, newState);
			n.addChild(new Node(new String(newState)));
		} if(empty < state.length-2) {
			newState = state.clone();
			change(empty, empty+2, newState);
			n.addChild(new Node(new String(newState)));
		}	
	}

	//Method generateChildren uses to change position on places in states
	private void change(int x, int y, char[] state) {
		char temp = state[x];
		state[x] = state[y];
		state[y] = temp;
	}
	
	/**
	 * In this problem the cost'll always be the same, 
	 * but the method have to be implemented in case of a weighted graph.
	 * @param x
	 * @param y
	 * @return
	 */
	protected int estimatedCostBetween(Node x, Node y) {
		return 1;
	}
	
	//Checks for match.
	protected boolean isSolution(Node n) {
		return n.getState() == goal;
	}
}
