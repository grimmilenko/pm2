/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasse zum bearbeiten eines String-Arrays mit Hilfe von Streams
 * 
 * @author Nico
 *
 */
public class MyStreams {

	public String kuerzen(String string) {
		if (string.length() <= 8) {
			return string;
		} else {
			return string.substring(0, 8);
		}
	}

	public List<String> streamVerarbeitung(String[] array) {
		return Arrays
				.stream(array)
				.filter(element -> element != null)
				.map(element -> kuerzen(element.toUpperCase().trim()
						.replace("�", "AE").replace("�", "OE")
						.replace("�", "UE").replace("�", "SS")))
				.collect(Collectors.toList());
	}
}
