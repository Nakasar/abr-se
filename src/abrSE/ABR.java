package abrSE;

import java.util.ArrayList;

public class ABR {
/*
 * En utilisant la javadoc fournie comme documentation, créer une classe ABR définissant
 * le constructeur ABR() et les méthodes insert, isEmpty et nbElements.
 * Vous pouvez, si besoin, introduire une classe permettant de représenter les noeuds d’un ABR.
 * Ecrire des jeux de tests en utilisant junit.
 */
	private class Node {
		private int value;
		private Node leftChild;
		private Node rightChild;
		
		Node(int value) {
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}
		
		int getValue() {
			return this.value;
		}
		private void setValue(int value) {
			this.value = value;
		}
		
		private Node getLeftChild() {
			return this.leftChild;
		}
		private Node getRightChild() {
			return this.rightChild;
		}
		
		private void setLeftChild(Node n) {
			this.leftChild = n;
		}
		private void setRightChild(Node n) {
			this.rightChild = n;
		}
	}
	
	private int nbElements;
	private Node root = null;
	
	/**
	 * Constructor of an new empty ABR.
	 */
	ABR() {
		this.nbElements = 0;
	}
	
	/**
	 * Contructor of an ABR with points in ArrayList of Integer
	 * 
	 * @param points ArrayList of integer to add in the ABR.
	 */
	ABR(ArrayList<Integer> points) {
		for(int value : points)
			this.insert(value);
	}
	
	/**
	 * insert Adds the specified element to this ABR if it is not already present
	 * 
	 * @param node the actual node.
	 * @param value the value to add in the tree.
	 * @return the new node with the adding value.	
	 */
	private Node insert(Node node, int value) {
		if(node == null) {
			node = new Node(value);
			this.nbElements++;
		}
		else {
			if(value < node.getValue()) {
				node.leftChild = insert(node.leftChild, value);
			}
			else {
				node.rightChild = insert(node.rightChild, value);
			}
		}
		return node;
	}
	
	/**
	 * insert Adds the specified element to this ABR if it is not already present
	 * 
	 * @param value the value to add in the tree.	
	 */
	void insert(int value) {
		if(this.root == null){
			this.root = new Node(value);
			this.nbElements++;
		}
		else
			insert(root, value);
	}
	
	/**
	 * isEmpty Return if this ABR contains no elements.
	 * 
	 * @return	true if the the ABR is empty, false otherwise.
	 */
	protected boolean isEmpty() {
		return this.nbElements() == 0;
	}
	
	/**
	 * nbElements Returns the number of element in this ABR
	 * 
	 * @return integer the number of elements if the ABR.
	 */
	protected int nbElements() {
		return this.nbElements;
	}
	
	/**
	 * contains check if element is in tree
	 * 
	 * @param value integer value the value to search in the ABR.
	 * @return true if value is in the ABR, false otherwise.
	 */
	private boolean contains(int value, Node node) {
		if(node == null)
			return false;
		else if(node.getValue() == value)
			return true;
		else {
			if(value < node.getValue())
				return contains(value, node.leftChild);
			else
				return contains(value, node.rightChild);
		}
	}
	
	protected boolean contains(int value) {
		return this.contains(value, this.root);
	}
	
	/*
	 * toList return nodes in a list of their values
	 */
	private ArrayList<Integer> toList(Node node, ArrayList<Integer> list) {
		if(node == null)
			return list;
		else {
			this.toList(node.leftChild, list);
			list.add(node.getValue());
			this.toList(node.rightChild, list);
			return list;
		}
	}
	
	/**
	 * toList return nodes in a list of their values
	 * 
	 * @return an ArrayList of Integer containing all elements of the ABR in ascending order.
	 */
	protected ArrayList<Integer> toList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		return toList(this.root, list);
	}
}
