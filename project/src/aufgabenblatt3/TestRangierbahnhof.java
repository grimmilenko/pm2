/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 3
 */

package aufgabenblatt3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test-Klasse zum testen der Funktionalitaeten des Rangierbahnhofes
 * 
 * @author Nico
 *
 */
public class TestRangierbahnhof {

	@Test
	public void testEinfahren() {
		Rangierbahnhof test = new Rangierbahnhof();
		Rangierbahnhof test1 = new Rangierbahnhof();
		Rangierbahnhof test2 = new Rangierbahnhof();
		Rangierbahnhof test3 = new Rangierbahnhof();
		Rangierbahnhof test4 = new Rangierbahnhof();

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
		Rangierbahnhof testVoll = new Rangierbahnhof();
		testVoll.einfahren(zug, 0);
		testVoll.einfahren(new Zug(), 0);
		assertEquals(testVoll.getZug(0), zug);
	}

	@Test
	public void testAusfahren() {
		Rangierbahnhof test = new Rangierbahnhof();

		test.einfahren(new Zug(), 1);
		test.ausfahren(1);

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
		Rangierbahnhof test = new Rangierbahnhof();

		test.einfahren(new Zug(), 0);
		assertEquals(test.getLeeresGleis(), 1);
		test.einfahren(new Zug(), 1);
		assertEquals(test.getLeeresGleis(), 2);
		test.einfahren(new Zug(), 2);
		assertEquals(test.getLeeresGleis(), -1);
	}

	@Test
	public void testGetBesetztesGleis() {
		Rangierbahnhof test = new Rangierbahnhof();

		assertEquals(test.getBesetztesGleis(), -1);
		test.einfahren(new Zug(), 2);
		assertEquals(test.getBesetztesGleis(), 2);
	}

}
