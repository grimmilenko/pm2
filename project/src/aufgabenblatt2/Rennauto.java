/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

/**
 * Klasse zur Realisierung eines Rennautos
 * 
 * @author Nico
 *
 */
public class Rennauto extends Thread {
	// private double avgSpeed = randomRange(0.8, 1.2);
	private static int UniqueId = 0;
	private int id;
	private final static double STRECKE = 10.0;

	public Rennauto() {
		id = UniqueId++;
	}

	/**
	 * Methode zur Erzeugung einer Zufallszahl in einem bestimmten Bereich
	 * 
	 * @param min
	 *            minimale Zufallszahl
	 * @param max
	 *            maximale Zufallszahl
	 * @return Zufallszahl zwischen min und max
	 */
	private double randomRange(double min, double max) {
		double range = (max - min);
		return (Math.random() * range) + min;
	}

	@Override
	public void run() {
		for (double strecke = 0.0; strecke <= STRECKE + 1; strecke = strecke
				+ randomRange(0.8, 1.2)) {
			System.err.println("Wagen " + id + ":" + strecke + "/" + STRECKE);
		}
	}

	public static void main(String[] args) {
		Rennauto test = new Rennauto();
		Rennauto test1 = new Rennauto();
		test.start();
		test1.start();
	}
}
