import java.util.LinkedList;

class ShowManager1 {
	
	ShowManager1() {}

    /**
     * This is some poorly written code that takes in a list and brute-force sorts it. If it isn't a special show, it is sorted by its broadcastTime into appropriate lists and returned a nice ShowSummary report
     * @param shows The method takes in a single LinkedList of type Show
     * @return The method returns a ShowSummary object constructed using three lists that are created and populated by the method itself.
     */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		LinkedList<Show> dayTimeShows = new LinkedList<>();
		LinkedList<Show> primeTimeShows = new LinkedList<>();
		LinkedList<Show> lateNightShows = new LinkedList<>();

	    for(Show current: shows)  {
		    if(!current.isSpecial) {
		        if(current.broadcastTime >= 600 && current.broadcastTime < 1700) {
		            dayTimeShows.add(current);
                }
                else if(current.broadcastTime >= 1700 && current.broadcastTime < 2200) {
		            primeTimeShows.add(current);
                }
                else if(current.broadcastTime >= 2200 && current.broadcastTime < 100) {
		            lateNightShows.add(current);
                }
            }

		}
		return new ShowSummary(dayTimeShows, primeTimeShows, lateNightShows);
	}
	
}
