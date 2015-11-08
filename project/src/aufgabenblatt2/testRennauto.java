/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test-Klasse
 * 
 * @author Nico
 *
 */
public class testRennauto {

	@Test
	public void testRandomRange() {
		Rennstrecke strecke = new Rennstrecke();
		Rennauto test = new Rennauto(strecke);
		double rndNr;
		double lowest = 1.0;
		double highest = 1.0;
		for (int i = 0; i < 1000000; i++) {
			rndNr = test.avgSpeed(0.8, 1.2);
			if (Double.compare(rndNr, 0.8) < 0) {
				fail("Nummer zu klein!");
			}
			if (Double.compare(rndNr, 1.2) > 0) {
				fail("Nummer zu gross!");
			}
			if (highest < rndNr) {
				highest = rndNr;
			}
			if (lowest > rndNr) {
				lowest = rndNr;
			}
		}
		System.out.println("Kleinste Zahl: " + lowest + "\n"
				+ "Groesste Zahl: " + highest);
	}

}
