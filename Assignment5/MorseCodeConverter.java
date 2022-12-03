import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/** 
 * 
 * class to convert morse code into text
 * 
 * 
 * @author Giovanni Argueta
 *
 */
public class MorseCodeConverter {
	
	static MorseCodeTree morseCodeTree = new MorseCodeTree();
	
	/** 
	 * 
	 * gets and reads file, outputs english text
	 * 
	 * 
	 * @param codeFile 
	 * 
	 * @return english text 
	 * 
	 * @throws FileNotFoundException 
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		if (!codeFile.exists())
			throw new FileNotFoundException("File not found");
		
		Scanner fileReader = new Scanner(codeFile);
		StringBuilder fileRead = new StringBuilder();
		
		while(fileReader.hasNextLine()) {
			fileRead.append(fileReader.nextLine()).append(" ");
		}
		
		fileReader.close();
		
		return convertToEnglish(fileRead.toString());
	}
	
	/** 
	 * converts from morse to english
	 * 
	 * @param morse code
	 * 
	 * @return english text
	 */
	public static String convertToEnglish(String code) {
		StringBuilder english = new StringBuilder();
		String[] codeArr = code.split(" ");
		
		for (String englishCode : codeArr){
			//make sure it accounts for words and letters
			if (englishCode.equals("/")) {
				english.append(" ");
				continue;
			}
			
			english.append(morseCodeTree.fetch(englishCode));
		}
		
		return english.toString();
	}
	
	/**
	 * prints tree
	 * 
	 * 
	 * @return string with tree data
	 */
	
	public static String printTree() {
		String o = "";
		ArrayList<String> arr = morseCodeTree.toArrayList();
		for (String s: arr) {
			o += s + " ";
			System.out.println(s);
		}
		return o;
	}

}