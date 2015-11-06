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

	/**
	 * Methode zum kuerzen eines Strings auf maximal 8 Zeichen
	 * 
	 * @param string
	 *            String der gekuerzt werden soll
	 * @return gekuerzten String
	 */
	public String kuerzen(String string) {
		if (string.length() <= 8) {
			return string;
		} else {
			return string.substring(0, 8);
		}
	}

	/**
	 * Methode, die aus einem String-Array jeden einzelnen String nimmt und
	 * dieses bearbeitet
	 * 
	 * @param array
	 *            Array welches bearbeitet werden soll
	 * @return Gibt das bearbeitete Array als eine List zurueck
	 */
	public List<String> streamVerarbeitung(String[] array) {
		return Arrays
				.stream(array)
				.filter(element -> element != null)
				.map(element -> kuerzen(element.toUpperCase().trim()
						.replace("Ä", "AE").replace("Ö", "OE")
						.replace("Ü", "UE").replace("ß", "SS")))
				.collect(Collectors.toList());
	}
}
