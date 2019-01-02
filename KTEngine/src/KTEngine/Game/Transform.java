package KTEngine.Game;

import KTEngine.Math.Vector2;

public class Transform {

	public Vector2 pos;
	public Vector2 rot;
	public Vector2 scale;
	
	public Transform(Vector2 pos) {
		this.pos = pos;
		this.rot = new Vector2(0,0);
		this.rot = new Vector2(1,1);
	}
	
	public Transform(Vector2 pos, Vector2 rot) {
		this.pos = pos;
		this.rot = rot;
		this.rot = new Vector2(1,1);
	}
	
	public Transform(Vector2 pos, Vector2 rot, Vector2 scale) {
		this.pos = pos;
		this.rot = rot;
		this.scale = scale;
	}
	
	public void updatePos(double newX, double newY) {
		pos.x = newX;
		pos.y = newY;
	}
}
