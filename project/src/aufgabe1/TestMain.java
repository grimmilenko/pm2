/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 1
 */

package aufgabe1;

/**
 * Klasse zum Testen
 * 
 * @author Nico Grimm und Marco Colbow
 *
 */
public class TestMain {
	/**
	 * Main-Methode zum Testen
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Student student = new Student("Nico", "Grimm", 2058712);
		student.addPruefung("Mathe 1", 12);
		student.addPruefung("Mathe 2", 10);
		student.addPruefung("Programmieren", 15);
		System.out.println(student.toString());

	}
}
