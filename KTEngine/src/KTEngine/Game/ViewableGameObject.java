package KTEngine.Game;

import KTEngine.Math.Vector2f;

public class ViewableGameObject extends GameObject {
	
	private Sprite sprite;
	private Rectangle worldSpaceRectangle;

	public ViewableGameObject(Sprite sprite) {
		super();
		this.sprite = sprite;
		worldSpaceRectangle = calcWorldSpaceRectangle();
	}
	
	private Rectangle calcWorldSpaceRectangle() {
		float spriteWidthOffset = (sprite.getWidth() / 2) * sprite.getWorldUnitsToPixelRatio();
		float spriteHeightOffset = (sprite.getHeight() / 2) * sprite.getWorldUnitsToPixelRatio();
		
		Vector2f tl = new Vector2f(transform.pos.x - spriteWidthOffset, transform.pos.y + spriteHeightOffset);
		Vector2f br = new Vector2f(transform.pos.x + spriteWidthOffset, transform.pos.y - spriteHeightOffset);
		return new Rectangle(tl, br);
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public Rectangle getBoundingRect() {
		return worldSpaceRectangle;
	}
	
	public int getTexelFromWorld(Vector2f coordinate) {
		Vector2f XYStep = getXYStep();
		float xStep = XYStep.x;
		float yStep = XYStep.y;
		int u = (int)Math.abs((worldSpaceRectangle.getTL().x - coordinate.x) / xStep);
		int v = (int)Math.abs((worldSpaceRectangle.getTL().y - coordinate.y) / yStep);
		return sprite.getTexel(u, v);
	}
	
	//Returns the ratio of worldUnits to texelUnits in both the x and y direction in a Vector2f format.
	private Vector2f getXYStep() {

		float xStep = worldSpaceRectangle.getWidth()/sprite.getWidth();
		float yStep = worldSpaceRectangle.getHeight()/sprite.getHeight();

		return new Vector2f(xStep, yStep);
	}
}
