/**
 * 
 */
package at.spengergasse.superhorpas;

import at.spengergasse.model.Player;
import at.spengergasse.model.Position;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Miles und Christian
 *
 */ 
public class Map extends Stage {
	final private ActionEventListener listener;

	public Map() {
		Group root = new Group();
		GridPane grid = new GridPane();
		Player p = new Player(false, new Position(50,50), new ImageView("/at/spengergasse/superhorpas/Player1.png"));
		grid.getChildren().add(p.getImageView());
		
		
		AnimationTimer gl = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				render();
				update();
			}
			
			private void render() {
				root.getChildren().clear();
				grid.getChildren().clear();
				root.getChildren().add(grid);	
				root.getChildren().add(p.getImageView());
			}

			private void update() {
				// Spielerbewegungen
				if (p.isLeft() && !p.isRight()) {
					p.linksBewegen();
				} else if (p.isRight() && !p.isLeft()) {
					p.rechtsBewegen();
				}
				if (p.isUp() && !p.isDown()) {
					p.obenBewegen();
				} else if (p.isDown() && !p.isUp()) {
					p.untenBewegen();
				}
			}
		};
		
		// top level pane: includes menubar + borderpane
		VBox vBox = new VBox();

		// borderpane
		BorderPane borderPane = new BorderPane();
		
		//add grid to borderPane
		borderPane.setCenter(grid);
		
		//add borderPane to vBox
		vBox.getChildren().addAll(borderPane);
		
		// instanciate listener
		listener=new ActionEventListener(null,this,p);
		
		
		// set the scene and add borderpane to the scene
		Scene scene = new Scene(vBox, 800, 450);
		setScene(scene);
		sizeToScene();
		centerOnScreen();
		setTitle("Super Horpas");
		// set Icon
		Image image = new Image("/at/spengergasse/superhorpas/icon.png");
		getIcons().add(image);
		scene.addEventHandler(KeyEvent.KEY_PRESSED, listener);
		scene.addEventHandler(KeyEvent.KEY_RELEASED, listener);
		show();

	}
}
