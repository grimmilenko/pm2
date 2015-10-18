/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 1
 */

package aufgabe1;

public class ArrayListe<T> {

	int anzahlElemente;
	private Object[] elemente;

	public ArrayListe() {
		elemente = new Object[0];
	}

	/**
	 * Methode zum hinzufuegen eines Elements in die Liste
	 * 
	 * @param t
	 *            Element welches hinzugefuegt werden soll
	 */
	public void hinzufuegen(T t) {
		Object[] zwischenSpeicher = new Object[elemente.length + 1];
		System.arraycopy(elemente, 0, zwischenSpeicher, 0,
				zwischenSpeicher.length);
		zwischenSpeicher[zwischenSpeicher.length + 1] = t;
		elemente = zwischenSpeicher;
	}

	/**
	 * Getter
	 * 
	 * @param index
	 *            Index einer Liste
	 * @return Gibt das Element zurueck, welches sich an dem Index befindet
	 */
	public T get(int index) {
		if (index <= elemente.length) {
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
	public void entfernen(T t) {
		if (elemente.length == 0) {
			return;
		} else {
			for (int i = 0; i < elemente.length; i++) {
				if (elemente[i].equals(t)) {
					elemente[i] = elemente[i + 1];
				}
			}
		}
	}

	public void entferneElementAnIndex(int index) {
	}

	public int getAnzahlElemente() {
		return elemente.length;
	}

	public String toString() {
		String ausgabe = "";
		return ausgabe;
	}

	public T getKleinstesElement() {
		T kleinstesElement = (T) elemente[0];
		for (int i = 0; i <= elemente.length; i++) {
		}
		return kleinstesElement;

	}
}
