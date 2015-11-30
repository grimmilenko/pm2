/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 3
 */

package aufgabenblatt3;

import static org.junit.Assert.*;

import org.junit.Test;

import aufgabenblatt3.LokfuehrerNeu.Aufgabe;

public class TestLokfuehrerNeu {

	@Test
	public void testRun() {
		Rangierbahnhof rangierbahnhof = new Rangierbahnhof();
		LokfuehrerNeu testEin = new LokfuehrerNeu(rangierbahnhof,
				Aufgabe.EINFAHREN);
		LokfuehrerNeu testAus = new LokfuehrerNeu(rangierbahnhof,
				Aufgabe.AUSFAHREN);
		LokfuehrerNeu testNull = new LokfuehrerNeu(rangierbahnhof, null);

		assertEquals(testEin.getAufgabe(), Aufgabe.EINFAHREN);
		assertEquals(testAus.getAufgabe(), Aufgabe.AUSFAHREN);
		assertEquals(testNull.getAufgabe(), null);

		assertEquals(testEin.getAktuellesGleis(), -1);
		testEin.run();
		assertEquals(testEin.getAktuellesGleis(), 0);
	}
}
