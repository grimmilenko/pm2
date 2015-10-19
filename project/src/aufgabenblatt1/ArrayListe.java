/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 1
 */

package aufgabenblatt1;

import java.util.Arrays;

/**
 * Klasse zur Darstellung einer Array Liste
 * 
 * @author Marco, Nico
 *
 * @param <T>
 *            Generischer Typ
 */
public class ArrayListe<T> {

	private int anzahlElemente;
	private Object[] elemente;

	/**
	 * Default Konstruktor
	 */
	public ArrayListe() {

		this(0);
	}

	/**
	 * Konstruktor mit bestimmter Größe
	 * 
	 * @param groesse
	 *            die Größe der Liste
	 */
	public ArrayListe(int groesse) {
		// elemente = new Object[0];
		elemente = (T[]) new Object[groesse];
		anzahlElemente = 0;
	}

	/**
	 * Methode zum hinzufuegen eines Elements in die Liste
	 * 
	 * @param t
	 *            Element welches hinzugefuegt werden soll
	 */
	public void hinzufuegen(T t) {

		if (anzahlElemente == elemente.length) {
			resize(elemente.length * 2 + 1);
		}
		elemente[anzahlElemente] = t;
		anzahlElemente++;
	}

	/**
	 * Passt die größe der Liste an
	 * 
	 * @param size
	 *            neue größe der Liste
	 */
	private void resize(int size) {
		T[] tmp = (T[]) new Object[size];

		// Bisherige Elemente umkopieren
		for (int i = 0; i < anzahlElemente; i++) {
			tmp[i] = (T) elemente[i];
		}
		elemente = tmp;
	}

	/**
	 * Getter
	 * 
	 * @param index
	 *            Index einer Liste
	 * @return Gibt das Element zurueck, welches sich an dem Index befindet
	 */
	public T get(int index) {
		if (index < anzahlElemente && index >= 0) {
			return (T) elemente[index];
		} else {
			return null;
		}
	}

	/**
	 * Methode zum entfernen eines bestimmten Elements in der Liste
	 * 
	 * @param t
	 *            Element welches entfernt werden soll
	 */
	// nkb anzahlElöemente verwenden
	public void entfernen(T t) {
		if (anzahlElemente == 0) {
			return;
		} else {
			for (int i = 0; i < anzahlElemente; i++) {
				if (elemente[i].equals(t)) {
					elemente[i] = elemente[i + 1];
				}
			}
		}
	}

	/**
	 * Entfernt ein Element an einem bestimmten Index
	 * 
	 * @param index
	 *            Der Index an dem das Element gelöscht werden soll
	 */
	public void entferneElementAnIndex(int index) {
		
		for (int i = 0; i < anzahlElemente; i++) {
			if (i > index) {
				elemente[i - 1] = elemente[i];
			}
		}
		
		elemente[anzahlElemente] = null;
		anzahlElemente--;
	

	}

	/**
	 * gibt anzahl Elemente aus
	 * 
	 * @return die Anzahl der Elemente
	 */
	public int getAnzahlElemente() {
		return anzahlElemente;
	}

	/**
	 * ToString Methode
	 */
	public String toString() {
		String ausgabe = "";
		for (int i = 0; i < anzahlElemente; i++) {
			ausgabe = ausgabe + elemente[i];
		}
		return ausgabe;
	}

	/**
	 * Gibt das kleinste Element aus
	 * 
	 * @return das kleinste Element
	 */

	public <T extends Comparable<T>> T getKleinstesElement() {
		T kleinstesElement = (T) elemente[0];
		
		for (int i = 1; i < anzahlElemente; i++) {
			if (kleinstesElement.compareTo((T) elemente[i]) > 0) {
				kleinstesElement = (T) elemente[i];
			}
		}
		return kleinstesElement;
	}

	/**
	 * Summiert alle Elemente in der Liste, wenn sie Integer Werte sind
	 * 
	 * @return Die Summe aller Elemente
	 * @throws Exception
	 *             wird geworfen, wenn die Werte der Liste keine Integer Werte
	 *             sind
	 */
	public int sum() throws Exception {
		int result = 0;

		if (!(elemente[0] instanceof Integer)) {
			throw new Exception("list does not contain integer");
		}
		for (int i = 0; i < anzahlElemente; i++) {
			result += (int) elemente[i];
		}
		return result;
	}
}
