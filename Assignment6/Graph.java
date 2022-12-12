import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The data structure that contains the towns and roads
 * 
 * 
 * 
 * @author Giovanni Argueta
 *
 */
public class Graph implements GraphInterface<Town,Road>{
	//structure looks at the town that are visited versus not visited and the distance 
	//between them
	private Set<Town> towns;
	private Set<Road> roads;
	
	private Set<Town> visited;
	private Set<Town> unvisited;
	
	private Map<Town, Town> previous;
	private Map<Town, Integer> distance;
	
	/**
	 * Setting up data sets
	 *  
	 *  
	 *  */
	public Graph() {
		towns = new HashSet<>();
		roads = new HashSet<>();
		
		visited = new HashSet<>();
		unvisited = new HashSet<>();
		distance = new HashMap<>();
		previous = new HashMap<>();
	}

	/** 
	 *Gets the edge(road)
	 * 
	 * @param sourceVertex 
	 * 
	 * @param destinationVertex 
	 * 
	 * @return edge
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for (Road road : roads)
			if (road.contains(sourceVertex) && road.contains(destinationVertex))
				return road;
		
		return null;
	}

	/**
	 *  Implements edge between towns
	 * 
	 * @param sourceVertex 
	 * 
	 * @param destinationVertex 
	 * 
	 * @param weight 
	 * 
	 * @param description 
	 * 
	 * @return edge added
	 * 
	 */
	@Override
	//vertex refers to towns
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(newRoad);
		return newRoad;
	}

	/** 
	 * Adds a town 
	 * 
	 * @param v 
	 * 
	 * 
	 * @return true if added
	 * 
	 */
	@Override
	public boolean addVertex(Town v) {
		for (Town town : towns) {
			if(town.equals(v))
				return false;
		}
		towns.add(v);
		return true;
	}

	/**
	 *  Checks if road exists 
	 * 
	 * @param sourceVertex 
	 * 
	 * @param destinationVertex 
	 * 
	 * @return True if the edge exists
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for (Road road : roads) {
			if (road.contains(sourceVertex) && road.contains(destinationVertex))
				return true;
		}
		return false;
	}

	/** 
	 * Checks if town exists
	 * 
	 * @param v 
	 * 
	 * @return true if it exists
	 */
	@Override
	public boolean containsVertex(Town v) {
		for (Town town : towns)
			if (town.equals(v))
				return true;
		return false;
	}

	/**
	 *  returns copy 
	 *  
	 *  
	 * @return set of roads
	 * 
	 */
	@Override
	public Set<Road> edgeSet() {
		Set<Road> copyOfRoads = new HashSet<>();
		
		for(Road road: roads)
			copyOfRoads.add(road);
		
		return copyOfRoads;
	}

	/** 
	 * Gets the set of roads connected to towns
	 * 
	 * @param vertex
	 * 
	 * @return set of Roads
	 */
	@Override
	//creates a hashset to represent the graph
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> containsTown = new HashSet<>();
		for (Road road : roads) {
			if (road.contains(vertex))
				containsTown.add(road);
		}
		
		return containsTown;
	}

	/**
	 * Removes roads
	 * 
	 * @param sourceVertex 
	 * 
	 * @param destinationVertex 
	 * 
	 * @param weight 
	 * 
	 * @param description 
	 * 
	 * @return road removed
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road roadRemoved = null;
		for(Road road : roads) {
			if (road.contains(sourceVertex) && road.contains(destinationVertex))
				if (road.getWeight() == weight && road.getName().equals(description)) {
					roadRemoved = road;
					roads.remove(road);
					break;
				}
		}
		
		return roadRemoved;
	}
	
	/** Removes all roads connected to a town
	 * 
	 * @param v All roads connecting from or to town will be removed from the graph
	 */
	private void _removeConnectedRoads(Town v) {
		Set<Road> connectedRoads = edgesOf(v);
		
		for (Road road : connectedRoads) {
			removeEdge(road.getSource(), road.getDestination(), road.getWeight(), road.getName());
		}
	}

	/** Removes a town from the graph
	 * 
	 * @param v Removes a town from the graph
	 * 
	 * @return True if the town was removed successfully
	 */
	@Override
	//make sure we can remove one
	public boolean removeVertex(Town v) {
		towns.remove(v);
		_removeConnectedRoads(v);
		return true;
	}

	/** Gets a set of towns on the graph
	 * 
	 * @return a copy of the set containing all towns on the graph
	 */
	@Override
	public Set<Town> vertexSet() {
		Set<Town> copyOfTowns = new HashSet<>();
		
		for (Town town : towns)
			copyOfTowns.add(town);
		
		return copyOfTowns;
	}

	/** Gets the shortest path from the source to the destination
	 * 
	 * @param sourceVertex The source of desired path
	 * @param destinationVertex The destination of the desired path
	 * 
	 * @return An ArrayList<String> containing the path to the destination
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		ArrayList<String> path = new ArrayList<>();
		dijkstraShortestPath(sourceVertex);
		
		Town previousTown = destinationVertex;
		
		while(previousTown != null){
			Town currentTown = previousTown;
			previousTown = previous.get(previousTown);
			Road roadPath = getEdge(currentTown, previousTown);
			if (previousTown != null)
				path.add(previousTown.getName() + " via " + roadPath.getName() + " to " + currentTown.getName() + " " + roadPath.getWeight() + " mi");
		}
		
		Collections.reverse(path);
		return path;
	}

	/** Creates data structures containing information of the shortest path from the source vertex
	 * 
	 * @param sourceVertex The source of the shortestPath
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		for (Town town : towns) {
			distance.put(town, Integer.MAX_VALUE);
			previous.put(town, null);
			unvisited.add(town);
		}
		
		distance.put(sourceVertex, 0);
		
		
		while (!unvisited.isEmpty()) {
			Town nearestTown = _getNearestUnvisitedTown();
			unvisited.remove(nearestTown);
			Set<Town> neighbors = _unvisitedNeighborsOfTown(nearestTown);
			
			for (Town neighbor : neighbors) {
				int netWeight = distance.get(nearestTown) + getEdge(nearestTown, neighbor).getWeight();
				
				if(netWeight < distance.get(neighbor)) {
					distance.put(neighbor, netWeight);
					previous.put(neighbor, nearestTown);
				}
			}
		}
	}
	
	/**
	 *  method for dijkstraShortestPath that gets unvisited towns
	 * 
	 * @param town 
	 * 
	 * @return set of towns that are neighboring 
	 */
	private Set<Town> _unvisitedNeighborsOfTown(Town town) {
		Set<Town> unvisitedNeighbors = new HashSet<>();
		
		for (Road road : edgesOf(town)) {
			Town neighbor = road.getSource() == town ? road.getDestination() : road.getSource();
			if (unvisited.contains(neighbor) && !visited.contains(neighbor))
				unvisitedNeighbors.add(neighbor);
		}
		return unvisitedNeighbors;
	}

	/**
	 * method for dijkstraShortestPath that gets town with lowest cost
	 *  
	 *  
	 * 
	 * @return town with lowest cost
	 * 
	 */
	private Town _getNearestUnvisitedTown() {
		int lowestCost = Integer.MAX_VALUE;
		Town lowestTown = null;
		
		for (Town town : unvisited) {
			if (distance.get(town) <= lowestCost) {
				lowestCost = distance.get(town);
				lowestTown = town;
			}
		}
		
		return lowestTown;
	}
}