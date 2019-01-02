package KTEngine.Math;

public class Vector2 {
	
	public double x;
	public double y;
	
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2 add(Vector2 addVec) {
		return new Vector2(x + addVec.x, y + addVec.y);
	}

	public Vector2 sub(Vector2 subVec) {
		return new Vector2(x - subVec.x, y - subVec.y);
	}
	
	public Vector2 scalarMult(double scalar) {
		return new Vector2(x * scalar, y * scalar);	
	}
	
	public double dotProduct(Vector2 multVec) {
		return (x*multVec.x)+(y*multVec.y);
	}
}
