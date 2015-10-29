/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

/**
 * Funktionales Interface
 * 
 * @author abe682
 *
 */
@FunctionalInterface
public interface DoubleDoubleZuDouble {
	
	/**
	 * Methode die zwei Zahlen auswertet
	 * 
	 * @param wert1
	 *            Erste Zahl die verwendet werden soll
	 * @param wert2
	 *            Zweite Zahl die verwendet werden soll
	 * @return Gibt eine Double Zahl zurueck
	 */
	public double werteAus(double wert1, double wert2);
}
