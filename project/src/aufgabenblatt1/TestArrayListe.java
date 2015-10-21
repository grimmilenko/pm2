package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayListe {

	@Test
	public void testAdd() {
		ArrayListe<Integer> test = new ArrayListe<Integer>(0);
		int x = 1;
		int y = 2;
		int z = -5;
		test.hinzufuegen(x);
		test.hinzufuegen(y);
		test.hinzufuegen(z);
		assertEquals("Error!", (int) test.get(0), x);
		assertEquals("Error!", (int) test.get(1), y);
		assertEquals("Error!", (int) test.get(2), z);
	}

	@Test
	public void testRemove() {
		ArrayListe<Integer> test = new ArrayListe<Integer>(0);
		test.hinzufuegen(10);
		test.hinzufuegen(20);
		test.hinzufuegen(30);
		test.hinzufuegen(40);
		test.hinzufuegen(50);
		test.entfernen(40);
		assertEquals("Error!", (int) test.get(3), 50);
	}

	@Test
	public void testRemoveAtIndex() {
		ArrayListe<Integer> test = new ArrayListe<Integer>(0);
		test.hinzufuegen(115);
		test.hinzufuegen(427);
		test.hinzufuegen(436);
		test.hinzufuegen(67);
		test.hinzufuegen(23);
		test.entferneElementAnIndex(2);
		assertEquals("Error!", (int) test.get(2), 67);
		assertEquals("Error!", (int) test.getAnzahlElemente(), 4);
	}

	@Test
	public void testGetNumberOfElements() {
		ArrayListe<Integer> test = new ArrayListe<Integer>(0);
		test.hinzufuegen(2);
		test.hinzufuegen(158);
		test.hinzufuegen(908);
		assertEquals("Error", test.getAnzahlElemente(), 3);

		ArrayListe<String> test1 = new ArrayListe<String>(0);
		assertEquals("Error!", test1.getAnzahlElemente(), 0);
	}

	@Test
	public void testGetSmallestElement() {
		ArrayListe<Integer> test = new ArrayListe<Integer>(0);
		test.hinzufuegen(1);
		test.hinzufuegen(2);
		test.hinzufuegen(3);
		test.hinzufuegen(4);
		test.hinzufuegen(5);
		// assertEquals("Error!", (int) test.getSmallestElement(), 1);
	}

	@Test
	public void testGet() {
		ArrayListe<String> test = new ArrayListe<String>(0);
		test.hinzufuegen(null);
		test.hinzufuegen("hello");
		assertEquals("Error", test.get(0), null);
		assertEquals("Error", test.get(1).equals("hello"), true);
	}

	@Test
	public void testSum() {
		ArrayListe<Integer> test = new ArrayListe<Integer>(0);
		test.hinzufuegen(115);
		test.hinzufuegen(427);
		test.hinzufuegen(436);
		test.hinzufuegen(67);
		test.hinzufuegen(23);
		try {
			assertEquals("Error!", test.sum(), 1068);
		} catch (Exception e) {

		}

		ArrayListe<String> test1 = new ArrayListe<String>(0);
		test1.hinzufuegen("hi");
		test1.hinzufuegen("help");
		try {
			assertEquals("Error!", test1.sum(), 0);
		} catch (Exception e) {

		}
	}
}
