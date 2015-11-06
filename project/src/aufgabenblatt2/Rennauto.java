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
	private static int UniqueId = 0;
	private int id;
	private double gefahreneZeit = 0.0;
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
		double gefahreneStrecke = 0.0;
		for (gefahreneStrecke = 0.0; gefahreneStrecke < STRECKE + 1; gefahreneStrecke++) {
			System.err.println("Wagen " + id + ": " + gefahreneStrecke + "/"
					+ STRECKE);
			gefahreneZeit = gefahreneZeit + randomRange(0.8, 1.2);

		}
	}

	public static void main(String[] args) {
		Rennauto test = new Rennauto();
		Rennauto test1 = new Rennauto();
		Rennauto test2 = new Rennauto();
		Rennauto test3 = new Rennauto();
		Rennauto test4 = new Rennauto();
		Rennauto test5 = new Rennauto();
		test.start();
		test1.start();
		test2.start();
		test3.start();
		test4.start();
		test5.start();

		try {
			test.join();
			test1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.format("Wagen 0: %.2f\n", test.gefahreneZeit);
		System.out.format("Wagen 1: %.2f\n", test1.gefahreneZeit);
		System.out.format("Wagen 2: %.2f\n", test2.gefahreneZeit);
		System.out.format("Wagen 3: %.2f\n", test3.gefahreneZeit);
		System.out.format("Wagen 4: %.2f\n", test4.gefahreneZeit);
		System.out.format("Wagen 5: %.2f", test5.gefahreneZeit);
	}
}
