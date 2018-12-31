package KTEngine.Math;

public class Vector3f {

	public float x;
	public float y;
	public float z;
	
	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3f add(Vector3f addVec) {
		return new Vector3f(x + addVec.x, y + addVec.y, z + addVec.z);
	}

	public Vector3f sub(Vector3f subVec) {
		return new Vector3f(x - subVec.x, y - subVec.y, z - subVec.z);
	}
	
	public Vector3f scalarMult(float scalar) {
		return new Vector3f(x * scalar, y * scalar, z * scalar);	
	}
	
	public float dotProduct(Vector3f multVec) {
		return (x*multVec.x) + (y*multVec.y) + (z*multVec.z);
	}
	
}
