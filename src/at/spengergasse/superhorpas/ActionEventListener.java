/**
 * 
 */
package at.spengergasse.superhorpas;

import static java.lang.Math.random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * @author Miles
 *
 */
public class ActionEventListener implements EventHandler<ActionEvent> {
	// reference to panel
	final private Launcher launcher;

	/**
	 * 
	 * @param simpleFrame
	 */
	public ActionEventListener(Launcher launcher){
	this.launcher=launcher;
	}
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		Object source=event.getSource();
		if (source==launcher.getStartBTN()) {
			new Map();
			launcher.close();
		}
	}
	
	
}
