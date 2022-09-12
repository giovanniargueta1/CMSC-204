
/** when characters are in a invalid sequence (more than two characters in a row)
 * 
 *  examples include "hiii" or "looong"
 *  
 *  
 *  @author Giovanni Argueta
 *
 */
public class InvalidSequenceException extends PasswordException {

	private static final long serialVersionUID = 1L;


	public InvalidSequenceException() {
		this("The password cannot contain more than two of the same character in sequence.");
	}
	
	/** throws exception based on parameter
	 *  
	 *  
	 *  @param msg to display if exception is thrown
	 */
	public InvalidSequenceException(String msg) {
		super(msg);
	}
}