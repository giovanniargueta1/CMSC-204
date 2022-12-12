
/** 
 * Describes the road connecting two towns
 * 
 * 
 * 
 * @author Giovanni Argueta
 *
 */
public class Road implements Comparable<Road>{
	//source is the town from which the road starts (relative to destination)
	private Town source;
	private Town destination;
	private int weight;
	private String name;
	
	/**
	 *  Sets data
	 * 
	 * @param source 
	 * 
	 * @param destination 
	 * 
	 * @param degrees 
	 * 
	 * @param name 
	 * 
	 */
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = degrees;
		this.name = name;
	}
	
	/** 
	 * Sets default weight
	 * 
	 * @param source 
	 * 
	 * @param destination 
	 * 
	 * @param name 
	 * 
	 */
	public Road(Town source, Town destination, String name) {
		this(source, destination, 1, name);
	}
	
	/**
	 * Check if road has town
	 * 
	 * @param town 
	 * 
	 * @return true if it contains a town, false otherwise
	 */
	public boolean contains(Town town) {
		if (town == null)
			return false;
		
		if (source.equals(town)) {
			return true;
		} else if (destination.equals(town)) {
			return true;
		}
		
		return false;
	}

	/** 
	 * Sees if two roads are equal
	 * 
	 * 
	 * @return true if equal
	 */
	@Override
	public boolean equals(Object r) {
		Road newR = (Road) r;
		// has to have the same destination and same source 
		if (newR.destination == destination && newR.source == source) {
			return true;
		} else if(newR.destination == source && newR.source == destination) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Gets destination
	 * 
	 * 
	 * @return destination(of road)
	 */
	public Town getDestination() {
		return destination;
	}
	
	/** 
	 * Gets name of road
	 * 
	 * 
	 * @return name
	 * 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 *  Gets source of road
	 * 
	 * 
	 * @return source
	 */
	public Town getSource() {
		return source;
	}
	
	/**
	 * Gets weight of road
	 * 
	 * 
	 * 
	 * @return weight
	 * 
	 */
	public int getWeight() {
		return weight;
	}
	
	/** 
	 * Road information 
	 * 
	 * @return String describing road
	 */
	@Override
	public String toString() {
		return "A road connecting " + source + " to " + destination + " by " + weight + " miles."; 
	}

	/**
	 * Compares weight of roads
	 * 
	 * @param o (other road)
	 * 
	 * @return A 
	 * 
	 */
	@Override
	public int compareTo(Road o) {
		return weight - o.getWeight();
	}
}