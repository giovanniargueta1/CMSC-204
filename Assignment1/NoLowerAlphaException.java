
/** when no lowercase letters are present
 *  
 *  
 *  @author Giovanni Argueta
 *  
 */ 
public class NoLowerAlphaException extends PasswordException {
	
	private static final long serialVersionUID = 1L;

	public NoLowerAlphaException() {
		this("The password must contain at least one lowercase alphabetic character");
	}
	
	/** message for exception 
	 *
	 *  @param message to be displayed when exception is thrown
	 */
	public NoLowerAlphaException(String msg) {
		super(msg);
	}
}