/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

/**
 * Klasse zur Realisierung eines Rennabbruchs
 * 
 * @author Nico
 *
 */
public class RoteFlagge extends Thread {
	private Rennstrecke strecke;

	public RoteFlagge(Rennstrecke strecke) {
		this.strecke = strecke;
	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			double abbruch = Math.random();
			if (abbruch <= 0.1) {
				System.err.println("---Rote Flagge!---");
				for (int i = 0; i < strecke.getAutos().size(); i++) {
					strecke.getAutos().get(i).interrupt();
				}
				this.interrupt();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
