import java.util.LinkedList;

/**
 * Holy fucking shit this is some raw code. I feel bad for whoever has to go through this. At least it works (?)
 * But seriously. the dailyMaxForMonth METHOD takes in a list of sensor readings and a certain month (1-12) and returns list of MaxHzReports for that month
 * the data PARAMETER is a list of doubles that the sensor provided. Every so often is an 8-digit date followed by some values for that day
 * the month PARAMETER is just a month, 1-12
 * the RESULT, a LinkedList of MaxHzReports, is a list of dates and readings, where each date is within the given month and is followed by a single value.
 *      This value is the greatest value obtained by the sensor on that day
 */
class Earthquake2 {
      
  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
      data.add(99999999.0);         //This makes sure the data for the last date is actually added to listOfLists (see if statement on line 17)
      LinkedList<LinkedList<Double>> listOfLists = new LinkedList<>();
      LinkedList<Double> listToday = new LinkedList<>();
      for(int k = 0; k<data.size(); k++) {
          if(isDate(data.get(k))) {
                if(listToday.size() > 0) {
                    listOfLists.add(listToday);
                    listToday = new LinkedList<>();
                }
                listToday.add(data.get(k));
          }
          else {
              listToday.add(data.get(k));
          }
      }

      LinkedList<MaxHzReport> listOfMax = new LinkedList<>();
      for(int j = 0; j<listOfLists.size();) {
          if(extractMonth(listOfLists.get(j).getFirst()) == month) {    //You may look at this and say "Oh god why?!" and I feel the same. Sorry.\
              Double maximumSoFar = 0.0;
              for(int i = 1;  i<listOfLists.get(j).size(); i++) {      //Yeah this loop isn't much nicer is it...
                  if(listOfLists.get(j).get(i) > maximumSoFar) {
                      maximumSoFar = listOfLists.get(j).get(i);
                  }
              }

              listOfMax.add(new MaxHzReport(listOfLists.get(j).getFirst(), maximumSoFar));
          }
      }
      return listOfMax;
  }
}
// Why are these files indented with only 2 spaces? Why are we subjected to this suffering?