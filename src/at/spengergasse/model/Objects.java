/**
 * 
 */
package at.spengergasse.model;


import javafx.scene.image.ImageView;

/**
 * @author chris
 *
 */
public class Objects {
	
	private Position pos;
	private ImageView block;
	
	public Objects(Position pos, ImageView image) {
		setPos(pos);
		setBlock(image);
		image.setTranslateX(pos.getX());
		image.setTranslateY(pos.getY());
	}
	
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public ImageView getBlock() {
		return block;
	}
	public void setBlock(ImageView block) {
		this.block = block;
	} 
}
