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
	private int id = 0;
	private final Rennstrecke rennstrecke;
	private double gefahreneZeit;

	/**
	 * Konstruktor
	 * 
	 * @param rennstrecke
	 *            Referenz auf die Rennstrecke die gefahren werden soll
	 */
	public Rennauto(Rennstrecke rennstrecke) {
		id = UniqueId++;
		this.rennstrecke = rennstrecke;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die gefahrene Zeit eines Rennauto zurueck
	 */
	public double getGefahreneZeit() {
		return gefahreneZeit;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die id eines Rennautos zureuck
	 */
	public int getOwnId() {
		return id;
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
	public double avgSpeed(double min, double max) {
		double range = (max - min);
		return (Math.random() * range) + min;
	}

	@Override
	public void run() {
		double startZeit = System.currentTimeMillis();
		for (double i = 1.0; i <= rennstrecke.STRECKE; i++) {
			System.err.println("Wagen " + id + ": " + i + " / "
					+ rennstrecke.STRECKE);
			try {
				Thread.sleep((long) (avgSpeed(0.8, 1.2) * 1000.0));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// TODO Stimmt noch nicht
		gefahreneZeit = (System.currentTimeMillis() - startZeit) / 1000.0;
	}

}