package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	private Node root;
	
	public BinarySearchTree(int rootValue) {
		this.root = new Node(rootValue);
	}
	
	public void insert(int value) {
		insert(value, this.root);
	}
	
	private void insert(int value, Node node) {
		if (value < node.getValue()) {
			if (node.getLeft() == null) {
				node.setLeft(new Node(value));
				return;
			} else {
				insert(value, node.getLeft());
			}
		} else {
			if (node.getRight() == null) {
				node.setRight(new Node(value));
				return;
			} else {
				insert (value, node.getRight());
			}
		}
	}
	
	public void printBFS() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			System.out.println(n.getValue());
			if (n.hasLeft()) queue.offer(n.getLeft());
			if (n.hasRight()) queue.offer(n.getRight());
			// TODO: where do I put the newline char?
		}
	}
	
	public class Node {
		
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
		
		public Node getLeft() {
			return this.left;
		}
		
		public Node getRight() {
			return this.right;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public void setRight(Node right) {
			this.right = right;
		}
		
		public boolean hasLeft() {
			return this.left != null;
		}
		
		public boolean hasRight() {
			return this.right != null;
		}
	}
}
