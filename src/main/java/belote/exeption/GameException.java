package belote.exeption;

public class GameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameException(String message) {
		super(message);
	}
	
	public GameException() {
		super();
	}
	
	

}
