package aufgabe1;

public class Student implements Comparable<Student> {
	private String vorname;
	private String nachname;
	private int matrikelnummer;

	public Student(String vorname, String nachname, int matrikelnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = matrikelnummer;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

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
