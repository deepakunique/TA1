
public class Sqaure {
	
	private double sideLength;
	
	public Sqaure() {
		// TODO Auto-generated constructor stub
	}
	
	public Sqaure(double sideLength) {
		this.sideLength = sideLength;
		
	}

	public double getSideLength() {
		return sideLength;
	}

	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}
	
	public double getArea() {
		
		return sideLength*sideLength;
	}

}
