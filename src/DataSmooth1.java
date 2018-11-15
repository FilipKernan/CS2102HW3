import java.util.LinkedList;

class DataSmooth1 {
  DataSmooth1(){}

    /**
     * Smooths the list of average lengths of the shows
     * @param shows the list of shows that you want to have the smoothed lengths of
     * @return a LinkedList of the smoothed average lengths
     */
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
      LinkedList<Double> showsAvg = calcAvg(shows);
      for (int i = 0; i<showsAvg.size(); i++){

          if (i >0 && i < showsAvg.size() -1){
              Double lastShow = showsAvg.get(i - 1);
              Double nextShow = showsAvg.get(i + 1);
              if (showsAvg.get(i)> nextShow){
                  showsAvg.set(i, (lastShow + nextShow)/2);
              }
          }
      }

	  return showsAvg;

  }

    /**
     * Calculates the average lengths of the shows
     * @param shows the list of shows that you want to calculate the averages of
     * @return a LinkedList of the average lengths
     */
    private LinkedList<Double> calcAvg(LinkedList<Show> shows){
        LinkedList<Double> result = new LinkedList<>();
        for (Show y: shows) {
            double sum = 0;
            int count = 0;
            for (Episode x: y.episodes) {
                 count++;
                 sum += x.runTime;
            }
            if (count > 0){
                y.setAvgLength(sum/count);
            }else {
                y.setAvgLength(-1.0);
            }
            result.add(y.avgLength);
        }
        return result;
    }


}

