import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  Earthquake2 E2 = new Earthquake2();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  
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
}
