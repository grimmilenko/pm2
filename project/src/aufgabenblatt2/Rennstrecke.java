/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Klasse zur Realisierung einer Rennstrecke
 * 
 * @author Nico
 *
 */
public class Rennstrecke {
	protected static double gefahreneStrecke = 0.0;
	protected final double STRECKE = 10.0;
	private List<Rennauto> autos;

	public Rennstrecke() {
		this.autos = new ArrayList<Rennauto>();
		for (int i = 0; i < 5; i++) {
			autos.add(new Rennauto(this));
		}
	}

	public List<Rennauto> getAutos() {
		return autos;
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Rennstrecke test = new Rennstrecke();
		RoteFlagge abbruch = new RoteFlagge(test);

		for (int i = 0; i < test.getAutos().size(); i++) {
			test.getAutos().get(i).start();
		}
		abbruch.start();
		for (int i = 0; i < test.getAutos().size(); i++) {
			try {
				test.getAutos().get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		abbruch.interrupt();
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("-----ZIEL-----");
		System.out.format("Zeit des Rennens: %.2f Sekunden!\n",
				(elapsedTime / 1000.0));
		System.out.println("-----Platzierungen-----");

		Collections.sort(test.getAutos(), new AutoSortieren());

		for (int i = 0; i < test.getAutos().size(); i++) {
			System.out.format("%d.: Wagen %d: %.2f Sekunden!\n", i + 1, test
					.getAutos().get(i).getOwnId(), test.getAutos().get(i)
					.getGefahreneZeit());
		}
	}
}
