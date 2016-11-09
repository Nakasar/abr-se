package abrSE;

import junit.framework.TestCase;

public class testABR extends TestCase {
	
	public void testTreeEmpty() {
		ABR tree = new ABR();
		assertTrue(tree.isEmpty());
	}
	
	public void testTreeInsert() {
		ABR tree = new ABR();
		tree.insert(5);
		tree.insert(1);
		tree.insert(4);
		assertEquals(tree.nbElements(), 3);
	}
	
	public void testContains() {
		ABR tree = new ABR();
		tree.insert(5);
		tree.insert(1);
		tree.insert(4);
		tree.insert(9);
		tree.insert(8);
		assertTrue(tree.contains(5));
		assertTrue(tree.contains(8));
		assertFalse(tree.contains(11));
	}
	
	public void testToList() {
		ABR tree = new ABR();
		tree.insert(5);
		tree.insert(1);
		tree.insert(4);
		tree.insert(9);
		tree.insert(9);
		tree.insert(8);
		assertEquals(tree.toList().toString(), "[1, 4, 5, 8, 9, 9]");
	}
}
