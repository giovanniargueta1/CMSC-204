
/**	when password does not have a digit
 * 
 *  @author Giovanni Argueta
 *
 */
public class NoDigitException extends PasswordException {

	private static final long serialVersionUID = 1L;

	public NoDigitException() {
		this("The password must contain at least one digit");
	}
	
	/** displays msg
	 * 	
	 *  @param msg displayed when exception is thrown
	 */
	public NoDigitException(String msg) {
		super(msg);
	}
}