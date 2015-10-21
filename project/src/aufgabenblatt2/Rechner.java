/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

/**
 * Klasse zur Repraesentation eines einfachen Rechners
 * 
 * @author Nico Grimm
 *
 */
public class Rechner {

	/**
	 * Enum zur Verwaltung der zu beherschenden Rechenarten des Rechners
	 * 
	 * @author Nico Grimm
	 *
	 */
	public enum Operation {
		ADDITION, SUBTRAKTION, MULTIPLIKATION, DIVISION
	}

	public double berechne(Operation operation, double zahl1, double zahl2) {
		double ergebnis = 0;
		return ergebnis;
	}

}
