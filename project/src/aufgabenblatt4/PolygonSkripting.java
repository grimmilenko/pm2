/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 4
 */

package aufgabenblatt4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasse zur Darstellung der erlaubten Befehle
 * 
 * @author grimmilenko
 *
 */
public class PolygonSkripting {
	private final Pattern pattern;
	private Matcher matcher;

	/**
	 * Konstruktor
	 */
	public PolygonSkripting() {
		pattern = Pattern.compile("(bewege)\\s->" + "\\s(0|-?[0-9]*\\.?[0-9]*),\\s?(0|-?[0-9]*\\.?[0-9]*)");
		matcher = null;
	}

	/**
	 * Methode zum ueberpruefen, ob der eingebene Befehl ein gueltiger ist
	 * 
	 * @param befehl
	 *            Der eingegebene Befehl
	 * @return Gibt die Gueltigkeit des Befehls zurueck (true oder false)
	 */
	public boolean istGueltigerBefehl(String befehl) {
		matcher = pattern.matcher(befehl);
		return matcher.matches();
	}

	/**
	 * Methode, um aus dem Eingabe String die X-Koordinate zu extrahieren
	 * 
	 * @param befehl
	 *            Eingabe-String
	 * @return X-Koordinate aus dem Eingabe-String
	 * @throws Exception
	 *             Bei falschen Befehl wird eine Exception geworfen
	 */
	public double getX(String befehl) throws Exception {
		if (istGueltigerBefehl(befehl)) {
			return new Double(matcher.group(3));
		} else {
			throw new Exception("Kein gueltiger Befehl!");
		}
	}

	/**
	 * Methode, um aus dem Eingabe String die X-Koordinate zu extrahieren
	 * 
	 * @param befehl
	 *            Eingabe-String
	 * @return Y-Koordinate aus dem Eingabe-String
	 * @throws Exception
	 *             Bei falschen Befehl wird eine Exception geworfen
	 */
	public double getY(String befehl) throws Exception {
		if (istGueltigerBefehl(befehl)) {
			return new Double(matcher.group(2));
		} else {
			throw new Exception("Kein gueltiger Befehl!");
		}
	}

}
