/**
 * 
 */
package at.spengergasse.superhorpas;

import at.spengergasse.model.Player;
import at.spengergasse.model.Position;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Miles und Christian
 *
 */
public class Map extends Stage{
	private static final double GRAVITY = 0.2;
	final private ActionEventListener listener;
	
		public Map(){		
			// top level pane: includes menubar + borderpane
			VBox vBox=new VBox();
			
			// gridpane contains rows and columns
			GridPane gridPane=new GridPane();
			gridPane.setPadding(new Insets(10,10,10,10));
			
			// gap between the components
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			
			Player p = new Player(new Position(50,50), new ImageView("/at/spengergasse/superhorpas/Player1.png"));
		
			AnimationTimer timer = new AnimationTimer() {
				
				@Override
				public void handle(long now) {
					p.setV(p.getV()+GRAVITY);
					p.fall();
				}
			};
			timer.start();
			gridPane.getChildren().add(p.getImageView());
			
			
			// borderpane
			BorderPane borderPane = new BorderPane();
			
			//add grid to borderPane
			borderPane.setCenter(gridPane);
			
			//add borderPane to vBox
			vBox.getChildren().addAll(borderPane);
			
			// instanciate listener
			listener=new ActionEventListener(null,this,p);
			
			// set properties of the frame
			setTitle("Super Horpas");
			centerOnScreen();
			setResizable(true);

			// set the scene and add borderpane to the scene
			Scene scene=new Scene(vBox, 800, 450);
			setScene(scene);
			sizeToScene();
			//set Icon
			Image image = new Image("/at/spengergasse/superhorpas/icon.png");
			getIcons().add(image);
			
			Image imgBackground = new Image(getClass().getResource("/at/spengergasse/superhorpas/game.jpg").toExternalForm());
			BackgroundImage backgroundImage = new BackgroundImage(imgBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	        Background background = new Background(backgroundImage);
	        vBox.setBackground(background);
	        scene.addEventHandler(KeyEvent.KEY_PRESSED, listener);
			scene.addEventHandler(KeyEvent.KEY_RELEASED, listener);
			// show frame
			show();
			}
}