//TODO: Move it to a more sensible package.

package KTEngine.Game;

import KTEngine.Math.Vector2;

public class Rectangle {
	
	//TODO: Throw InvalidRectangleExcpetion on width = 0 or height = 0?
	private Vector2 tl;
	private Vector2 tr;
	private Vector2 bl;
	private Vector2 br;
	private double width;
	private double height;
	
	public Rectangle(Vector2 tl, Vector2 br) {
		
		if(tl.x > br.x || br.y > tl.y ) {
			//TODO: The real coordinates can be calculated but for now throw exception.
			throw new InvalidRectangleException("TL and BR coordinates supplied in wrong order.");
		}
		
		this.tl = tl;
		tr = new Vector2(br.x, tl.y);
		bl = new Vector2(tl.x, br.y);
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
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public Vector2 getTL(){
		return tl;
	}
	
	public Vector2 getTR(){
		return tr;
	}
	
	public Vector2 getBL(){
		return bl;
	}
	
	public Vector2 getBR(){
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
			Vector2 newBr = new Vector2(rect.getBR().x, br.y);
			return new Rectangle(rect.getTL(), newBr);
		} else if(isBlInside && isBrInside) {
			Vector2 newTl = new Vector2(rect.getBL().x, tl.y);
			return new Rectangle(newTl, rect.getBR());
		} else if(isTlInside && isBlInside) {
			Vector2 newBr = new Vector2(tr.x, rect.getBL().y);
			return new Rectangle(rect.getTL(), newBr);
		} else if(isTrInside && isBrInside ) {
			Vector2 newTL = new Vector2(tl.x, rect.getTL().y);
			return new Rectangle(newTL, rect.getBR());
		} else if(isTlInside) {
			Vector2 newTl = new Vector2(rect.getBL().x, rect.getTR().y);
			return new Rectangle(newTl,br);
		} else if(isTrInside) {
			Vector2 newTl = new Vector2(tl.x, rect.getTL().y);
			Vector2 newBr = new Vector2(rect.getTR().x, bl.y);
			return new Rectangle(newTl,newBr);
		} else if(isBlInside) {
			Vector2 newTl = new Vector2(rect.getBL().x, tr.y);
			Vector2 newBr = new Vector2(tr.x, rect.getBL().y);
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
			Vector2 newBr = new Vector2(br.x, rect.getBR().y);
			return new Rectangle(tl, newBr);//
		} else if(isBlInside && isBrInside) {
			Vector2 newTl = new Vector2(bl.x, rect.getTL().y);
			return new Rectangle(newTl, br);//
		} else if(isTlInside && isBlInside) {
			Vector2 newBr = new Vector2(rect.getTR().x, bl.y);
			return new Rectangle(tl, newBr);//
		} else if(isTrInside && isBrInside ) {
			Vector2 newTL = new Vector2(rect.getTL().x, tl.y);
			return new Rectangle(newTL, br);//
		} else if(isTlInside) {
			Vector2 newTl = new Vector2(bl.x, tr.y);
			return new Rectangle(newTl,rect.getBR());
		} else if(isTrInside) {
			Vector2 newTl = new Vector2(rect.getTL().x, tl.y);
			Vector2 newBr = new Vector2(tr.x, rect.getBL().y);
			return new Rectangle(newTl,newBr);
		} else if(isBlInside) {
			Vector2 newTl = new Vector2(bl.x, rect.getTR().y);
			Vector2 newBr = new Vector2(rect.getTR().x, bl.y);
			return new Rectangle(newTl,newBr);
		} else if(isBrInside) {
			return new Rectangle(rect.getTL(), br);
		}
		
		//Not necessary to check if inside since that's all been checked with previous if's.
		//Checks if both rectangles cross but all of their vertices lie outside of each other.
		if(rect.getTL().x < tl.x && rect.getTR().x > tr.x && rect.getTL().y < tl.y && rect.getBL().y > bl.y) {
			Vector2 newTl = new Vector2(tl.x, rect.getTL().y);
			Vector2 newBr = new Vector2(br.x, rect.getBR().y);
			return new Rectangle(newTl,newBr);
		} else if(rect.getTL().x > tl.x && rect.getTR().x < tr.x && rect.getTL().y > tl.y && rect.getBL().y < bl.y) {
			Vector2 newTl = new Vector2(rect.getTL().x, tl.y);
			Vector2 newBr = new Vector2(rect.getBR().x, br.y);
			return new Rectangle(newTl,newBr);
		} 
		//Note: Same as above, but this rectangle and "rect" switch places.
		else if(tl.x < rect.getTL().x && tr.x > rect.getTR().x && tl.y < rect.getTL().y && bl.y > rect.getBL().y) {
			Vector2 newTl = new Vector2(rect.getTL().x, tl.y);
			Vector2 newBr = new Vector2(rect.getBR().x, br.y);
			return new Rectangle(newTl,newBr);
		} else if(tl.x > rect.getTL().x && tr.x < rect.getTR().x && tl.y > rect.getTL().y && bl.y < rect.getBL().y) {
			Vector2 newTl = new Vector2(tl.x, rect.getTL().y);
			Vector2 newBr = new Vector2(br.x, rect.getBR().y);
			return new Rectangle(newTl,newBr);
		} 
		return null;
	}
	
	public boolean isInteresctingRect(Rectangle rect) {
		boolean isTlInside = isInside(rect.getTL());
		boolean isTrInside = isInside(rect.getTR());
		boolean isBlInside = isInside(rect.getBL());
		boolean isBrInside = isInside(rect.getBR());
		
		return isTlInside || isTrInside || isBlInside || isBrInside;
	}
	public boolean isInside(Vector2 point) {
		//Note: If a point lies on a boundary line or a vertex it is considered in the rectangle.
		if(point.x <= tr.x && point.x >= bl.x && point.y <= tr.y && point.y >= bl.y ) {
			return true;
		}
		return false;
	}
	

}
