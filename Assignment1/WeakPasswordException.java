
/** when password contains 6 to 9 characters which is valid but WEAK
 *
 *
 * @author Giovanni Argueta
 *
 */
public class WeakPasswordException extends RuntimeException {
  

	private static final long serialVersionUID = 1L;

public WeakPasswordException() {
    super("The password is OK but weak - it contains fewer than 10 characters");
  }



}