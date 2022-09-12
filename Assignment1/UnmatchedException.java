

/** when the two entered passwords do not match
 * 
 *  @author Giovanni Argueta
 *
 */
public class UnmatchedException extends PasswordException {
	

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	public UnmatchedException() {
		this("The passwords do not match");
	}
	
	/** message for exception
	 *  
	 *  @param msg message to be displayed when exception is thrown
	 */
	public UnmatchedException(String msg) {
		super(msg);
	}
}