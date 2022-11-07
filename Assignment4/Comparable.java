import java.io.*;
import java.util.*;

/**
 * Sorts lists by collection sort and Arrays.sort
 * 
 * @param a CourseDBElement
 * @return a negative int if x compareTo is <0 and positive int 
 * vice versa 
 * 
 */

public interface Comparable {

	int compareTo(CourseDBElement element);

}