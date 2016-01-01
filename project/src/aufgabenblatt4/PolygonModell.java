/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 4
 */

package aufgabenblatt4;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Klasse zum Modellieren eines Polygons
 * 
 * @author grimmilenko
 *
 */
public class PolygonModell extends Observable implements Observer {
	/**
	 * Liste der Polygone
	 */
	private List<Polygon> polygone = new ArrayList<Polygon>();
	private Polygon aktuellesPolygon;

	/**
	 * Methode zum abschliessen der Bearbeitung eines Polygons
	 */
	public void bearbeitungZuEnde() {
		polygone.add(aktuellesPolygon);
		aktuellesPolygon = new Polygon();
		aktuellesPolygon.addObserver(this);
		setChanged();
		notifyObservers();
	}

	/**
	 * Default-Kostruktor
	 */
	public PolygonModell() {
		aktuellesPolygon = new Polygon();
	}

	/**
	 * Kostruktor
	 * 
	 * @param polygon
	 *            Referenz auf das zu bearbeitende Polygon
	 */
	public PolygonModell(Polygon polygon) {
		aktuellesPolygon = polygon;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt das aktuelle zu bearbeitende Polygon zurueck
	 */
	public Polygon getPolygon() {
		return aktuellesPolygon;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die Liste der Polygone zurueck
	 */
	public List<Polygon> getListePolygone() {
		return polygone;
	}

	@Override
	public void update(Observable o, Object arg) {
		notifyObservers();
	}

}