/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 4
 */

package aufgabenblatt4;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Klasse zur Darstellung der Polygone
 * 
 * @author grimmilenko
 *
 */
public class PolygonDarstellung extends Pane implements Observer {
	private PolygonModell modell;
	private Pane pane = new Pane();

	/**
	 * Konstruktor
	 * 
	 * @param modell
	 *            Referenz auf das zu zeichnende PolygonModell
	 */
	public PolygonDarstellung(PolygonModell modell) {
		this.modell = modell;
		this.modell.addObserver(this);
	}

	private Ellipse zeichnePunkt(Double centerX, Double centerY) {
		Ellipse punkt = new Ellipse(2, 2);
		punkt.setCenterX(centerX);
		punkt.setCenterY(centerY);

		return punkt;

	}

	private void zeichne() {

		for (int i = 0; i < modell.getListePolygone().size() - 1; i++) {
			for (int j = 0; j < modell.getListePolygone().get(i).getListePunkte().size(); j++) {
				pane.getChildren().add(zeichnePunkt(modell.getListePolygone().get(i).getXAtIndex(j),
						modell.getListePolygone().get(i).getYAtIndex(j)));
			}
		}
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die gezeichnete Pane zurueck
	 */
	public Pane getPane() {
		// TODO alles muss zusammengefuegt werden
		zeichne();
		return pane;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO was passiert beim update?
	}
}
