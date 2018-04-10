/**
 * 
 */
package at.spengergasse.superhorpas;

import at.spengergasse.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * @author Miles und Christian
 *
 */
public class ActionEventListener implements EventHandler<KeyEvent> {
	// reference to panel
	final private Launcher launcher;
	final private Player p1;

	/**
	 * 
	 * @param simpleFrame
	 */
	public ActionEventListener(Launcher launcher, Map map, Player p1) {
		this.launcher = launcher;
		this.p1 = p1;
	}

	/**
	 * 
	 */
	public void handleAction(ActionEvent event) {
		// TODO Auto-generated method stub
		Object source = event.getSource();
		if (source == launcher.getStartBTN()) {
			new Map();
			launcher.close();
		}
	}

	@Override
	public void handle(KeyEvent event) {
		// TODO Auto-generated method stub
		if (event.getEventType() == KeyEvent.KEY_PRESSED) {
			// Bewegungen
			if (event.getCode() == KeyCode.A) {
				p1.setLeft(true);
			} else if (event.getCode() == KeyCode.D) {
				p1.setRight(true);
			} else if (event.getCode() == KeyCode.W) {
				p1.setUp(true);
			} else if (event.getCode() == KeyCode.S) {
				p1.setDown(true);
			}
		}
		if (event.getEventType() == KeyEvent.KEY_RELEASED) {
			if (event.getCode() == KeyCode.A) {
				p1.setLeft(false);
			}
			if (event.getCode() == KeyCode.D) {
				p1.setRight(false);
			}
			if (event.getCode() == KeyCode.W) {
				p1.setUp(false);
			}
			if (event.getCode() == KeyCode.S) {
				p1.setDown(false);
			}
		}
	}
}
