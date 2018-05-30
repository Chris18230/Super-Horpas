package at.spengergasse.model;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer {
	private MediaPlayer mp = null;
	private boolean playing;
	
	private String ssound = "music/Homestuck-DanceOfThorns.mp3";
	
	public MusicPlayer(boolean playing){
		this.playing = playing;
	}

	  public void playSound() {
	    if (!playing) {
	    	Media sound = new Media(new File(ssound).toURI().toString());
	    	mp = new MediaPlayer(sound);
	    	playing = true;
	    	mp.play();
	    } else {
	    	playing = false;
	    	mp.stop();
	    }
	  }
}
