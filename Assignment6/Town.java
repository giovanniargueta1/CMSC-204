
/** 
 * Holds Town data
 * 
 * 
 * @author Giovanni Argueta
 *
 */
public class Town implements Comparable<Town>{
	private String name;
	
	/** 
	 * Gives town the name
	 *  
	 *
	 * @param name The name of the town
	 */
	public Town(String name) {
		this.name = name;
	}
	
	/**
	 *copies name of another town
	 *
	 *
	 * @param copyTown 
	 */
	public Town(Town copyTown) {
		name = copyTown.getName();
	}
	
	/**
	 * Checks if the name of two names are equal
	 * 
	 * 
	 * @return true if equal
	 */
	@Override
	public boolean equals(Object obj) {
		return ((Town) obj).getName().equals(name);
	}
	
	/**
	 * Gets name
	 * 
	 * @return name of the town
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Hashcode of town
	 * 
	 * @return hashcode (of name of town)
	 */
	@Override
	//not hashcode of town but NAME of town 
	public int hashCode() {
		return name.hashCode();
	}
	
	/** 
	 * Gets name
	 *  
	 *  @return name
	 */
	public String toString() {
		return getName();
	}

	/** 
	 * Compares towns
	 * 
	 * @return 0 if same 
	 */
	@Override
	public int compareTo(Town o) {
		return name.compareTo(o.getName());
	}
}