package at.spengergasse.model;



public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if(this.x + x > 0 && this.x + x < 99999) {
			this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if(this.y + y < 1100000 && this.y + y > 0) {
			this.y = y;
		} else {
			if(this.y < 55) {
				this.y = 50;
			}
		}
		
	}

}
