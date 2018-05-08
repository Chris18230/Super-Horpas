package at.spengergasse.model;


import javafx.scene.image.ImageView;

public class Player {
	
	private static final int JUMP_BOOST = -10;
	private static final double GRAVITATION = 0.2;
	private Position pos;
	private ImageView player;
	private double v  = JUMP_BOOST;
	public Player(Position pos,ImageView image) {
		// TODO Auto-generated constructor stub
		setPos(pos);
		setPlayer(image);
		image.setTranslateX(pos.getX());
		image.setTranslateY(pos.getY());
	}
	
	private boolean springen;
	private boolean inDerLuft = false;
	public void springen() {
		pos.setY(pos.getY()+10);
		player.setTranslateY(pos.getY());
	}
	public void setSpringen(boolean springen) {
		this.springen = springen;
	}
	
	
	private boolean left;
	public void linksBewegen(){
		pos.setX(pos.getX()-5);
		player.setTranslateX(pos.getX());
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	
	
	
	private boolean right;
	public void rechtsBewegen(){
		pos.setX(pos.getX()+5);
		player.setTranslateX(pos.getX());
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	
	
	public void untenBewegen(){
		pos.setY(pos.getY()+20);
		player.setTranslateY(pos.getY());
	}
	
	private boolean down;
	public void setDown(boolean down) {
		this.down = down;
	}
	
	
	public void fall() {
		v+=GRAVITATION;
		pos.setY(pos.getY()+v);
		player.setTranslateY(pos.getY());
	}
	
	private Position oldPos = new Position(0., 0.);
	public void update() {
		oldPos.setX(pos.getX());
		oldPos.setY(pos.getY());
		if(springen) {
			if(!inDerLuft) {
				v = JUMP_BOOST;
				inDerLuft = true;
			}
			springen = false;
		} if(left) {
			linksBewegen();
		} if(right) {
			rechtsBewegen();
		}
		fall();
	}
	
	public void bodenErreicht() {
		pos.setY(oldPos.getY());
		v = 0;
		inDerLuft = false;
	}
	
	public Position getPos() {
		return pos;
	}
	
	public void setPos(Position pos) {
		
		this.pos = pos;
	}
	
	public ImageView getPlayer() {
		return player;
	}
	public void setPlayer(ImageView player) {
		this.player = player;
	}
	public ImageView getImageView() {
		return this.player;
	}
	public double getV() {
		return v;
	}
	public void checkCollision() {
		System.out.println("CurentPosition: " + pos.getX() + " , " + pos.getY());
	}

	
}
