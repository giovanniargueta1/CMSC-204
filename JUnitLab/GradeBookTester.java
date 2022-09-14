import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unused")

public class GradeBookTester {
private GradeBook g1;
private GradeBook g2;
  
@Before
public void setUp() {

g1 = new GradeBook(5);
g2 = new GradeBook(5);

g1.addScore(16);
g1.addScore(29);
g2.addScore(18);
g2.addScore(100);
}
  
@After
public void tearDown() {

g1 = null;
g2 = null;
}

@Test
public void testSum(){

assertEquals(45,g1.sum(),0.001);
assertEquals(118,g2.sum(),0.001);
}
@Test
public void testMinimum(){

assertEquals(16,g1.minimum(),0.001);
assertEquals(18,g2.minimum(),0.001);
}
@Test
public void addScoreTest(){

assertTrue(g1.toString().equals("16.0 29.0 "));
assertTrue(g2.toString().equals("18.0 100.0 "));
}
@Test
public void finalScoreTest(){

assertEquals(29,g1.finalScore(),0.001);
assertEquals(100,g2.finalScore(),0.001);
}
  
}

