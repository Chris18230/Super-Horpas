package at.spengergasse.model;


import javafx.scene.image.ImageView;

public class Player {
	
	private Position pos;
	private Collision collision;
	private ImageView player;
	private double v  = - 10;
	public Player(Position pos,ImageView image) {
		// TODO Auto-generated constructor stub
		setPos(pos);
		setPlayer(image);
		image.setTranslateX(pos.getX());
		image.setTranslateY(pos.getY());
		collision = new Collision();
		
	}
	
	
	
	
	public void springen() {
		pos.setY(pos.getY()-20);
		player.setTranslateY(pos.getY());
	}
	public void setSpringen(boolean springen) {
		springen();
	}
	
	
	
	public void linksBewegen(){
		pos.setX(pos.getX()-2);
		player.setTranslateX(pos.getX());
	}
	public void setLeft(boolean left) {
		linksBewegen();
	}
	
	
	
	
	public void rechtsBewegen(){
		pos.setX(pos.getX()+2);
		player.setTranslateX(pos.getX());
	}
	public void setRight(boolean right) {
		rechtsBewegen();
	}
	
	
	
	
	public void obenBewegen(){
		pos.setY(pos.getY()-2);
		player.setTranslateY(pos.getY());
	}
	public void setUp(boolean up) {
		obenBewegen();
	}
	
	
	
	
	public void untenBewegen(){
		pos.setY(pos.getY()+2);
		player.setTranslateY(pos.getY());
	}
	public void setDown(boolean down) {
		untenBewegen();
	}
	
	
	public void fall() {
		pos.setY(pos.getY()+v);
		player.setTranslateY(pos.getY());
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
	

	
	public int[][] getCollision() {
		return collision.getCollision();
	}
	public void setCollision(Collision collision) {
		this.collision = collision;
	}




	public double getV() {
		return v;
	}




	public void setV(double v) {
		this.v = v;
	}
	
	
	
}
