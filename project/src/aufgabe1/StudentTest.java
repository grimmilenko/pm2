/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 1
 */

package aufgabenblatt1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testklasse zum testen der Funktionalitäten der Klasse Student
 * 
 * @author Nico Grimm und Marco Colbow
 *
 */
public class StudentTest {

	 @Test
	public void testCompareTo() {
		Student student1 = new Student("Nico", "Grimm", 2058712);
		Student student2 = new Student("Marco", "Colbow", 2264187);
		assertEquals("Fehler beim Vergleich der Matrikelnummern!",
				student1.compareTo(student2), -1);
		assertEquals("Fehler beim Vergleich der Matrikelnummer!",
				student2.compareTo(student1), 1);
		assertEquals("Fehler beim Vergleich der Matrikelnummer!",
				student1.compareTo(student1), 0);
		assertEquals("Fehler beim Vergleich der Matrikelnummer mit null!",
				student1.compareTo(null), -1);

	}

	@Test
	public void testCompare() {
		Student student1 = new Student("Nico", "Grimm", 2058712);
		Student student2 = new Student("Marco", "Colbow", 2264187);
		Student student3 = new Student("Niko", "Grimm", 2058713);

		assertEquals("Fehler beim Vergleich der Nachnamen!",
				student1.compare(null, student2), 1);
		assertEquals("Fehler beim Vergleich der Nachnamen!",
				student1.compare(student1, null), -1);
		assertEquals("Fehler beim Vergleich der Nachnamen!",
				student1.compare(null, null), 0);
		assertEquals("Fehler beim Vergleich der Nachnamen!",
				student1.compare(student1, student2), 1);
		assertEquals("Fehler beim Vergleich der Nachnamen!",
				student1.compare(student2, student1), -1);
		assertEquals("Fehler beim Vergleich der Nachnamen!",
				student1.compare(student2, student2), 0);
		assertEquals("Fehler beim Vergleich der Nachnamen!",
				student1.compare(student1, student3), -1);

	}
}
