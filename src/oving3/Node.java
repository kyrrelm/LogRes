package oving3;

import java.util.ArrayList;

public class Node implements Comparable<Node> {
	private String state;
	private Node parent;
	private ArrayList<Node> children = new ArrayList<Node>();
	private int estimatedCostFromStart; //G
	private int estimatedCostToGoal;	//H
	private int estimatedTotalCost;		//F
	private boolean open;
	private boolean solutionNode;
	
	public Node(String state) {
		this.state = state;
	}
	
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public ArrayList<Node> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}
	public void addChild(Node child){
		this.children.add(child);
	}
	public int getEstimatedCostFromStart() {
		return estimatedCostFromStart;
	}
	public void setEstimatedCostFromStart(int estimatedCostFromStart) {
		this.estimatedCostFromStart = estimatedCostFromStart;
	}
	public int getEstimatedCostToGoal() {
		return estimatedCostToGoal;
	}
	public void setEstimatedCostToGoal(int estimatedCostToGoal) {
		this.estimatedCostToGoal = estimatedCostToGoal;
	}
	public int getEstimatedTotalCost() {
		return estimatedTotalCost;
	}
	public void setEstimatedTotalCost(int estimatedTotalCost) {
		this.estimatedTotalCost = estimatedTotalCost;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isSolutionNode() {
		return solutionNode;
	}
	public void setSolutionNode(boolean solutionNode) {
		this.solutionNode = solutionNode;
	}
	@Override
	public int compareTo(Node o) {
		Integer sum = o.estimatedTotalCost;
		return sum.compareTo(this.estimatedTotalCost);
	}
	public String getState() {
		// TODO Auto-generated method stub
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}