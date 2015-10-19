/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 1
 */
package aufgabenblatt1;

/**
 * Klasse prüft statisch, ob der erste Wert einer Liste ein INteger Wert ist
 * @author Nico, Marco
 *
 */
public class ArrayListeS {

	public static ArrayListe<Integer> liste = new ArrayListe<Integer>(0);
	/**
	 * Default Konstruktor. Fügt Liste einen Wert zu
	 */
 	public ArrayListeS() {
		// ArrayListe<Integer> liste = new ArrayListe<Integer>();
		liste.hinzufuegen(2);
		// liste.hinzufuegen(4);

	}

	/**
	 * Prüft ob das erste Element in der Liste ein Integer Wert ist.
	 */
	public static boolean erstesElementZahl() {
		// ArrayListe[] elemente;
		// elemente = new ArrayListe[0];
		// ArrayListe<Integer> liste = new ArrayListe<Integer>();
		// liste.hinzufuegen(2);

		System.out.println(liste.get(0));
		if (liste.get(0) instanceof Integer) {
			// throw new Exception("list does not contain integer")
			return true;

		}
		return false;
	}

	public static void main(String[] args) {
		ArrayListeS liste = new ArrayListeS();
		System.out.println(erstesElementZahl());
		ArrayListe<String> listen = new ArrayListe<String>(3);
		listen.hinzufuegen("Hallo");
		listen.hinzufuegen("Hier");
	}
}
