/**

 * 
 * Implements the interface Comparable and contains the five attributes:
 * CourseID,CRN,Credits,Room number,Instructor
 * 
 * 
 * 
 * @author Giovanni Argueta
 */
public class CourseDBElement implements Comparable {

	// the five given attributes
  private String courseID;
  private int CRN;
  private int credits;
  private String room;
  private String instructor;
  
  //constructors

  public CourseDBElement(String courseID, int crn, int credits, String room, String instructor) {
    this.courseID = courseID;
    this.CRN = crn;
    this.credits = credits;
    this.room = room;
    this.instructor = instructor;
  }

  public CourseDBElement() {
    this.courseID = "";
    this.CRN = 0;
    this.credits = 0;
    this.room = "";
    this.instructor = "";
  }
   //get set methods for each attribute 
  
  /**
   * @return courseID
   */
  public String getCourseID() {
    return courseID;
  }

  /**
   * 
   * @param courseID 
   */
  public void setCourseID(String courseID) {
    this.courseID = courseID;
  }

  /**
   * @return CRN (six digit number that represents class)
   */
  public int getCRN() {
    return CRN;
  }

  /**
   * @param CRN
   * 
   */
  public void setCRN(int crn) {
    CRN = crn;
  }

  /**
   * @return Credits received from course
   */
  public int getCredits() {
    return credits;
  }

  /**
   * @param Credits
   */
  public void setCredits(int credits) {
    this.credits = credits;
  }

  /**
   * @return Room number
   */
  public String getRoom() {
    return room;
  }

  /**
   * 
   * @param Room number
   */
  public void setRoom(String room) {
    this.room = room;
  }

  /**
   * @return Instructor name
   */
  public String getInstructor() {
    return instructor;
  }

  /**
   * @param Instructor name
   */
  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

  /**
   * 
   * @return the hashcode calculation of the CDN 
   */
  @Override
  public int hashCode() {
    String s = String.valueOf(getCRN());
    long hash = 0;
    int prime = 31;
    for (int i = 0; i < s.length(); i++) {
      hash = prime * hash + s.charAt(i);
    }
    return (int) hash;
  }

  /**
   * 
   * @return the String format of the CDN
   * 
   */
  @Override
  public String toString() {
    return "\nCourse:" + courseID + " CRN:" + CRN + " Credits:" + credits + " Instructor:"
        + instructor + " Room:" + room;
  }

  /**
   *
   * 
   * @param Element that is being compared to
   */
  @Override
  public int compareTo(CourseDBElement element) {
    return Integer.compare(this.getCRN(), element.getCRN());
  }
  
  /**
   * 
   * (Comparison for equality)
   * 
   * @param obj(object to be compared with)
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null){
        return false;
    }

    if (obj == this) {
        return true;
    } 

    if (!(obj instanceof CourseDBElement)) {
        return false;
    }
    CourseDBElement cde = (CourseDBElement) obj;
    return this.getCRN() == cde.getCRN();
}

}