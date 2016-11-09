package abrSE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

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
	
	public void testFalsePositive() {
		/* Je n'ai pas de contre exemples pour un faux positif
		 * La seule méthode que j'avais consistait à tricher sur la protection
		 * des variable de ABR.
		 * J'ai tout mis en private si c'était possible.
		 * Rendant impossible la modification d'un arbre.
		 */
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
	
	public void testToListRandom() {
		int tests = 10;
		Random rnd = new Random();
		for(int t = 0; t < tests; t++) {
			ArrayList<Integer> points = new ArrayList<Integer>();
			
			int n = rnd.nextInt(200);
			
			for(int i = 0; i < n; i++) {
				points.add(rnd.nextInt(500) - 250);
			}
			
			ABR tree = new ABR(points);
			
			Collections.sort(points);
			
			//System.out.println(points.toString());
			assertEquals(tree.toList().toString(), points.toString());
		}
	}
}
