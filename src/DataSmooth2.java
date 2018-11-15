import java.util.LinkedList;

/**
 * dataSmooth: a method that consumes a list of shows and produces a list of the average runtimes where for some reason the values of those runtimes were smoothed in relation to each other
 * parameters: a list of shows
 * return value: a list of Doubles that represent the smoothed average runtimes of the given Shows
 */
class DataSmooth2 {
  public LinkedList<Double> dataSmooth(LinkedList<Show> listOfShows){
      LinkedList<Double> avgRuntimes = new LinkedList<>();
      LinkedList<Double> smoothRuntimes = new LinkedList<>();
      for(Show current: listOfShows) {
          LinkedList<Episode> listOfEpisodes = new LinkedList<>();
          listOfEpisodes = current.episodes;
          Double totalTime = 0.0;
          Double totalEpisode = 0.0;
          for (Episode currentEpi: listOfEpisodes) {
              totalTime = totalTime + currentEpi.runTime;
              totalEpisode++;
          }
          Double avgTime = totalTime/totalEpisode;
          avgRuntimes.add(avgTime);
      }
      for(int k = 0; k<avgRuntimes.size(); k++) {
          if(k != 0 && k != avgRuntimes.size() - 1) {
              smoothRuntimes.add((avgRuntimes.get(k - 1) + avgRuntimes.get(k) + avgRuntimes.get(k + 1))/3);
          }
          else if(k == 0 || k == avgRuntimes.size() - 1) {
              smoothRuntimes.add(avgRuntimes.get(k));
          }
      }
  }
}