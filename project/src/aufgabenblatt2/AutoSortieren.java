/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 2
 */

package aufgabenblatt2;

import java.util.Comparator;

/**
 * Klasse zum sortieren der Rennautos
 * 
 * @author Nico
 *
 */
public class AutoSortieren implements Comparator<Rennauto> {

	@Override
	public int compare(Rennauto a0, Rennauto a1) {
		double ergebnis = 0.0;
		int returnWert = 0;
		ergebnis = a0.getGefahreneZeit() - a1.getGefahreneZeit();
		if (ergebnis < 0.0) {
			returnWert = -1;
		} else {
			if (ergebnis > 0.0) {
				returnWert = 1;
			}
		}
		return returnWert;
	}

}
