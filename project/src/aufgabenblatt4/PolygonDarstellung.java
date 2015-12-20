/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 4
 */

package aufgabenblatt4;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.scene.layout.Pane;

/**
 * Klasse zur Darstellung der Polygone
 * 
 * @author grimmilenko
 *
 */
public class PolygonDarstellung extends Pane implements Observer {
	private PolygonModell modell;

	/**
	 * Konstruktor
	 * 
	 * @param modell
	 *            Referenz auf das zu zeichnende PolygonModell
	 */
	public PolygonDarstellung(PolygonModell modell) {
		this.modell = modell;
	}

	@Override
	public void update(Observable o, Object arg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		});
	}
}
