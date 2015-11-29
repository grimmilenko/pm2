package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimulationVisuell extends Application implements Observer{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		
		GridPane gridpane = new GridPane();
		StackPane root = new StackPane();
		root.getChildren().add(gridpane);
		stage.setTitle("Bahnhofssimulation");
		stage.setScene(new Scene (root, 200, 300));
		Simulation sim = new Simulation();
		sim.addObserver(this); 
		new Thread(sim).start();
		
		
		try{
			Thread.sleep(3000);
			stage.show();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
		
		//public Task<Boolean> aufgabe = new Task<Boolean>();
			
			//protected Boolean call() throws Exception{
				//int numberofSteps = 20;
				//updateProgress(0,numberofSteps -1);
			
		
		
		
		
		
		
		
		
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
	
	

	
	
}
