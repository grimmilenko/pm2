/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 3
 */

package aufgabenblatt3;

/**
 * Klasse zur Repräsentation eines Rangierbahnhofes
 * 
 * @author Nico
 *
 */
public class Rangierbahnhof {
	private int gleisAnzahl = 0;
	private Zug[] gleis;

	/**
	 * Konstruktor mit gleichzeitiger Initialisierung des Zug-Arrays
	 * 
	 * @param gleisAnzahl
	 *            Größe des Zug-Arrays
	 */
	public Rangierbahnhof(int gleisAnzahl) {
		this.gleisAnzahl = gleisAnzahl;
		gleis = new Zug[gleisAnzahl];
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die Anzahl der Gleise zurueck
	 */
	public int getGleisAnzahl() {
		return gleisAnzahl;
	}

	/**
	 * Methode zum ueberpruefen auf gueltigen Index
	 * 
	 * @param index
	 *            Zu ueberpruefender Index
	 * @throws IndexOutOfBoundsException
	 */
	private void ueberpruefeIndex(int index) throws IndexOutOfBoundsException {
		if (index > gleisAnzahl - 1 || index < 0) {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Synchronisierte Methode zum einfahren eines Zuges in den Rangierbahnhof
	 * 
	 * @param zug
	 *            Einfahrender Zug
	 * @param gleis
	 *            Gleis, auf dem ein Zug einfahren soll
	 * @throws IndexOutOfBoundsException
	 */
	public synchronized void einfahren(Zug zug, int gleis) {
		ueberpruefeIndex(gleis);
		this.gleis[gleis] = zug;
	}

	/**
	 * Synchronisierte Methode zum ausfahren eines Zuges aus dem Rangierbahnhof
	 * 
	 * @param gleis
	 *            Gleis, auf dem ein Zug ausfahren soll
	 * @throws IndexOutOfBoundsException
	 */
	public synchronized void ausfahren(int gleis) {
		ueberpruefeIndex(gleis);
		this.gleis[gleis] = null;
	}

}
