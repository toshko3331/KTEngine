package KTEngine.Game;

import java.util.ArrayList;

import KTEngine.Math.Vector2;

public class Camera extends GameObject{

	private Rectangle worldSpaceRectangle;
	private int viewPortWidth;  //In pixels.
	private int viewPortHeight; //In pixels.
	private float gameUnitsWidth;
	private float gameUnitsHeight;
	private int[] displaySurface;
	
	public Camera(int viewPortWidth, int viewPortHeight, float gameUnitsWidth, float gameUnitsHeight, int[] displaySurface) {
		super(new Transform(new Vector2(0, 0)));
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
	public void display(ArrayList<ViewableGameObject> objects) {
		Vector2 XYStep = getXYStep();
		for(int i = 0; i < objects.size(); i++) {
			Rectangle intersect = worldSpaceRectangle.getIntersectingRect(objects.get(i).getBoundingRect());
			if(intersect == null) {
				continue;
			}
			double xStep = XYStep.x;
			double yStep = XYStep.y;

			//Start pixel and end pixel of the (x,y) coordinate pair.
			int pxXStart = (int)Math.abs((worldSpaceRectangle.getTL().x - intersect.getTL().x) / xStep); 
			int pxXEnd = (int)Math.abs((worldSpaceRectangle.getTL().x - intersect.getTR().x) / xStep); 
			int pxYStart = (int)Math.abs((worldSpaceRectangle.getTL().y - intersect.getTL().y) / yStep); 
			int pxYEnd = (int)Math.abs((worldSpaceRectangle.getTL().y - intersect.getBL().y) / yStep);
			
			double currentWorldX = intersect.getTL().x;
			double currentWorldY = intersect.getTL().y;
			// Decides if the XStep and if the YStep need to be added or subtracted in order to step properly.
			if(intersect.getTL().x > intersect.getBR().x) {
				xStep = xStep * -1;
			}
			if(intersect.getTL().y > intersect.getBR().y) {
				yStep = yStep * -1;
			}
			for(int y = pxYStart; y < pxYEnd; y++ ) {
				for(int x = pxXStart; x < pxXEnd; x++ ) {
					int texel = objects.get(i).getTexelFromWorld(new Vector2(currentWorldX, currentWorldY));
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
	private Vector2 getXYStep() {
		double xStep = worldSpaceRectangle.getWidth()/viewPortWidth;
		double yStep = worldSpaceRectangle.getHeight()/viewPortHeight;

		return new Vector2(xStep, yStep);
	}
	
	public void updatePos(double newX, double newY) {
		transform.updatePos(newX, newY);
		updateRec();
	}
	
	private void updateRec() {
		Vector2 tl = new Vector2(transform.pos.x - gameUnitsWidth/2, transform.pos.y + gameUnitsHeight/2); 
		Vector2 br = new Vector2(transform.pos.x + gameUnitsWidth/2, transform.pos.y - gameUnitsHeight/2);
		worldSpaceRectangle = new Rectangle(tl, br);
	}
}
