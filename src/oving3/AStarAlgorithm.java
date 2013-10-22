package oving3;

import java.util.*;

public abstract class AStarAlgorithm {

	//Da dette er en generel algoritme deligeres dette ansvare til Implementasjonen.
	protected abstract void calculateEstimatedCostToGoal(Node node);
	protected abstract void generateChildren(Node node);
	protected abstract boolean isSolution(Node n);
	protected abstract int estimatedCostBetween(Node a, Node b);
	
	//Deklarasjon
	ArrayList<Node> closed; 
	ArrayList<Node> successors;
	PriorityQueue<Node> open;
	protected long solutionId = 0;
	boolean badHax = true;
	
	public AStarAlgorithm(Node startNode){
		open = new PriorityQueue<Node>();
		closed = new ArrayList<Node>();
		
		startNode.setEstimatedCostFromStart(0);
		calculateEstimatedCostToGoal(startNode);
		startNode.setEstimatedTotalCost(startNode.getEstimatedCostToGoal() + startNode.getEstimatedCostFromStart());
		open.add(startNode);
	}
	
	//A* bestFirst søk returnerer true hvis søket var vellykket, ellers false.
	public boolean bestFirstSearch(){
		while(badHax){
			System.out.print(".");
			if(open.isEmpty()) {
//				System.out.println("okey");
				return false;
			}
			Node current = open.poll();
			closed.add(current);	
			if(isSolution(current))
				if(isSolution(current)){
					System.out.println("Solution:\t" + current.getState());
					System.out.println("Number of nodes created: " + open.size() + closed.size());
					printSolution(current);
					System.out.println("Kyrre");
					return true;
				}
			generateChildren(current);
			successors = current.getChildren();
//			System.out.println(successors.size());
			int pikkogBalle = successors.size();
			for (int i=0; i<= pikkogBalle; i++) {
//				System.out.println(i+"  "+successors.size());
				Node temp = successors.get(i);
				Node exist = inOpenOrClosed(temp);
				if(exist != null)
					temp = exist;
				
				current.addChild(temp);
				if(!open.contains(temp) && !closed.contains(temp)){
					attachAndEval(temp,current);
					open.add(temp);
				}
				else if(current.getEstimatedCostFromStart() + estimatedCostBetween(current, temp) < temp.getEstimatedCostFromStart()){
					attachAndEval(temp, current);
					if(closed.contains(temp))
						updatePath(temp);
				}
			}
		}
//		System.out.println("jadajada");
		return true;
	}
	
	//Sjekker rekursivt om det eksisterer en bedre foreldre.
	private void updatePath(Node parent) {
		for (Node child : parent.getChildren()) {
			if(parent.getEstimatedCostFromStart() + estimatedCostBetween(parent, child) < child.getEstimatedCostFromStart()){
				child.setParent(parent);
				child.setEstimatedCostFromStart(parent.getEstimatedCostFromStart() + estimatedCostBetween(parent, child));
				child.setEstimatedTotalCost(child.getEstimatedCostFromStart() + child.getEstimatedCostToGoal());
				updatePath(child);
			}		
		}		
	}
	//Evaluerer kostnadden, og setter foreldre.
	private void attachAndEval(Node child, Node parent) {
		child.setParent(parent);
		child.setEstimatedCostFromStart(parent.getEstimatedCostFromStart()+ estimatedCostBetween(parent, child));
		calculateEstimatedCostToGoal(child);
		child.setEstimatedTotalCost(child.getEstimatedCostFromStart()+child.getEstimatedCostToGoal());
	}
	
	//Sjekker om noden eksisterer i open eller closed. Hvis den gjør det, returneres den.
	private Node inOpenOrClosed(Node child){		
		for (Node exist : open){
			if(exist.getState().equals(child.getState()))
				return exist;
		}
		for (Node exist : closed){
				if(exist.getState().equals(child.getState()))
					return exist;
		}
		return null;
	}
	
	//Skriver ut løsningne
	private void printSolution(Node solution) {
		Node current = solution;
		Stack<String> path = new Stack<String>();
		while(current != null){
			path.push(current.getState());
			current = current.getParent();
		}
		while(!path.isEmpty()){
			System.out.println(path.pop());
		}
	
}
}