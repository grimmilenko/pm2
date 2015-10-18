package aufgabe1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayList {

	@Test
	public void testAdd() {
		ArrayList test = new ArrayList<>();
		int x = 1;
		int y = 2;
		int z = -5;
		test.add(x);
		test.add(y);
		test.add(z);
		assertEquals("Fehler!", test.get(0), 1);
		assertEquals("Fehler!", test.get(1), 2);
		assertEquals("Fehler!", test.get(2), -5);
	}

	@Test
	public void testRemove() {
	}

	@Test
	public void testRemoveAtIndex() {
	}

	@Test
	public void testGetNumberOfElements() {
		ArrayList test = new ArrayList();
		test.add(2);
		test.add(158);
		test.add(908);
		assertEquals("Fehler", test.getNumberOfElements(), 3);

		ArrayList test1 = new ArrayList();
		assertEquals("Error!", test1.getNumberOfElements(), 0);
	}

	@Test
	public void testGetSmallestElement() {
	}

	@Test
	public void testGet() {
		ArrayList test = new ArrayList();
		test.add(null);
		test.add("hello");
		assertEquals("Fehler", test.get(0), null);
		assertEquals("Fehler", test.get(1).equals("hello"), true);
	}
}
