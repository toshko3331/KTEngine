package KTEngine.Game;

import KTEngine.Math.Vector3f;

public class Transform {

	public Vector3f pos;
	public Vector3f rot;
	public Vector3f scale;
	
	public Transform(Vector3f pos) {
		this.pos = pos;
		this.rot = new Vector3f(0,0,0);
		this.rot = new Vector3f(1,1,1);
	}
	
	public Transform(Vector3f pos, Vector3f rot) {
		this.pos = pos;
		this.rot = rot;
		this.rot = new Vector3f(1,1,1);
	}
	
	public Transform(Vector3f pos, Vector3f rot, Vector3f scale) {
		this.pos = pos;
		this.rot = rot;
		this.scale = scale;
	}
}
