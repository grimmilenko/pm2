/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 1
 */

package aufgabe1;

/**
 * Klasse zur Darstellung eines Studenten
 * 
 * @author Nico Grimm und Marco Colbow
 *
 */
public class Student implements Comparable<Student> {
	private String vorname;
	private String nachname;
	private int matrikelnummer;

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

	@Override
	public int compareTo(Student other) {
		int erg = 0;
		if (getMatrikelnummer() < other.getMatrikelnummer()) {
			erg = 1;
		} else if (getMatrikelnummer() > other.getMatrikelnummer()) {
			erg = -1;
		}
		return erg;
	}
}
