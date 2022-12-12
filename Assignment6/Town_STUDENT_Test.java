import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {

	Town town1;
	Town town2;
	Town town3;
	
	@Before
	public void setUp() throws Exception {
		town1 = new Town("Silver Spring");
		town2 = new Town("Olney");//hometown :)
		town3 = new Town("Vancouver");// had to thrown in a city from Canada
		
	}

	@After
	public void tearDown() throws Exception {
		town1 = town2 = town3 = null;
	}

	@Test
	public void getNametest() {
		assertTrue(town1.getName().equals("Silver Spring"));
		assertTrue(town2.getName().equals("Olney"));
		assertTrue(town3.getName().equals("Vancouver"));
	}

	@Test
	public void createCopyTest() {
		Town town300 = new Town(town1);
		assertTrue(town1.equals(town300));

	}
	
	@Test
	public void equalsTest() {
		Town town5 = new Town("Dawson City");
		assertFalse(town2.equals(town5));
		
		
	}
	
	@Test
	public void hashCodeTest() {
		Town town5 = new Town("Dawson City");
		assertNotEquals(town5.hashCode(), town1.hashCode());
		
		
		
	}
	
	@Test
	public void compareToTest() {
		assertTrue(town3.compareTo(town2) >= 0);

	}
}