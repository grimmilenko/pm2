/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 1
 */

package aufgabe1;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse zur Darstellung eines Studenten
 * 
 * @author Nico Grimm und Marco Colbow
 *
 */
public class Student implements Comparable<Student> {
	/**
	 * Vorname des Studenten
	 */
	private String vorname;
	/**
	 * Nachname des Studenten
	 */
	private String nachname;
	/**
	 * Matrikelnummer des Studenten
	 */
	private int matrikelnummer;
	/**
	 * Liste fuer abgelegte Pruefungen
	 */
	private List<Pruefungsleistung> liste;

	/**
	 * Konstruktor der Klasse Student
	 * 
	 * @param vorname
	 *            Vorname eines Studenten
	 * @param nachname
	 *            Nachname eines Studenten
	 * @param matrikelnummer
	 *            Matrikelnummer eines Studenten
	 */
	public Student(String vorname, String nachname, int matrikelnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = matrikelnummer;
		liste = new ArrayList<Pruefungsleistung>();
	}

	/**
	 * Getter
	 * 
	 * @return Gibt den Vornamen zurueck
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt den Nachnamen zurueck
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die Matrikelnummer zurueck
	 */
	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	/**
	 * Methode zur Ausgabe der Inhalte eines Studenten
	 */
	public String toString() {
		return "Vorname: " + vorname + "\n" + "Nachname: " + nachname + "\n"
				+ "Matrikelnummer: " + matrikelnummer + "\n"
				+ "Erbrachte Leistungen: \n" + gibListeAus();
	}

	/**
	 * Methode zum hinzufuegen einer Pruefung
	 * 
	 * @param modul
	 *            Name des Moduls
	 * @param note
	 *            Note des Moduls
	 */
	public void addPruefung(String modul, int note) {
		liste.add(new Pruefungsleistung(modul, note));
	}

	/**
	 * Methode zur Ausgabe der erbrachten Leistungen eines Studenten
	 * 
	 * @return String mit allen erfüllten Leistungen
	 */
	public String gibListeAus() {
		String ausgabe = "";
		for (Pruefungsleistung x : liste) {
			ausgabe = ausgabe + x.gibAus();
		}
		return ausgabe;
	}

	@Override
	public int compareTo(Student other) {
		int erg = 0;
		// Vegleich der Matrikelnummern
		if (getMatrikelnummer() < other.getMatrikelnummer()) {
			erg = 1;
		} else if (getMatrikelnummer() > other.getMatrikelnummer()) {
			erg = -1;
		}
		return erg;
	}
}
