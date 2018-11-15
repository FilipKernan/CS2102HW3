import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  Earthquake2 E2 = new Earthquake2();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> OctReports = new LinkedList<MaxHzReport>();

  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
    OctReports.add(new MaxHzReport(20151013.0, 10.0));
    OctReports.add(new MaxHzReport(20151020.0, 50.0));
  }

  @Test
  public void testEarthquake1() {
      assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
  }
  @Test
  public void testEarthquake2() {
      assertEquals(NovReports, E2.dailyMaxForMonth(threeDates, 11));
  }
  @Test
  public void testAgainE1() {
      assertEquals(noData, E1.dailyMaxForMonth(threeDates, 12));
  }
  @Test
  public void testAgainE2() {
      assertEquals(noData, E2.dailyMaxForMonth(threeDates, 12));
  }
  @Test
  public void testEarthquake1Oct() {
    assertEquals(OctReports, E1.dailyMaxForMonth(threeDates, 10));
  }
  @Test
  public void testEarthquake2Oct() {
    assertEquals(OctReports, E2.dailyMaxForMonth(threeDates, 10));
  }
}

/*
Earthquake 1 takes the list of sensor data and first cleans out everything that doesn't
    pertain to the given month. Then it goes through the cleaned list, storing the most
    recent date and keeping track of the maximum HZ readout for that date. Once a new
    date is encountered, the previous date and the stored maximum are added to the final
    list called 'result,' which is what the method returns.

Earthquake 2 takes the list of sensor data and turns it into a list of lists of doubles.
    The initial data is separated by dates; each internal list is organized as an eight
    digit date followed by the sensor readings for that date. Once another date is
    encountered, a new embedded list is created. Once the list of lists is created,
    it is iterated through by a for loop, which first checks if the first item in each
    internal list, which will always be an 8-digit date, matches the given month. If it
    does, the rest of that list is evaluated, and the highest value, along with the date,
    is then turned into a MaxHzReport and added to the listOfMax, which is what the method
    returns.

 */
