import java.util.LinkedList;

class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

  /**
   *  Creates a list of maxHzReports for all of the dates in a given month of sensor data
   * @param data the raw sensor data
   * @param month The month that you want reports of
   * @return A linked list of maxHzReports
   */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                  int month) {
    LinkedList<Double> dataForMonth = dataForMonth(data,month);
    LinkedList<Double> measurements = new LinkedList<>();
    LinkedList<MaxHzReport> result = new LinkedList<>();
    Double lastdate = 0.0;

    for (int i = 0; i < dataForMonth.size(); i++){
      if (isDate(dataForMonth.get(i)) && lastdate != 0){
        Double max = 0.0;
        for (int k = 0; k < measurements.size(); k++){
          if (measurements.get(k) > max){
            max = measurements.get(k);
          }
        }
        result.add(new MaxHzReport(lastdate, max));
        lastdate = dataForMonth.get(i);
      }
      else if(isDate(dataForMonth.get(i)) && lastdate == 0) {
          lastdate = dataForMonth.get(i);
      }
      else{
          measurements.add(dataForMonth.get(i));
      }
    }

   return result;
  }

  /**
   * returns all of the data from a given month
   * @param data The list of data
   * @param month The month that you want the data of
   * @return the list of data from the given month
   */
  private LinkedList<Double> dataForMonth(LinkedList<Double> data, int month){
    double latestdate = 0.0;
    LinkedList<Double> result = new LinkedList<>();
    for (int i = 0; i < data.size(); i++){
      if (isDate(data.get(i))){
        latestdate = data.get(i);
      }
      if(extractMonth(latestdate) == month){
        result.add(data.get(i));
      }
    }
    return result;
  }
}

