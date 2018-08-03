//TODO: Move it to a more sensible package.

package KTEngine.Game;

import KTEngine.Math.Vector2f;

public class Rectangle {
	
	//TODO: Throw InvalidRectangleExcpetion on width = 0 or height = 0?
	private Vector2f tl;
	private Vector2f tr;
	private Vector2f bl;
	private Vector2f br;
	private float width;
	private float height;
	
	public Rectangle(Vector2f tl, Vector2f br) {
		
		if(tl.x > br.x || br.y > tl.y ) {
			//TODO: The real coordinates can be calculated but for now throw exception.
			throw new InvalidRectangleException("TL and BR coordinates supplied in wrong order.");
		}
		
		this.tl = tl;
		tr = new Vector2f(br.x, tl.y);
		bl = new Vector2f(tl.x, br.y);
		this.br = br;
		
		width = Math.abs(tl.x - tr.x);
		height = Math.abs(tl.y - bl.y);
		//TODO: Appropriately calculate tr and bl and initialize all of the instance variables.
	}
	
	private boolean isValidRectangle() {
		//Every vertex's x and y need to be checked with that vertex's appropriate partner.
		if(tl.x != bl.x) { //tl and bl x check
			return false;
		}
		
		if(tl.y != tr.y) { //tl and tr y check.
			return false;
		} 
		
		if(tr.x != br.x) { // tr and br x check.
			return false;
		}
		
		if(bl.y != br.y) { // bl and br y check.
			return false;
		}
		return true;
	}
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public Vector2f getTL(){
		return tl;
	}
	
	public Vector2f getTR(){
		return tr;
	}
	
	public Vector2f getBL(){
		return bl;
	}
	
	public Vector2f getBR(){
		return br;
	}
	
	
	public Rectangle getIntersectingRect(Rectangle rect) {
		//TODO: Replace the function calls with simple .x and .y since that can actually be 
		//done inside the class.Make sure it remains readable.
		boolean isTlInside = isInside(rect.getTL());
		boolean isTrInside = isInside(rect.getTR());
		boolean isBlInside = isInside(rect.getBL());
		boolean isBrInside = isInside(rect.getBR());

		//Order matters.
		if(isTlInside && isTrInside && isBlInside && isTrInside) {
			return new Rectangle(rect.tl, rect.br);
		} else if(isTlInside && isTrInside) {
			Vector2f newBr = new Vector2f(rect.getBR().x, br.y);
			return new Rectangle(rect.getTL(), newBr);
		} else if(isBlInside && isBrInside) {
			Vector2f newTl = new Vector2f(rect.getBL().x, tl.y);
			return new Rectangle(newTl, rect.getBR());
		} else if(isTlInside && isBlInside) {
			Vector2f newBr = new Vector2f(tr.x, rect.getBL().y);
			return new Rectangle(rect.getTL(), newBr);
		} else if(isTrInside && isBrInside ) {
			Vector2f newTL = new Vector2f(tl.x, rect.getTL().y);
			return new Rectangle(newTL, rect.getBR());
		} else if(isTlInside) {
			Vector2f newTl = new Vector2f(rect.getBL().x, rect.getTR().y);
			return new Rectangle(newTl,br);
		} else if(isTrInside) {
			Vector2f newTl = new Vector2f(tl.x, rect.getTL().y);
			Vector2f newBr = new Vector2f(rect.getTR().x, bl.y);
			return new Rectangle(newTl,newBr);
		} else if(isBlInside) {
			Vector2f newTl = new Vector2f(rect.getBL().x, tr.y);
			Vector2f newBr = new Vector2f(tr.x, rect.getBL().y);
			return new Rectangle(newTl,newBr);
		} else if(isBrInside) {
			return new Rectangle(tl, rect.getBR());
		}
		

		//Checks if rect contains this rectangle in part rather than the other way around (which is done above)
		isTlInside = rect.isInside(tl);
		isTrInside = rect.isInside(tr);
		isBlInside = rect.isInside(bl);
		isBrInside = rect.isInside(br);
		//Order matters.
		if(isTlInside && isTrInside && isBlInside && isTrInside) {
			
			return new Rectangle(tl, br);
		} else if(isTlInside && isTrInside) {
			Vector2f newBr = new Vector2f(br.x, rect.getBR().y);
			return new Rectangle(tl, newBr);//
		} else if(isBlInside && isBrInside) {
			Vector2f newTl = new Vector2f(bl.x, rect.getTL().y);
			return new Rectangle(newTl, br);//
		} else if(isTlInside && isBlInside) {
			Vector2f newBr = new Vector2f(rect.getTR().x, bl.y);
			return new Rectangle(tl, newBr);//
		} else if(isTrInside && isBrInside ) {
			Vector2f newTL = new Vector2f(rect.getTL().x, tl.y);
			return new Rectangle(newTL, br);//
		} else if(isTlInside) {
			Vector2f newTl = new Vector2f(bl.x, tr.y);
			return new Rectangle(newTl,rect.getBR());
		} else if(isTrInside) {
			Vector2f newTl = new Vector2f(rect.getTL().x, tl.y);
			Vector2f newBr = new Vector2f(tr.x, rect.getBL().y);
			return new Rectangle(newTl,newBr);
		} else if(isBlInside) {
			Vector2f newTl = new Vector2f(bl.x, rect.getTR().y);
			Vector2f newBr = new Vector2f(rect.getTR().x, bl.y);
			return new Rectangle(newTl,newBr);
		} else if(isBrInside) {
			return new Rectangle(rect.getTL(), br);
		}
		
		//Not necessary to check if inside since that's all been checked with previous if's.
		//Checks if both rectangles cross but all of their vertices lie outside of each other.
		if(rect.getTL().x < tl.x && rect.getTR().x > tr.x && rect.getTL().y < tl.y && rect.getBL().y > bl.y) {
			Vector2f newTl = new Vector2f(tl.x, rect.getTL().y);
			Vector2f newBr = new Vector2f(br.x, rect.getBR().y);
			return new Rectangle(newTl,newBr);
		} else if(rect.getTL().x > tl.x && rect.getTR().x < tr.x && rect.getTL().y > tl.y && rect.getBL().y < bl.y) {
			Vector2f newTl = new Vector2f(rect.getTL().x, tl.y);
			Vector2f newBr = new Vector2f(rect.getBR().x, br.y);
			return new Rectangle(newTl,newBr);
		} 
		//Note: Same as above, but this rectangle and "rect" switch places.
		else if(tl.x < rect.getTL().x && tr.x > rect.getTR().x && tl.y < rect.getTL().y && bl.y > rect.getBL().y) {
			Vector2f newTl = new Vector2f(rect.getTL().x, tl.y);
			Vector2f newBr = new Vector2f(rect.getBR().x, br.y);
			return new Rectangle(newTl,newBr);
		} else if(tl.x > rect.getTL().x && tr.x < rect.getTR().x && tl.y > rect.getTL().y && bl.y < rect.getBL().y) {
			Vector2f newTl = new Vector2f(tl.x, rect.getTL().y);
			Vector2f newBr = new Vector2f(br.x, rect.getBR().y);
			return new Rectangle(newTl,newBr);
		} 
		return null;
	}
	
	public boolean isInside(Vector2f point) {
		//Note: If a point lies on a boundary line or a vertex it is considered in the rectangle.
		if(point.x <= tr.x && point.x >= bl.x && point.y <= tr.y && point.y >= bl.y ) {
			return true;
		}
		return false;
	}
	

}
