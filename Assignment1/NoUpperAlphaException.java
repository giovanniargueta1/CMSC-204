
/** when the password does not have any uppercase letters
 * 
 * @author Giovanni Argueta
 *
 */
public class NoUpperAlphaException extends PasswordException {
	
	private static final long serialVersionUID = 1L;

	public NoUpperAlphaException() {
		this("The password must contain at least one uppercase alphabetic character");
	}
	
	/** message for exception
	 *  @param msg message to be displayed when exception is thrown
	 */
	public NoUpperAlphaException(String msg) {
		super(msg);
	}
}
