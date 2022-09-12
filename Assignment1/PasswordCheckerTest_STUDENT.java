import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests 
 * @author Giovanni Argueta
 *
 */
public class PasswordCheckerTest_STUDENT {

	String[] tooShortPasswords = {"34f*", "23eV%", "ff", "12fd!", "whY1"};
	String[] nonUpperCasePasswords = {"thisisgoingtotakeawhile@1", "toobow11ing@2", "dontsiaf32@", "apsznp@", "buttonmashing2131@"};
	String[] nonLowerCasePasswords = {"HEYHELLO21E", "THISCASEISDRAINING123", "TESTEST13%", "QUEEN342D", "IMAGINECE21"};
	String[] nonSpecialSymbolPasswords = {"easSAINc1", "dontkSNnef32", "NSAhekoplsw1", "hey1s1sa", "needagenerator1"};
	
	String[] validButWeakPasswords = {"thyA6!", "A!vbx2", "Y9xz!0w", "M@gru321", "xFb!p3"};
	String[] validAndNotWeakPasswords = {"THISworks235&", "xxTenac$21", "caS$$mon1yA", "isengWor1wsz132@", "ElSac1w12cz*"};
	
	String[] invalidSequencePasswords = {"heyyyyyy@1A", "222224@3bX", "yesss134!A", "tooooomanypasswords32A!", "imagineP2@$111"};
	String[] noDigitPasswords = {"Evryething%", "hopeigedsqgoodgracxze@", "passinggrade!", "tireSome#", "hockeyisFun@"};
	
	String[] validPasswords = {"Rockville21!", "He$ll0", "RMsc8*1", "Magruder32@", "under_Cas1", "thatsP12@"};
	
	
	
	ArrayList<String> randomPasswords = new ArrayList<>(Arrays.asList("Rockville21", "Magruder32", "RMsc81", "underCas1", "thatsP12",
	"hellllo", "overweighttt"));
	
	
	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			for(String password : tooShortPasswords)
				PasswordCheckerUtility.isValidPassword(password);
		} catch(LengthException le) {
			assertTrue("LengthException was thrown", true);
		} catch(Exception e) {
			assertTrue("An Exception that isn't a LengthException was thrown: " + e, false);
		}
	}

	/**
	 * Test if the password contains at least one symbol
	 * This test should throw a NoSpecialSymbolException for each password
	 * This was almost forgotten..
	 */
	@Test
	public void testIsValidPasswordNoSymbol()
	{
		try {
			for (String password : nonSpecialSymbolPasswords)
				PasswordCheckerUtility.isValidPassword(password);
		} catch (NoSpecialSymbolException nspe) {
			assertTrue("NoSpecialSymbolException was thrown!", true);
		} catch (Exception e) {
			assertTrue("Some other exception was thrown: " + e, false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			for(String password : nonUpperCasePasswords)
				PasswordCheckerUtility.isValidPassword(password);
		} catch (NoUpperAlphaException nuae) {
			assertTrue("NoUpperAlphaException was thrown", true);
		} catch (Exception e) {
			assertTrue("An Exception that isn't a NoUpperAlphaException was thrown: " + e, false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			for(String password : nonLowerCasePasswords)
				PasswordCheckerUtility.isValidPassword(password);
		} catch (NoLowerAlphaException nlae) {
			assertTrue("NoUpperAlphaException was thrown", true);
		} catch (Exception e) {
			assertTrue("An Exception that isn't a NoLowerAlphaException was thrown: " + e, false);
		}
	}
	/**
	 * Test if the password is weak, 
	 * Should test a bunch of weak and nonweak passwords
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			for (String password : validButWeakPasswords) {
				assertTrue(PasswordCheckerUtility.isValidPassword(password));
				assertTrue(PasswordCheckerUtility.isWeakPassword(password));
			}
			
			for (String password : validAndNotWeakPasswords) {
				assertTrue(PasswordCheckerUtility.isValidPassword(password));
				assertFalse(PasswordCheckerUtility.isWeakPassword(password));
			}
		} catch (PasswordException pe) {
			assertTrue("Some subclass of PasswordException was thrown: " + pe, false);
		} catch (Exception e) {
			assertTrue("Some Other exception was thrown: " + e, false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			for(String password : invalidSequencePasswords)
				PasswordCheckerUtility.isValidPassword(password);
		} catch (InvalidSequenceException ise) {
			assertTrue("InvalidSequenceException was thrown", true);
		} catch (Exception e) {
			assertTrue("An Exception that isn't a InvalidSequenceException was thrown: " + e, false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			for(String password : noDigitPasswords)
				PasswordCheckerUtility.isValidPassword(password);
		} catch (NoDigitException nde) {
			assertTrue("NoDigitException was thrown", true);
		} catch (Exception e) {
			assertTrue("An Exception that isn't a NoDigitException was thrown: " + e, false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		boolean testsPassed = true;
		
		try {
			for (String password : validPasswords)
				PasswordCheckerUtility.isValidPassword(password);
		} catch (PasswordException pe) {
			assertTrue("Something of Subclass PasswordException was thrown: " + pe, false);
			testsPassed = false;
		} catch (Exception e) {
			assertTrue("Something that isn't a Subclass of PasswordException was thrown: " + e, false);
			testsPassed = false;
		}
		
		assertTrue(testsPassed);
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
	
		
		boolean passedPassword1, passedPassword2, passedPassword3, passedPassword4, passedPassword5, passedPassword6, passedPassword7;
		passedPassword1 =  passedPassword2 = passedPassword3 = passedPassword4 =  passedPassword5 = passedPassword6 = passedPassword7 = false;
		
		ArrayList<String> testInvalidPasswords = PasswordCheckerUtility.getInvalidPasswords(randomPasswords);
		
		for(String invalidPasswordAndError : testInvalidPasswords) {
			if (invalidPasswordAndError.contains("Rockville21"))
				passedPassword1 = true;
			
			if (invalidPasswordAndError.contains("Magruder32"))
				passedPassword2 = true;
			
			if (invalidPasswordAndError.contains("RMsc81"))
				passedPassword3 = true;
			
			if (invalidPasswordAndError.contains("underCas1"))
				passedPassword4 = true;
			
			if (invalidPasswordAndError.contains("thatsP12"))
				passedPassword5 = true;
			
			if (!invalidPasswordAndError.contains("hellllo"))
				passedPassword6 = true;
			
			if (!invalidPasswordAndError.contains("overweighttt"))
				passedPassword7 = true;
			
		}
		
		assertTrue((passedPassword1 && passedPassword2 && passedPassword3 && passedPassword4 && passedPassword5 && passedPassword6 && passedPassword7));
	}
	
}
