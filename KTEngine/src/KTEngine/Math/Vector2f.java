package KTEngine.Math;

public class Vector2f {
	
	public float x;
	public float y;
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2f add(Vector2f addVec) {
		return new Vector2f(x + addVec.x, y + addVec.y);
	}

	public Vector2f sub(Vector2f subVec) {
		return new Vector2f(x - subVec.x, y - subVec.y);
	}
	
	public Vector2f scalarMult(float scalar) {
		return new Vector2f(x * scalar, y * scalar);	
	}
	
	public Vector2f dotProduct(Vector2f multVec) {
		return new Vector2f(x * multVec.x, y * multVec.y);
	}
}
