package datastructures;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void bfsTest() {
		BinarySearchTree bst = new BinarySearchTree(20);
		bst.insert(12);
		bst.insert(4);
		bst.insert(7);
		bst.insert(48);
		bst.insert(21);
		bst.printBFS();
	}
}
