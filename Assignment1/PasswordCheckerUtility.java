import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Utility class with methods to check for 
 *  password validity and/or password weakness. Also checks for list
 *  of passwords and returns invalid passwords
 *  @author Giovanni Argueta
 *  
 */
public class PasswordCheckerUtility {
	
	/** This method checks for password validity with multiple tests:
	 * Checks for length, digits, uppercase letter, lowercase letter,
	 * special symbol,invalid sequence
	 * if tests fail the corresponding exception will be thrown 
	 *
	 * 
	 *  @param passwordString check for validness 
	 *  @return 				Returns true if valid
	 *  @throws LengthException			 when the password's length is less than 6 characters
	 *  @throws NoDigitException		 if the password does not have a digit
	 *  @throws NoUpperAlphaException	 if the password does not have any uppercase letters
	 *  @throws NoLowerAlphaException	 if the password does not have any lowercase letters
	 *  @throws NoSpecialSymbolException if the password does not have any special symbols
	 *  @throws InvalidSequenceException if the password does not have more than two of the same character in sequence
	 *  
	 */
public static boolean isValidPassword(String passwordString) throws PasswordException {
		char[] passwordArray = passwordString.toCharArray();
		boolean hasNumber = false;
		boolean hasUpperAlpha = false;
		boolean hasLowerAlpha = false;
		int isTheSame = 1;
		char lastChar = 0;
		
		
if (passwordArray.length < 6)
			throw new LengthException();
		
	for (char character : passwordArray)
			switch(character) {
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0':
					hasNumber = true;
					break;
			}
	if (!hasNumber)
			throw new NoDigitException();
	for (char character : passwordArray)
			switch (character) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'G':
				case 'H':
				case 'I':
				case 'J':
				case 'K':
				case 'L':
				case 'M':
				case 'N':
				case 'O':
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
				case 'T':
				case 'U':
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
					hasUpperAlpha = true;
					break;
			}
		
	if (!hasUpperAlpha)
			throw new NoUpperAlphaException();
	for (char character : passwordArray)
			switch (character) {
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
				case 'g':
				case 'h':
				case 'i':
				case 'j':
				case 'k':
				case 'l':
				case 'm':
				case 'n':
				case 'o':
				case 'p':
				case 'q':
				case 'r':
				case 's':
				case 't':
				case 'u':
				case 'v':
				case 'w':
				case 'x':
				case 'y':
				case 'z':
					hasLowerAlpha = true;
					break;
			}
		
		
	if (!hasLowerAlpha)
			throw new NoLowerAlphaException();
		
		//regex pattern:
		// ^.*[\!\@\#\$\%\^\&\*\(\)\{\}\;\:\'\"\,\<\.\>\/\?\\\`\~\-\_\=\+\|].*$
	
		Pattern regExPattern = Pattern.compile("^.*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\{\\}\\;\\:\\'\\\"\\,\\<\\.\\>\\/\\?\\\\\\`\\~\\-\\_\\=\\+\\|].*$");
		Matcher regExMatcher = regExPattern.matcher(passwordString);
		
	if (!regExMatcher.matches()) {
			throw new NoSpecialSymbolException();
		}
		
	for (char character : passwordArray) {
			if (character == lastChar)
				isTheSame++;
			else
				isTheSame = 1;
			lastChar = character;
						if (isTheSame >= 3)
				throw new InvalidSequenceException();
		}
		

		return true;
	}
	
	/** checking for length to determine if password is weak
	 *  
	 *  @param passwordString  password to check
	 *  @return True or false on whether or not the password is weak
	 *  
	 */
public static boolean isWeakPassword(String passwordString) {
		if(passwordString.length() <= 9)
			return true;
		
		return false;
	}
	
	/** Checks the arraylist to see which are weak
	 *  @param passwords The String ArrayList 
	 *  @return the ArrayList of weak passwords
	 *  
	 */
public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){

		ArrayList<String> invalidPasswords = new ArrayList<>();
		for(String password : passwords)
		
			try {
				isValidPassword(password);
			} catch (PasswordException pe) {
				invalidPasswords.add(password + " " + pe.getMessage());
			}
		
		invalidPasswords.add("");
		return invalidPasswords;
	}
}