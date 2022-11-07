import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// cant wait to write another Junit test!!!!
public class CourseDBManagerTest_STUDENT {
  private CourseDBManagerInterface manager = new CourseDBManager();

  @Before
  public void setUp() throws Exception {
    manager = new CourseDBManager();
  }

  @After
  public void tearDown() throws Exception {
    manager = null;
  }

 
  @Test
  public void testAddToDB() {
    try {
      manager.add("CMSC204", 31111, 4, "SC201", "Giovanni Argueta");
      assertEquals(1, manager.showAll().size());
      manager.add("CMSC204", 31111, 4, "SC201", "Giovanni Argueta");
      assertEquals(1, manager.showAll().size());
    } catch (Exception e) {
      fail("This should not have caused an Exception");
    }
  }

  /**
   * 
   */
  @Test
  public void testRead() {
    try {
      File inputFile = new File("StudentTest101.txt");
      PrintWriter inFile = new PrintWriter(inputFile);
      inFile.println("CMSC204 31111 4 SC201 Giovanni Argueta");
      inFile.print("CMSC204 31112 4 SC301 Mr Cool");
      inFile.close();

      assertEquals(0, manager.showAll().size());
      manager.readFile(inputFile);
      assertEquals(2, manager.showAll().size());
    } catch (Exception e) {
      fail("Should not have thrown an exception");
    }
  }

  @Test
  public void testShowAll() {
	    manager.add("CMSC204", 30901, 4, "SC445", "Diego Soto");
	    manager.add("CMSC204", 30502, 4, "SC450", "Giovanni Argueta");
	    manager.add("CMSC207", 30559, 4, "SC453", "David K. Kraft");
	    ArrayList<String> list = manager.showAll();

	    assertEquals(list.get(0),
	        "\nCourse:CMSC204 CRN:30502 Credits:4 Instructor:Giovanni Argueta Room:SC450");
	    assertEquals(list.get(1),
	        "\nCourse:CMSC207 CRN:30559 Credits:4 Instructor:David K. Kraft Room:SC453");
	    assertEquals(list.get(2),
	        "\nCourse:CMSC204 CRN:30901 Credits:4 Instructor:Diego Soto Room:SC445");
	  }

  @Test
  public void testGet() {
    manager.add("CMSC240", 30901, 4, "SC357", "David Kraft");
    manager.add("CMSC203", 30559, 4, "SC101", "Worse Nightmare");
    ArrayList<String> list = manager.showAll();

    assertEquals(list.get(0), manager.get(30559).toString());
    assertEquals(list.get(1), manager.get(30901).toString());
  }



}