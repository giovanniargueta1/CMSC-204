/** when a string has no special symbols 
 *  
 *  @author Giovanni Argueta
 *  
 */
public class NoSpecialSymbolException extends PasswordException {
	
	private static final long serialVersionUID = 1L;

	public NoSpecialSymbolException() {
		this("The password must contain at least one special character");
	}

	/** message for exception
	 * 
	 * @param msg message to be displayed when exception is thrown
	 */
	public NoSpecialSymbolException(String msg) {
		super(msg);
	}
}