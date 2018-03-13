/**
 * 
 */
package at.spengergasse.superhorpas;

import at.spengergasse.model.Player;
import at.spengergasse.model.Position;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Miles
 *
 */
public class Map extends Stage {
	final private ActionEventListener listener;

	public Map() {
		Group root = new Group();
		Player p = new Player(false, new Position(50, 50), new ImageView("/at/spengergasse/superhorpas/Player1.png"));
		int[][] coll = p.getCollision();
		
//		@Override
//		public void handle(long now) {
//			render();
//		}
//
//		private void render() {
//			// TODO Auto-generated method stub
//		}
		
		// top level pane: includes menubar + borderpane
		VBox vBox = new VBox();

		// borderpane
		BorderPane borderPane = new BorderPane();
		// instanciate listener
		listener=new ActionEventListener(null,this,p);
		// set the scene and add borderpane to the scene
		Scene scene = new Scene(vBox, 800, 450);
		setScene(scene);
		sizeToScene();
		centerOnScreen();
		// set Icon
		Image image = new Image("/at/spengergasse/superhorpas/icon.png");
		getIcons().add(image);
		scene.addEventHandler(KeyEvent.KEY_PRESSED, listener);
		scene.addEventHandler(KeyEvent.KEY_RELEASED, listener);
		show();
	}

	
}
