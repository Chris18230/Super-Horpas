package at.spengergasse.superhorpas;
	


import javafx.application.Application;
import javafx.stage.Stage;



/**
 * 
 * @author Miles und Christian
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new Map();
	 }

	public static void main(String[] args) {
		launch(args);
	}
}
