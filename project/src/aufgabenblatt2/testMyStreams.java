/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 * Test-Klasse
 * 
 * @author Nico
 *
 */
public class testMyStreams {

	@Test
	public void test() {
		String[] array = { "Eingabe", "Äußeres", null, "Strassen-Feger",
				"ein Haus", "Öl", "überreichen" };
		MyStreams test = new MyStreams();
		ArrayList<String> erwartet = new ArrayList<String>(Arrays.asList(
				"EINGABE", "AEUSSERE", "STRASSEN", "EIN HAUS", "OEL", "UEBERREI"));
		assertEquals(erwartet, test.streamVerarbeitung(array));
	}

}
