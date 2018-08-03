package KTEngine.Game;

import KTEngine.Math.Vector2f;
import KTEngine.Math.Vector3f;

public class Camera extends GameObject{

	private Rectangle worldSpaceRectangle;
	private int viewPortWidth;  //In pixels.
	private int viewPortHeight; //In pixels.
	private float gameUnitsWidth;
	private float gameUnitsHeight;
	private int[] displaySurface;
	
	public Camera(int viewPortWidth, int viewPortHeight, float gameUnitsWidth, float gameUnitsHeight, int[] displaySurface) {
		super(new Transform(new Vector3f(0, 0, 0)));
		this.viewPortWidth = viewPortWidth;
		this.viewPortHeight = viewPortHeight;
		this.displaySurface = displaySurface;
		this.gameUnitsWidth = gameUnitsWidth;
		this.gameUnitsHeight = gameUnitsHeight;
		updateRec();
	}
	
	public Camera(int viewPortWidth, int viewPortHeight, int[] displaySurface) {
		this(viewPortWidth, viewPortHeight, 1, 1, displaySurface);
	}
	
	//Eventually, this should take in a scene object or something similar where all of the current level's game objects are stored.
	//For now array of ViewableGameObjects will do.
	public void display(ViewableGameObject[] objects) {
		Vector2f XYStep = getXYStep();
		for(int i = 0; i < objects.length; i++) {
			Rectangle intersect = worldSpaceRectangle.getIntersectingRect(objects[i].getBoundingRect());
			if(intersect == null) {
				continue;
			}
			float xStep = XYStep.x;
			float yStep = XYStep.y;

			//Start pixel and end pixel of the (x,y) coordinate pair.
			int pxXStart = (int)Math.abs((worldSpaceRectangle.getTL().x - intersect.getTL().x) / xStep); 
			int pxXEnd = (int)Math.abs((worldSpaceRectangle.getTL().x - intersect.getTR().x) / xStep); 
			int pxYStart = (int)Math.abs((worldSpaceRectangle.getTL().y - intersect.getTL().y) / yStep); 
			int pxYEnd = (int)Math.abs((worldSpaceRectangle.getTL().y - intersect.getBL().y) / yStep);
			
			float currentWorldX = intersect.getTL().x;
			float currentWorldY = intersect.getTL().y;
			// Decides if the XStep and if the YStep need to be added or subtracted in order to step properly.
			if(intersect.getTL().x > intersect.getBR().x) {
				xStep = xStep * -1;
			}
			if(intersect.getTL().y > intersect.getBR().y) {
				yStep = yStep * -1;
			}
			for(int y = pxYStart; y < pxYEnd; y++ ) {
				for(int x = pxXStart; x < pxXEnd; x++ ) {
					int texel = objects[i].getTexelFromWorld(new Vector2f(currentWorldX, currentWorldY));
					displaySurface[viewPortWidth * y + x] = texel;
					currentWorldX += xStep;
				}
				currentWorldX = intersect.getTL().x;
				currentWorldY += yStep;
			}
			currentWorldY = intersect.getTL().y; // Technically unnecessary, potentially necessary for future use of that var.
		}
	}
	
	//Returns a vector the step size required to traverse the camera view in even amounts across both the x and y axis respectively.
	private Vector2f getXYStep() {
		float xStep = worldSpaceRectangle.getWidth()/viewPortWidth;
		float yStep = worldSpaceRectangle.getHeight()/viewPortHeight;

		return new Vector2f(xStep, yStep);
	}
	
	public void updatePos(float newX, float newY, float newZ) {
		transform.updatePos(newX, newY, newZ);
		updateRec();
	}
	
	private void updateRec() {
		Vector2f tl = new Vector2f(transform.pos.x - gameUnitsWidth/2, transform.pos.y + gameUnitsHeight/2); 
		Vector2f br = new Vector2f(transform.pos.x + gameUnitsWidth/2, transform.pos.y - gameUnitsHeight/2);
		worldSpaceRectangle = new Rectangle(tl, br);
	}
}
