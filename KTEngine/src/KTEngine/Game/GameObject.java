package KTEngine.Game;

import KTEngine.Math.Vector3f;

public class GameObject {

	protected Transform transform;

	public GameObject(Transform t) {
		transform = t;
	}
	
	public GameObject() {
		transform = new Transform(new Vector3f(0, 0, 0));
	}
}
