/** superclass to other exceptions
 * 
 * @author Giovanni Argueta
 *
 */
public class PasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	/** Default message 
	 * */
	public PasswordException() {
		this("There was an issue with the password");
	}

	/** the message when exception is thrown
	 * 
	 * @param msg to be displayed when thrown
	 */
	public PasswordException(String msg) {
		super(msg);
	}
	
}