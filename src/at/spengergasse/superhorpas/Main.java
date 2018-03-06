package at.spengergasse.superhorpas;
	


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1024,760);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Super Horpas");
			Image image = new Image("/at/spengergasse/superhorpas/icon.png");
			Image imgBackground = new Image(getClass().getResource("/at/spengergasse/superhorpas/launcher_bg.jpeg").toExternalForm());
			BackgroundImage backgroundImage = new BackgroundImage(imgBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	        Background background = new Background(backgroundImage);
	        root.setBackground(background);
			primaryStage.getIcons().add(image);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
