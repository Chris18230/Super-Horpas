/**
 * 
 */
package at.spengergasse.superhorpas;

import at.spengergasse.model.MusicPlayer;
import at.spengergasse.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.MediaPlayer;

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
			
			MusicPlayer mplayer = new MusicPlayer(false);
			mplayer.playSound();
			
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
			} else if (event.getCode() == KeyCode.S) {
				p1.setDown(true);
			} else if( event.getCode() == KeyCode.DOWN) {
				p1.setDown(true);
			} else if (event.getCode() == KeyCode.RIGHT) {
				p1.setRight(true);
			} else if (event.getCode() == KeyCode.LEFT) {
				p1.setLeft(true);
			} else if (event.getCode() == KeyCode.SPACE) {
				p1.setSpringen(true);
			}
		}
		if (event.getEventType() == KeyEvent.KEY_RELEASED) {
			if (event.getCode() == KeyCode.A) {
				p1.setLeft(false);
			}
			if (event.getCode() == KeyCode.D) {
				p1.setRight(false);
			}
			if (event.getCode() == KeyCode.S) {
				p1.setDown(false);
			} else if( event.getCode() == KeyCode.DOWN) {
				p1.setDown(false);
			} else if (event.getCode() == KeyCode.RIGHT) {
				p1.setRight(false);
			} else if (event.getCode() == KeyCode.LEFT) {
				p1.setLeft(false);
			} else if (event.getCode() == KeyCode.SPACE) {
				p1.setSpringen(false);
			}
		}
	}
}
