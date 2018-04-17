package at.spengergasse.model;



public class Position {
	private double x;
	private double y;
	
	public Position(double x, double y) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		if(this.x + x > 0 && this.x + x < 99999) {
			this.x = x;
		}
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		if(this.y + y < 1100000 && this.y + y > 0) {
			this.y = y;
		} else {
			if(this.y < 55) {
				this.y = 50;
			}
		}
		
	}

}
