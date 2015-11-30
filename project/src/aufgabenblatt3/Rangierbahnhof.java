/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 3
 */

package aufgabenblatt3;

import java.util.Observable;

/**
 * Klasse zur Repräsentation eines Rangierbahnhofes
 * 
 * @author Nico
 *
 */
public class Rangierbahnhof extends Observable {
	private int gleisAnzahl = 0;
	private Zug[] gleise;

	/**
	 * Konstruktor mit gleichzeitiger Initialisierung des Zug-Arrays
	 * 
	 * @param gleisAnzahl
	 *            Größe des Zug-Arrays
	 */
	public Rangierbahnhof() {
		this.gleisAnzahl = 3;
		gleise = new Zug[3];
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
	 * Getter
	 * 
	 * @param index
	 *            Index des gleise Arrays
	 * @return Gibt den Zug an der Stelle index aus dem Array gleise zurueck
	 */
	public Zug getZug(int index) {
		ueberpruefeIndex(index);
		return gleise[index];
	}

	public Rangierbahnhof getBahnhof() {
		return this;
	}

	/**
	 * Methode zum ueberpruefen auf gueltigen Index
	 * 
	 * @param index
	 *            Zu ueberpruefender Index
	 * @throws IndexOutOfBoundsException
	 */
	private void ueberpruefeIndex(int index) throws IndexOutOfBoundsException {
		if (index > gleisAnzahl || index < 0) {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Getter
	 * 
	 * @return Index des ersten leeren Gleises
	 */
	public synchronized int getLeeresGleis() {
		for (int i = 0; i < gleisAnzahl; i++) {
			if (gleise[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Getter
	 * 
	 * @return Index des ersten besetzten Gleises
	 */
	public synchronized int getBesetztesGleis() {
		for (int i = 0; i < gleisAnzahl; i++) {
			if (gleise[i] != null) {
				return i;
			}
		}
		return -1;
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
		if (this.gleise[gleis] == null) {
			this.gleise[gleis] = zug;
		}
		setChanged();
		notifyObservers();
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
		if (this.gleise[gleis] != null) {
			this.gleise[gleis] = null;
		}
		setChanged();
		notifyObservers();
	}

}
