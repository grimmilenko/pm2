package aufgabe1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayList {

	@Test
	public void testAdd() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		int x = 1;
		int y = 2;
		int z = -5;
		test.add(x);
		test.add(y);
		test.add(z);
		assertEquals("Error!", (int) test.get(0), x);
		assertEquals("Error!", (int) test.get(1), y);
		assertEquals("Error!", (int) test.get(2), z);
	}

	@Test
	public void testRemove() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(10);
		test.add(20);
		test.add(30);
		test.add(40);
		test.add(50);
		test.remove(40);
		assertEquals("Error!", (int) test.get(3), 50);
	}

	@Test
	public void testRemoveAtIndex() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(115);
		test.add(427);
		test.add(436);
		test.add(67);
		test.add(23);
		test.removeAtIndex(2);
		assertEquals("Error!", (int) test.get(2), 67);
		assertEquals("Error!", (int) test.getSize(), 4);
	}

	@Test
	public void testGetNumberOfElements() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(2);
		test.add(158);
		test.add(908);
		assertEquals("Error", test.getNumberOfElements(), 3);

		ArrayList<String> test1 = new ArrayList<String>();
		assertEquals("Error!", test1.getNumberOfElements(), 0);
	}

	@Test
	public void testGetSmallestElement() {
	}

	@Test
	public void testGet() {
		ArrayList<String> test = new ArrayList<String>();
		test.add(null);
		test.add("hello");
		assertEquals("Error", test.get(0), null);
		assertEquals("Error", test.get(1).equals("hello"), true);
	}
}
