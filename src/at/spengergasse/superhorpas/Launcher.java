/**
 * 
 */
package at.spengergasse.superhorpas;


import java.io.File;

import at.spengergasse.model.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * @author Miles und Christian
 *
 */
public class Launcher extends Stage{
	
	// buttons
		final private Button startBTN;
		// menu items
		final MenuItem menuDefaultMI, menuCloseMI;

		// reference to the listener
		final private ActionEventListener actionListener;	
		
		
		private MusicPlayer mPlayer;
		
		/**
		 * 
		 */
		public Launcher(){		
			// top level pane: includes menubar + borderpane
			VBox vBox=new VBox();
			
			// borderpane
			BorderPane borderPane=new BorderPane();
			
			// gridpane contains rows and columns
			GridPane gridPane=new GridPane();
			gridPane.setPadding(new Insets(10,10,10,10));
			
			// gap between the components
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			
			//start button
			startBTN=new Button("Start");
			// instanciate listener
			actionListener=new ActionEventListener(this,null,null);
			
			gridPane.add(startBTN, 30, 20);
			borderPane.setCenter(gridPane);
			
			// set properties of the frame
			setTitle("Super Horpas");
			centerOnScreen();
			setResizable(false);

			// create and add a menu	
			MenuBar menuBar = new MenuBar();
	        // Menu file, the underscore defines the following character for mnemonic
			// there is method setMnemonicParsing - default is true
	        Menu menuFile = new Menu("_File");
	 
	        // menu edit
	        Menu menuEdit = new Menu("_Edit");
	        //Listener for StartBTN
			startBTN.addEventHandler(ActionEvent.ACTION, actionListener::handleAction);
			startBTN.setPrefWidth(200);
	        // menu default
	        menuDefaultMI = new MenuItem("Default");
	        // menu close
	        menuCloseMI = new MenuItem("_Close");
	        // menu window
	        Menu menuWindow = new Menu("_Window");
	        // add menus to menu bar 
	        menuBar.getMenus().addAll(menuFile,menuEdit,menuWindow);
	        
	        // add menu bar and borderpane to vbox
	        vBox.getChildren().addAll(menuBar,borderPane);

			// set the scene and add borderpane to the scene
			Scene scene=new Scene(vBox, 800, 450);
			setScene(scene);
			sizeToScene();
			//set Icon
			Image image = new Image("/at/spengergasse/superhorpas/icon.png");
			getIcons().add(image);
			
			Image imgBackground = new Image(getClass().getResource("/at/spengergasse/superhorpas/launcher_bg.jpeg").toExternalForm());
			BackgroundImage backgroundImage = new BackgroundImage(imgBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	        Background background = new Background(backgroundImage);
	        vBox.setBackground(background);
	        
			// show frame
			show();
		}
		/**
		 * @return the defaultBTN
		 */
		public Button getStartBTN() {
			return startBTN;
		}
		/**
		 * @return the menuDefaultMI
		 */
		public MenuItem getMenuDefaultMI() {
			return menuDefaultMI;
		}
		/**
		 * @return the menuCloseMI
		 */
		public MenuItem getMenuCloseMI() {
			return menuCloseMI;
		}

}
