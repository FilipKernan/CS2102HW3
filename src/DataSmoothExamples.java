import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class DataSmoothExamples
{  
  LinkedList<Show> shows = new LinkedList<Show>();
  LinkedList<Double> showResults = new LinkedList<Double>();
  LinkedList<Show> shows2 = new LinkedList<Show>();
  LinkedList<Double> showResults2 = new LinkedList<Double>();
  DataSmooth1 D1 = new DataSmooth1();
  DataSmooth2 D2 = new DataSmooth2();
  
  public DataSmoothExamples() 
  {
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		shows.add(new Show("Star Trek", 1800, eps1, false));
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		shows.add(new Show("Futurama", 1900, eps2, false));
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		shows.add(new Show("Animaniacs", 1630, eps3, false));
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		shows.add(new Show("Sesame Street", 900, eps4, false));

	    showResults.add(60.0);
	    showResults.add(29.75);
	    showResults.add(29.08333);
	    showResults.add(58.0);



	  LinkedList<Episode> eps5 = new LinkedList<Episode>();
	  eps5.add(new Episode("Best of Both Worlds", 50));
	  eps5.add(new Episode("The Ultimate Computer", 49));
	  eps5.add(new Episode("Trials and Tribble-ations", 10));
	  shows2.add(new Show("Star Trek", 1800, eps5, true));

	  LinkedList<Episode> eps6 = new LinkedList<Episode>();
	  eps6.add(new Episode("Fear of a Bot Planet", 23));
	  eps6.add(new Episode("The Why of Fry", 15));
	  eps6.add(new Episode("Roswell that Ends Well", 17));
	  eps6.add(new Episode("Meanwhile", 22));
	  shows2.add(new Show("Futurama", 1900, eps6, false));

	  LinkedList<Episode> eps7 = new LinkedList<Episode>();
	  eps7.add(new Episode("Yakko's World", 4));
	  eps7.add(new Episode("Hello Nice Warners", 3));
	  eps7.add(new Episode("Where Rodents Dare", 9));
	  shows2.add(new Show("Animaniacs", 1630, eps7, false));

	  LinkedList<Episode> eps8 = new LinkedList<Episode>();
	  eps8.add(new Episode("The Letter W", 10));
	  eps8.add(new Episode("The Letter P", 15));
	  eps8.add(new Episode("The Letter I", 58));
	  shows2.add(new Show("Sesame Street", 900, eps8, false));

	  showResults2.add(36.333333333333336);
	  showResults2.add(20.305555555555557);
	  showResults2.add(17.416666666666668);
	  showResults2.add(27.666666666666668);
  }
  
  @Test
  public void instructorTestDS() 
  {
	  LinkedList<Double> runtimes = D1.dataSmooth(shows);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults.get(i), .01);
	  }
  }
	@Test
	public void testDS2()
	{
		LinkedList<Double> runtimes = D2.dataSmooth(shows);

		for(int i = 0; i < runtimes.size(); i++)
		{
			assertEquals(runtimes.get(i), showResults.get(i), .01);
		}
	}
	@Test
	public void testDS1W2()
	{
		LinkedList<Double> runtimes = D1.dataSmooth(shows2);

		for(int i = 0; i < runtimes.size(); i++)
		{
			assertEquals(runtimes.get(i), showResults2.get(i), .01);
		}
	}
	@Test
	public void testDS2W2()
	{
		LinkedList<Double> runtimes = D2.dataSmooth(shows2);

		for(int i = 0; i < runtimes.size(); i++)
		{
			assertEquals(runtimes.get(i), showResults2.get(i), .01);
		}
	}

}