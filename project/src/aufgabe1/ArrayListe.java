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
	 * Methode zum hinzufuegen einer Liste in eine andere Liste
	 * 
	 * @param t
	 *            Liste die hinzugefuegt werden soll
	 */
	public void hinzufuegen(ArrayListe<T> t) {
		int neueLaenge = elemente.length + t.getAnzahlElemente();
		Object[] newElemente = new Object[neueLaenge];
		System.arraycopy(t, 0, newElemente, 0, newElemente.length);
		elemente = newElemente;
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

	public void entfernen(ArrayListe<T> t) {
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
