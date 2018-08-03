package KTEngine.Game;

public class InvalidRectangleException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidRectangleException() {
		super();
	}

	   public InvalidRectangleException(String message){
	        super(message);
	    }
}
