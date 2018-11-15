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

      LinkedList<Double> showsSmooth = new LinkedList<>();
      for (int i = 0; i<shows.size(); i++){

          if (i > 0 && i < shows.size() -1){
              Double lastShow = calcAvgLenght(shows.get(i - 1));
              Double nextShow = calcAvgLenght(shows.get(i + 1));

              showsSmooth.add((lastShow + nextShow + calcAvgLenght(shows.get(i)))/3);

          }else{
              showsSmooth.add(calcAvgLenght(shows.get(i)));
          }
      }

	  return showsSmooth;

  }

    /**
     * Calculates the average length of the episodes of a show
     * @param show the show that you want the average length of the episodes
     * @return The average length of an episode
     */
    private Double calcAvgLenght(Show show){


            double sum = 0;
            int count = 0;
            for (Episode x: show.episodes) {
                 count++;
                 sum += x.runTime;
            }
            if (count > 0){
                show.setAvgLength(sum/count);
            }else {
                show.setAvgLength(-1.0);
            }


        return show.avgLength;
    }


}

