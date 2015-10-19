/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 1
 */

package aufgabenblatt1;

/**
 * Klasse zum darstellen abgelegter Pruefungen mit Namen des Moduls und
 * zugehoeriger Note
 * 
 * @author Nico Grimm und Marco Colbow
 *
 */
public class Pruefungsleistung {
	/**
	 * Name des Moduls
	 */
	private String modul;
	/**
	 * Note der Pruefung
	 */
	private int note;

	/**
	 * Konstruktor
	 * 
	 * @param modul
	 *            Name des Moduls
	 * @param note
	 *            Note des Moduls
	 */
	public Pruefungsleistung(String modul, int note) {
		this.modul = modul;
		this.note = note;
	}

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

	/**
	 * Ausgabe-Methode
	 * 
	 * @return Gibt einen String zurueck mit Namen des Moduls und der
	 *         zugehoerigen Note
	 */
	public String gibAus() {
		return "\nModul: " + modul + "\n" + "Note: " + note;
	}
}
