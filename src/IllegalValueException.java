/**
 * 
 */

/**
 * Exception class
 * 
 * @author Gruppe222
 */
public class IllegalValueException extends Exception {

	/**
	 * generated ID
	 */
	private static final long serialVersionUID = -4454054904480704436L;
	
	/**
	 * Constructor gets the invalid value
	 * @param value the value causing the exception
	 */
	public IllegalValueException(int value) {
		super("Value: " + value + " The value has to be greater than or 0");
	}

}
