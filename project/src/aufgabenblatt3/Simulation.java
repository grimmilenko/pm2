/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 3
 */

package aufgabenblatt3;

import java.util.Observable;

import aufgabenblatt3.LokfuehrerNeu.Aufgabe;

/**
 * Klasse zur Repraesentation einer Bahnhofssimulation
 * 
 * @author Nico
 *
 */
public class Simulation extends Observable implements Runnable {
	protected Rangierbahnhof rangierbahnhof;

	/**
	 * Zufalls-Generator zur Erstellung einer Aufgabe fuer einen Lokfuehrer
	 * 
	 * @return Gibt eine Aufgabe fuer einen Lokfuehrer zurueck
	 */
	public Aufgabe erstelleAufgabe() {
		if (Math.random() < 0.5) {
			return Aufgabe.EINFAHREN;
		} else {
			return Aufgabe.AUSFAHREN;
		}
	}

	public Rangierbahnhof getRangierbahnhof() {
		return rangierbahnhof;
	}

	@Override
	public void run() {
		rangierbahnhof = new Rangierbahnhof();
		while (true) {
			LokfuehrerNeu arbeiter = new LokfuehrerNeu(rangierbahnhof,
					erstelleAufgabe());

			arbeiter.start();

			setChanged();
			notifyObservers();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Main-Methode zur Ausfuehrung der Simulation
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Thread simThread = new Thread(new Simulation());
		simThread.start();
	}
}
