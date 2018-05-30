package at.spengergasse.superhorpas;
	


import at.spengergasse.model.MusicPlayer;
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
		new Launcher();
	 }

	public static void main(String[] args) {
		launch(args);
	}
}
