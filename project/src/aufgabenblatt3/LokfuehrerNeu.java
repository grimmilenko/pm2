/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 3
 */

package aufgabenblatt3;

/**
 * Klasse zur Repraesentation eines Lokfuehrers
 * 
 * @author Nico
 *
 */
public class LokfuehrerNeu extends Thread {
	private Rangierbahnhof bahnhof;
	private Aufgabe aufgabe;

	/**
	 * Enum, welches die beiden moeglichen Aufgaben eines Lokfuehres beinhaltet
	 * 
	 * @author Nico
	 *
	 */
	public enum Aufgabe {
		AUSFAHREN, EINFAHREN
	}

	/**
	 * Konstruktor
	 * 
	 * @param bahnhof
	 *            Referenz auf den Rangierbahnhof
	 */
	public LokfuehrerNeu(Rangierbahnhof rangierbahnhof, Aufgabe aufgabe) {
		bahnhof = rangierbahnhof;
		this.aufgabe = aufgabe;
	}

	@Override
	public void run() {
		if (aufgabe == Aufgabe.EINFAHREN) {
			if (bahnhof.getLeeresGleis() >= 0) {
				Zug zug = new Zug();
				bahnhof.einfahren(zug, bahnhof.getLeeresGleis());
				System.err.format("Neuer Zug ist auf Gleis %d eingefahren\n", bahnhof.getLeeresGleis());
			}
		} else {
			if (bahnhof.getBesetztesGleis() >= 0) {
				bahnhof.ausfahren(bahnhof.getBesetztesGleis());
				System.err.format("Der Zug auf Gleis %d ist ausgefahren\n", bahnhof.getBesetztesGleis());
			}
		}
	}
}
