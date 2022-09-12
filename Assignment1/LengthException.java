
/** when a given string is less than 6 characters
 *
 *  @author Giovanni Argueta
 *
 */
public class LengthException extends PasswordException {
	
	private static final long serialVersionUID = 1L;

	
	public LengthException() { 
		this("The password must be at least 6 characters long");
	}
	
	/** allows to display msg for the exception
	 *  
	 * @param msg The msg displayed when exception is thrown
	 */
	public LengthException(String msg) {
		super(msg);
	}
}