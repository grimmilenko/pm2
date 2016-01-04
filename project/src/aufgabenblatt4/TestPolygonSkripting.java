/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 4
 */

package aufgabenblatt4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test-Klasse zum ueberpruefen der Funktionalitaet der Regulaeren Ausdruecke
 * 
 * @author Nico
 *
 */
public class TestPolygonSkripting {

	@Test
	public void polygonSkriptingTest() {
		PolygonSkripting polygon = new PolygonSkripting();

		assertEquals("fehler", polygon.istGueltigerBefehl("bewege -> 1.0,3.0"), true);

	}

	@Test
	public void polygonSkriptingTestFalsch() {
		PolygonSkripting polygon2 = new PolygonSkripting();

		assertEquals("fehler", polygon2.istGueltigerBefehl("bewege > 1.0,3.0"), false);
		assertEquals("fehler", polygon2.istGueltigerBefehl("trololo"), false);

	}

	@Test
	public void polygonSkriptingTestgetX() {
		PolygonSkripting polygon3 = new PolygonSkripting();

		try {
			assertEquals(3.0, polygon3.getX("bewege -> 1.0,3.0"), 0e-10);
			assertEquals(-03.0, polygon3.getX("bewege -> 1.0,-03.0"), 0e-10);
			assertEquals(345, polygon3.getX("bewege -> 1.0,345"), 0e-10);

		} catch (Exception e) {

		}

	}

	@Test
	public void polygonSkriptingTestgetY() {
		PolygonSkripting polygon3 = new PolygonSkripting();

		try {
			assertEquals(1.0, polygon3.getY("bewege -> 1.0,3.0"), 0e-10);
			assertEquals(-03.0, polygon3.getY("bewege -> -03.0,0.1"), 0e-10);
			assertEquals(345, polygon3.getY("bewege -> 345,1.0"), 0e-10);

		} catch (Exception e) {

		}

	}
}
