/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 3
 */

package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;

/**
 * Klasse zur Repraesentation eines Lokfuehrers
 * 
 * @author Nico
 *
 */
public class LokfuehrerNeu extends Thread implements Observer {
	private Rangierbahnhof bahnhof;
	private Aufgabe aufgabe;
	private int aktuellesGleis = -1;

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
	 * Getter
	 * 
	 * @return Gibt die Aufgabe des Lokfuehrer zurueck
	 */
	public Aufgabe getAufgabe() {
		return aufgabe;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt das aktuelle Gleis zurueck
	 */
	public int getAktuellesGleis() {
		return aktuellesGleis;
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
		rangierbahnhof.addObserver(this);
	}

	@Override
	public void run() {
		if (getAufgabe() == Aufgabe.EINFAHREN && bahnhof.getLeeresGleis() >= 0) {
			Zug zug = new Zug();
			aktuellesGleis = bahnhof.getLeeresGleis();
			bahnhof.einfahren(zug, aktuellesGleis);

		} else if (getAufgabe() == Aufgabe.AUSFAHREN
				&& bahnhof.getBesetztesGleis() >= 0) {
			aktuellesGleis = bahnhof.getBesetztesGleis();
			bahnhof.ausfahren(aktuellesGleis);
		} else {
			bahnhof.deleteObserver(this);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (this.getAufgabe() == Aufgabe.EINFAHREN && aktuellesGleis >= 0) {
			System.err.format("Neuer zug auf Gleis %d eingefahren!\n",
					aktuellesGleis);
		} else if (this.getAufgabe() == Aufgabe.AUSFAHREN
				&& aktuellesGleis >= 0) {
			System.err.format("Der Zug auf Gleis %d ist ausgefahren!\n",
					aktuellesGleis);
		}
		bahnhof.deleteObserver(this);
	}
}
