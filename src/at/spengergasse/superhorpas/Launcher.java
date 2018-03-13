/**
 * 
 */
package at.spengergasse.superhorpas;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Math.random;

/**
 * @author Miles
 *
 */
public class Launcher extends Stage{
	
	// buttons
		final private Button startBTN;
		// menu items
		final MenuItem menuDefaultMI, menuCloseMI;

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
			
			//flowpane for buttons
			FlowPane buttonPane=new FlowPane();
			// default button
			startBTN=new Button("Start");
		
			

			
			buttonPane.setHgap(10);
			// add components
			buttonPane.getChildren().add(startBTN);

			gridPane.add(startBTN, 50, 35);

			// add panes to borderpane
			borderPane.setBottom(buttonPane);
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
			
	        
	        
	        Group circles = new Group();
	        for (int i = 0; i < 30; i++) {
	           Circle circle = new Circle(150, Color.web("white", 0.05));
	           circle.setStrokeType(StrokeType.OUTSIDE);
	           circle.setStroke(Color.web("white", 0.16));
	           circle.setStrokeWidth(4);
	           circles.getChildren().add(circle);
	        }
	        borderPane.getChildren().add(circles);    
	        
	        
			startBTN.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("test");
					startBTN.setStyle("fx-background-color: black");
					startBTN.resize(300, 200);
					
					Timeline timeline = new Timeline();
					for (Node circle: circles.getChildren()) {
					    timeline.getKeyFrames().addAll(
					        new KeyFrame(Duration.ZERO, // set start position at 0
					            new KeyValue(circle.translateXProperty(), random() * 800),
					            new KeyValue(circle.translateYProperty(), random() * 600)
					        ),
					        new KeyFrame(new Duration(40000), // set end position at 40s
					            new KeyValue(circle.translateXProperty(), random() * 800),
					            new KeyValue(circle.translateYProperty(), random() * 600)
					        )
					    );
					}
					// play 40s of animation
					timeline.play();
				}
				
			});
	        
			// show frame
			show();
		}

		/**
		 * @return the defaultBTN
		 */
		public Button getDefaultBTN() {
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
