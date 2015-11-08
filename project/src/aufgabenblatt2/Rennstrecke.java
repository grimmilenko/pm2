/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse zur Realisierung einer Rennstrecke
 * 
 * @author Nico
 *
 */
public class Rennstrecke {
	protected static double gefahreneStrecke = 0.0;
	protected final double STRECKE = 10.0;

	/**
	 * Methode zum fahren einer Runde
	 */
	public void runde() {
		gefahreneStrecke++;
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Rennstrecke test = new Rennstrecke();
		List<Rennauto> autos = new ArrayList<Rennauto>();
		for (int i = 0; i < 5; i++) {
			autos.add(new Rennauto(test));
		}
		for (int i = 0; i < autos.size(); i++) {
			autos.get(i).start();
		}
		for (int i = 0; i < autos.size(); i++) {
			try {
				autos.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("-----ZIEL-----");
		System.out.println("Zeit des Rennens: " + (elapsedTime / 1000.0)
				+ "Sekunden!");
		System.out.println("Platzierungen:");
		for (int i = 0; i < autos.size(); i++) {
			System.out.println(autos.get(i).gefahreneZeit);
		}
	}
}
