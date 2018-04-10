package at.spengergasse.model;

public class Collision {
	private boolean hit;
	
	private int[][] collision = new int[][] {
		{80,50},
		{80,450},
		{400,50},
		{400,450}
	};
	
	public Collision() {
		// TODO Auto-generated constructor stub
	}
	public boolean isHit() {
		return hit;
	}
	public void setHit(boolean hit) {
		this.hit = hit;
	}
	
	public int[][] getCollision() {
		return collision;
	}
	public void setCollision(int[][] collision) {
		this.collision = collision;
	}
}
