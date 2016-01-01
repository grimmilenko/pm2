/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 4
 */

package aufgabenblatt4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Klasse zur Darstellung des Benutzerinterfaces
 * 
 * @author grimmilenko
 *
 */
public class Gui extends Application {

	private Stage primaryStage;
	private Pane pane;

	/**
	 * Breite und Hoehe der Anwendung
	 */
	private final int width, height;

	private PolygonDarstellung polygonDarstellung;

	/**
	 * Programmstartpunkt
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Default-Konstruktor
	 */
	public Gui() {
		height = 600;
		width = 600;
	}

	@Override
	public void start(Stage primaryStagePar) {
		primaryStage = primaryStagePar;
		primaryStage.setTitle("Polygon-Zeicheneditor");
		pane = paneInit();
		primaryStage.setScene(new Scene(pane, width, height));
		primaryStage.show();
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die Pane zurueck
	 */
	public Pane getPane() {
		return pane;
	}

	/**
	 * Methode zum erstellen der GUI
	 * 
	 * @return Gibt die GUI als BorderPane zurueck
	 */
	private Pane paneInit() {
		BorderPane pane = new BorderPane();
		pane.setLeft(polygonTabelle());
		pane.setCenter(zeichenflaeche());
		pane.setBottom(befehlInput());
		return pane;
	}

	/**
	 * Methode zum erstellen der Befehlseingabe
	 * 
	 * @return Gibt die Befehlseingabe als BorderPane zurueck
	 */
	private Pane befehlInput() {
		BorderPane pane = new BorderPane();
		TextArea area = new TextArea();
		area.setMaxHeight(50);
		pane.setCenter(area);
		pane.setBottom(befehlButtons());
		return pane;
	}

	/**
	 * Methode zum erstellen der Buttons fuer die Befehlseingabe
	 * 
	 * @return Gibt die Buttons in einer HBox zureuck
	 */
	private Pane befehlButtons() {
		HBox pane = new HBox();
		pane.setSpacing(10);
		Button hilfe = new Button("?");
		hilfe.setTooltip(new Tooltip("tooltip"));
		Button befehl = new Button("Fuehre aus!");
		Button fertig = new Button("Fertig");
		Button close = new Button("Exit");
		close.setOnAction(event -> {
			primaryStage.close();
		});
		pane.getChildren().addAll(hilfe, befehl, fertig, close);
		return pane;
	}

	/**
	 * Methode zum erstellen der PolygonDarstellung
	 * 
	 * @return Gibt die PolygonDarstellung zurueck
	 */
	private Pane zeichenflaeche() {
		StackPane pane = new StackPane();
		polygonDarstellung = new PolygonDarstellung();
		return pane;
	}

	/**
	 * Methode zum erstellen einer Tabelle, die die gezeichneten Polygone
	 * anzeigt
	 * 
	 * @return Gibt eine Tabelle als BorderPane zurueck
	 */
	private Pane polygonTabelle() {
		BorderPane pane = new BorderPane();
		TableView<Polygon> tablle = new TableView<Polygon>();
		pane.setCenter(tablle);
		return pane;
	}
}
