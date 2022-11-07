import java.io.IOException;
import java.util.LinkedList;

/** 
 * Uses a hash table to hold data
 * 
 * 
 * @author Giovanni Argueta
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	// dont make structure abstract

	private int tableSize;
	LinkedList<CourseDBElement>[] hashTable;
	
	/** 
	 * Sets hash table
	 * 
	 *  @param numOfCourses 
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int numOfCourses) {
		tableSize = numOfCourses;
		hashTable = new LinkedList[tableSize];
	}

	/** 
	 * constructor for testing purposes
	 * 
	 *  @param unused variable
	 *  @param numOfCourses 
	 *  
	 */
	public CourseDBStructure(String testing, int numOfCourses) {
		this(numOfCourses);
	}

	/** 
	 * adds element
	 *  
	 *  @param element (to add)
	 */
	@Override
	public void add(CourseDBElement element) {
		boolean placeIntoTable = true;
		int initialPlacement = (int) Math.ceil(element.hashCode() % hashTable.length);
		//needs linked list if first placement is not there
		if (hashTable[initialPlacement] == null)
			hashTable[initialPlacement] = new LinkedList<>();
		
		for (CourseDBElement listElement : hashTable[initialPlacement])
			if (listElement.compareTo(element) == 0)
				placeIntoTable = false;
		
		if (placeIntoTable)
			hashTable[initialPlacement].add(element);
	}

	/** 
	 * Gets the element with the CRN
	 * 
	 *  @param crn 
	 *  
	 *  @return element with hash code CRN
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		CourseDBElement toReturn = null;
		
		for (LinkedList<CourseDBElement> list : hashTable)
			if (list != null)
				for (CourseDBElement listElement : list)
					if (listElement.compareTo(new CourseDBElement("", crn, 0, "", "")) == 0)
						toReturn = listElement;
		//needs element to return if else thrown IOException
		if (toReturn == null)
			throw new IOException("Couldn't find " + crn);
		
		return toReturn;
	}

	/**
	 *  Gets size of table
	 * 
	 *  @return tableSize
	 */
	@Override
	public int getTableSize() {
		return tableSize;
	}

}