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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Klasse zur Darstellung des Benutzerinterfaces
 * 
 * @author grimmilenko
 *
 */
public class Gui extends Application {

	/**
	 * Programmstartpunkt
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Polygon-Zeicheneditor");
		AnchorPane anchorPane = new AnchorPane();
		PolygonDarstellung polygonDarstellung = new PolygonDarstellung(new PolygonModell());

		// Bedienungsinterface rechte Ankerseite!
		VBox bedienung = new VBox(5);
		Button zeichneButton = new Button("Zeichne / Neues Polygon");
		zeichneButton.setOnAction(event -> {
			System.out.println("Polygon gezeichnet und neues erstellt");
		});
		bedienung.getChildren().add(zeichneButton);

		// Tabelle
		TableView<String> tabelle = new TableView<String>();
		tabelle.setPrefHeight(150);
		tabelle.setPrefWidth(250);
		TableColumn<String, Polygon> tabellenSpalte = new TableColumn<String, Polygon>("Polygon");
		tabelle.getColumns().add(tabellenSpalte);
		bedienung.getChildren().add(tabelle);

		// Befehlsbox
		HBox befehlBox = new HBox(5);

		// Eingabefeld
		TextField befehlEingabe = new TextField();

		// Hilfe-Tooltip
		Button hilfeButton = new Button("?");
		hilfeButton.setOnMouseEntered(event -> {
			hilfeButton.setEffect(new DropShadow());
		});
		hilfeButton.setOnMouseExited(event -> {
			hilfeButton.setEffect(null);
		});
		Tooltip t = new Tooltip("Mögliche Befehle!");
		hilfeButton.setTooltip(t);

		// Button zum abschicken des Befehls
		Button eingabeButton = new Button("Eingabe");
		befehlBox.getChildren().addAll(befehlEingabe, hilfeButton, eingabeButton);
		eingabeButton.setOnAction(event -> {
			System.out.println(befehlEingabe.getText());
		});
		bedienung.getChildren().add(befehlBox);

		// Exit-Button
		Button exitButton = new Button("Exit");
		exitButton.setOnAction((ereignis) -> {
			primaryStage.close();
		});
		bedienung.getChildren().add(exitButton);

		// AnchorPane zusammensetzen
		AnchorPane.setRightAnchor(bedienung, 10.0);
		AnchorPane.setTopAnchor(bedienung, 10.0);
		AnchorPane.setBottomAnchor(bedienung, 10.0);
		anchorPane.getChildren().add(bedienung);
		anchorPane.getChildren().add(polygonDarstellung.getPane());

		// Stage anzeigen
		primaryStage.setScene(new Scene(anchorPane, 500, 255));
		primaryStage.show();
	}

}
