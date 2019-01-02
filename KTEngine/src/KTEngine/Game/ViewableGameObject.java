package KTEngine.Game;

import KTEngine.Math.Vector2;

public class ViewableGameObject extends GameObject {
	
	private Sprite sprite;
	private Rectangle worldSpaceRectangle;

	public ViewableGameObject(Sprite sprite) {
		super();
		this.sprite = sprite;
		worldSpaceRectangle = calcWorldSpaceRectangle();
	}
	
	private Rectangle calcWorldSpaceRectangle() {
		double spriteWidthOffset = (sprite.getWidth() / 2) * sprite.getWorldUnitsToPixelRatio();
		double spriteHeightOffset = (sprite.getHeight() / 2) * sprite.getWorldUnitsToPixelRatio();
		
		Vector2 tl = new Vector2(transform.pos.x - spriteWidthOffset, transform.pos.y + spriteHeightOffset);
		Vector2 br = new Vector2(transform.pos.x + spriteWidthOffset, transform.pos.y - spriteHeightOffset);
		return new Rectangle(tl, br);
	}
	
	public void updateRec() { //Call this after updating the transform of the object.
		worldSpaceRectangle = calcWorldSpaceRectangle();

	}
	
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public Rectangle getBoundingRect() {
		return worldSpaceRectangle;
	}
	
	public int getTexelFromWorld(Vector2 coordinate) {
		Vector2 XYStep = getXYStep();
		double xStep = XYStep.x;
		double yStep = XYStep.y;
		int u = (int)Math.abs((worldSpaceRectangle.getTL().x - coordinate.x) / xStep);
		int v = (int)Math.abs((worldSpaceRectangle.getTL().y - coordinate.y) / yStep);
		return sprite.getTexel(u, v);
	}
	
	//Returns the ratio of worldUnits to texelUnits in both the x and y direction in a Vector2f format.
	private Vector2 getXYStep() {

		double xStep = worldSpaceRectangle.getWidth()/sprite.getWidth();
		double yStep = worldSpaceRectangle.getHeight()/sprite.getHeight();

		return new Vector2(xStep, yStep);
	}
}
