package aufgabenblatt3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRangierbahnhof {

	@Test
	public void testEinfahren() {
		Rangierbahnhof test = new Rangierbahnhof(10);
		Rangierbahnhof test1 = new Rangierbahnhof(10);
		Rangierbahnhof test2 = new Rangierbahnhof(10);
		Rangierbahnhof test3 = new Rangierbahnhof(10);
		Rangierbahnhof test4 = new Rangierbahnhof(10);

		Zug zug = new Zug();
		test.einfahren(zug, 0);
		test1.einfahren(zug, 2);
		test2.einfahren(null, 1);

		assertEquals(test.getZug(0), zug);
		assertEquals(test1.getZug(2), zug);
		assertEquals(test2.getZug(1), null);
		try {
			test3.einfahren(zug, -2);
			test4.einfahren(zug, 11);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			// Exception wurde geworfen -> alles ok
		}
	}

	@Test
	public void testAusfahren() {
		Rangierbahnhof test = new Rangierbahnhof(10);

		test.einfahren(new Zug(), 1);
		test.ausfahren(1);
		test.ausfahren(6);

		assertEquals(null, test.getZug(1));
		try {
			test.ausfahren(-3);
			test.ausfahren(15);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			// Exception wurde geworfen -> alles ok
		}
	}

	@Test
	public void testGetLeeresGleis() {
		Rangierbahnhof test = new Rangierbahnhof(10);

		test.einfahren(new Zug(), 0);
		assertEquals(test.getLeeresGleis(), 1);
		test.einfahren(new Zug(), 1);
		test.einfahren(new Zug(), 2);
		test.einfahren(new Zug(), 4);
		test.einfahren(new Zug(), 5);
		assertEquals(test.getLeeresGleis(), 3);
		test.einfahren(new Zug(), 3);
		test.einfahren(new Zug(), 6);
		test.einfahren(new Zug(), 7);
		test.einfahren(new Zug(), 8);
		assertEquals(test.getLeeresGleis(), 9);
		test.einfahren(new Zug(), 9);
		assertEquals(test.getLeeresGleis(), -1);
	}

	@Test
	public void testGetBesetztesGleis() {
		Rangierbahnhof test = new Rangierbahnhof(10);

		assertEquals(test.getBesetztesGleis(), -1);
		test.einfahren(new Zug(), 5);
		assertEquals(test.getBesetztesGleis(), 5);
	}

}
