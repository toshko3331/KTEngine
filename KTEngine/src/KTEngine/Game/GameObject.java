package KTEngine.Game;

import KTEngine.Math.Vector2;

public class GameObject {

	protected Transform transform;

	public GameObject(Transform t) {
		transform = t;
	}
	
	public GameObject() {
		transform = new Transform(new Vector2(0, 0));
	}
	
	protected Transform getTransform() {
		return transform;
	}
}
