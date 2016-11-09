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
		Node leftChild;
		Node rightChild;
		
		Node(int value) {
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}
		
		int getValue() {
			return this.value;
		}
		void setValue(int value) {
			this.value = value;
		}
		
		Node getLeftChild() {
			return this.leftChild;
		}
		Node setRightChild() {
			return this.rightChild;
		}
		
		void setLeftChild(Node n) {
			this.leftChild = n;
		}
		void setRightChild(Node n) {
			this.rightChild = n;
		}
	}
	
	int nbElements;
	Node root = null;
	
	ABR() {
		this.nbElements = 0;
	}
	
	/*
	 * insert Adds the specified element to this ABR if it is not already present
	 * 
	 * @Param value int
	 */
	Node insert(Node node, int value) {
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
	
	void insert(int value) {
		if(this.root == null){
			this.root = new Node(value);
			this.nbElements++;
		}
		else
			insert(root, value);
	}
	
	/*
	 * isEmpty Return if this ABR contains no elements.
	 */
	protected boolean isEmpty() {
		return this.nbElements() == 0;
	}
	
	/*
	 * nbElements Returns the number of element in this ABR
	 */
	protected int nbElements() {
		return this.nbElements;
	}
	
	/*
	 * contains check if element is in tree
	 */
	protected boolean contains(int value) {
		return this.contains(value, this.root);
	}
	
	protected boolean contains(int value, Node node) {
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
	
	/*
	 * tuList return nodes in a list of their values
	 */
	protected ArrayList<Integer> toList(Node node, ArrayList<Integer> list) {
		if(node == null)
			return list;
		else {
			this.toList(node.leftChild, list);
			list.add(node.getValue());
			this.toList(node.rightChild, list);
			return list;
		}
	}
	
	protected ArrayList<Integer> toList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		return toList(this.root, list);
	}
}
