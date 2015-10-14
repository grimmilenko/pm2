/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 1
 */

package aufgabe1;

/**
 * Klasse zum darstellen abgelegter Pruefungen mit Namen des Moduls und
 * zugehoeriger Note
 * 
 * @author Nico Grimm und Marco Colbow
 *
 */
public class Pruefungsleistung {

	private String modul;
	private int note;

	/**
	 * Getter
	 * 
	 * @return Gibt den Namen des Moduls zurueck
	 */
	public String getModul() {
		return modul;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die Note als int zurueck
	 */
	public int getNote() {
		return note;
	}
}
