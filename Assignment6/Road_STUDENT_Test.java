import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {

	Town town1;
	Town town2;
	Town town3;
	Town town4;
	
	
	Road road1;
	Road road2;
	Road road3;
	Road road4;
	
	
	@Before
	public void setUp() throws Exception {
		town1 = new Town("Olney");
		town2 = new Town("Silver Spring");
		town3 = new Town("Glemont");
		town4 = new Town("Layhill");
		;
		
		road1 = new Road(town1, town2, 24, "Georgia Ave");// the only road I really know
		road2 = new Road(town1, town3, 20, "I-270");
		road3 = new Road(town2, town3, 11, "Wheaton Road");
		road4 = new Road(town3, town4, 10, "Road #1");
		
	}

	@After
	public void tearDown() throws Exception {
		town1 = town2 = town3 = town4 =  null;
		road1 = road2 = road3 = road4 = null;
	}

	@Test
	public void containsTest() {
		assertTrue(road1.contains(town1));
		assertTrue(road1.contains(town2));
		assertFalse(road3.contains(town4));
	}
	
	@Test
	public void equalsTest() {
		Road road66 = new Road(town1,town2, 24, "Georgia Ave");
		assertTrue(road1.equals(road66));
		assertFalse(road3.equals(road1));
	}
	
	@Test
	public void getDestinationTest() {
		assertTrue(road1.getDestination().getName().equals("Silver Spring"));
		assertFalse(road3.getDestination().getName().equals("Layhill"));
	}
	
	@Test
	public void getNameTest() {
		assertTrue(road1.getName().equals("Georgia Ave"));
		assertFalse(road4.getName().equals("Long Road"));
	}
	
	@Test
	public void getSourceTest() {
		assertTrue(road1.getSource().getName().equals("Olney"));
		assertTrue(road2.getSource().getName().equals("Olney"));
	
	}
	
	@Test
	public void getWeightTest() {
		assertEquals(road1.getWeight(), 24);
		assertEquals(road2.getWeight(), 20);

	}
	
	@Test
	public void compareToTest() {
		assertTrue(road1.compareTo(road2) > 0);
		assertFalse(road4.compareTo(road1) > 0);
	}

}
