/**
 * Praktikum PM2, WS 15/16
 * Nico Grimm (nico.grimm@haw-hamburg.de)
 * Marco Colbow (marco.colbow@haw-hamburg.de)
 * Aufgabe 3
 */

package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 * Klasse, die die Bahnhofsimulation visuell darstellt
 * 
 * @author Nico, Marco
 *
 */
public class SimulationVisuell extends Application implements Observer {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		GridPane gridpane = new GridPane();
		StackPane root = new StackPane();
		root.getChildren().add(gridpane);
		stage.setTitle("Bahnhofssimulation");
		stage.setScene(new Scene(root, 200, 300));
		Simulation sim = new Simulation();
		sim.addObserver(this);
		new Thread(sim).start();

		try {
			Thread.sleep(3000);
			stage.show();
			addBahnhof(gridpane);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// public Task<Boolean> aufgabe = new Task<Boolean>();

	// protected Boolean call() throws Exception{
	// int numberofSteps = 20;
	// updateProgress(0,numberofSteps -1);

	/**
	 * Methode, die einen Bahnhof zeichnet
	 * 
	 * @param root
	 *            das Fenster in dem gezeichnnet wird
	 * 
	 */
	private void addBahnhof(Pane root) {
		Path path = new Path();
		MoveTo moveTo = new MoveTo();
		moveTo.setX(0);
		moveTo.setY(0);
		LineTo lineTo = new LineTo();
		// lineTo.setX(0);
		// lineTo.setY(0);
		LineTo lineTo2 = new LineTo();
		LineTo lineTo3 = new LineTo();
		LineTo lineTo4 = new LineTo();
		LineTo lineTo5 = new LineTo();
		LineTo lineTo6 = new LineTo();
		LineTo lineTo7 = new LineTo();
		LineTo lineTo8 = new LineTo();
		LineTo lineTo9 = new LineTo();
		LineTo lineTo10 = new LineTo();
		LineTo lineTo11 = new LineTo();
		LineTo lineTo12 = new LineTo();
		LineTo lineTo13 = new LineTo();
		LineTo lineTo14 = new LineTo();

		lineTo.setX(100);
		lineTo.setY(0);
		lineTo2.setX(100);
		lineTo2.setY(30);
		// moveTo.setX(10);
		// moveTo.setY(10);
		lineTo3.setX(30);
		lineTo3.setY(30);
		lineTo4.setX(30);
		lineTo4.setY(40);
		lineTo5.setX(100);
		lineTo5.setY(40);
		lineTo6.setX(100);
		lineTo6.setY(70);
		lineTo7.setX(30);
		lineTo7.setY(70);
		lineTo8.setX(30);
		lineTo8.setY(80);
		lineTo9.setX(100);
		lineTo9.setY(80);
		lineTo10.setX(100);
		lineTo10.setY(110);
		lineTo11.setX(0);
		lineTo11.setY(110);

		path.getElements().add(moveTo);
		path.getElements().add(lineTo);
		path.getElements().add(lineTo2);
		path.getElements().add(lineTo3);
		path.getElements().add(lineTo4);
		path.getElements().add(lineTo5);
		path.getElements().add(lineTo6);
		path.getElements().add(lineTo7);
		path.getElements().add(lineTo8);
		path.getElements().add(lineTo9);
		path.getElements().add(lineTo10);
		path.getElements().add(lineTo11);
		path.getElements().add(lineTo12);
		path.getElements().add(lineTo13);
		path.getElements().add(lineTo14);

		path.setTranslateY(30);
		path.setStrokeWidth(3);
		path.setStroke(Color.BLACK);
		root.getChildren().add(path);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// addBahnhof(Pane root);
	}
}
