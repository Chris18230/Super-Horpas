/**
 * 
 */
package at.spengergasse.superhorpas;


import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import at.spengergasse.model.Objects;
import at.spengergasse.model.Player;
import at.spengergasse.model.Position;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Miles und Christian
 *
 */
public class Map extends Stage{
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
			
			Player p = new Player(new Position(0,772.5), new ImageView("/at/spengergasse/superhorpas/Player1.png"));
			Objects o = new Objects(new Position(0,800), new ImageView("/at/spengergasse/superhorpas/Brett.jpg"));
			Objects o1 = new Objects(new Position(1720,150), new ImageView("/at/spengergasse/superhorpas/Brett.jpg"));
		
			gridPane.getChildren().add(p.getImageView());
			gridPane.getChildren().add(o.getBlock());
			gridPane.getChildren().add(o1.getBlock());
			Label zeit = new Label();
			zeit.setTextFill(Color.web("#0076a3"));
	    	zeit.setMaxSize(150,45);
			Instant start = Instant.now();
			gridPane.getChildren().add(zeit);
			AnimationTimer animator = new AnimationTimer() {
				Instant now = Instant.now();
		        public void handle(long arg0) {
		            double playX = p.getPos().getX(), objectX = o.getPos().getX();
		            double playY = p.getPos().getY(), objectY = o.getPos().getY();
		            System.out.println("Player's X: "+ playX + "\n" + "Objects's X: " + objectX);
		            System.out.println("Player's Y: "+ playY + "\n" + "Object's Y: " + objectY);

		            
		            if(p.getImageView().getBoundsInParent().intersects(o.getBlock().getBoundsInParent()) == true)
		            {
		               p.setDown(false); p.setRight(false); p.setUp(false);
		            }
		            if(p.getImageView().getBoundsInParent().intersects(o1.getBlock().getBoundsInParent()) == true)
		            {
		            	p.setLeft(false); p.setUp(false); p.setDown(false);
		            }
//		            if(p.getImageView().getBoundsInParent().intersects(o1.getBlock().getBoundsInParent()) == false)
//		            {
//		               p.setDown(false); p.setRight(false); p.setUp(false);
//		            }
//		            if(p.getImageView().getBoundsInParent().intersects(o.getBlock().getBoundsInParent()) == false)
//		            {
//		            	p.fall();
//		            }
	        		now = Instant.now();
	        		Duration e = Duration.between(start, now);
			    	zeit.setText("Time: " + e.ofSeconds(e.getSeconds()).toMinutes() + ":" + e.toMillis()/100);  
		        }//handle
		    };
		    animator.start();//animation
		   
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