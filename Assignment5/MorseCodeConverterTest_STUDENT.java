import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeConverterTest_STUDENT {
	
	private File inputFile;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		inputFile = null;
	}

	@Test
	public void convertToEnglishFileTest() throws FileNotFoundException {
		getFile("howDoILoveThee.txt");
		assertTrue(MorseCodeConverter.convertToEnglish(inputFile).equals("how do i love thee let me count the ways"));
		
		getFile("LoveLooksNot.txt");
		assertTrue(MorseCodeConverter.convertToEnglish(inputFile).equals("love looks not with the eyes but with the mind"));
		
	}
	
	@Test
	public void convertToEnglishStringTest() {
		assertTrue(MorseCodeConverter.convertToEnglish(".- -... --- --- - / --. . - / .. - / -... . -.-. .- ..- ... . / -.-. .- -. .- -.. .- ").equals("aboot get it because canada"));
		assertTrue(MorseCodeConverter.convertToEnglish(".--. .-.. . .- ... . / .-- --- .-. -.- ").equals("please work"));
	}
	
	public void getFile(String in) throws FileNotFoundException{
	//fancy way of user selecting file :D 	
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				
				inputFile = chooser.getSelectedFile();
			
			}
			catch (Exception e) {

				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}