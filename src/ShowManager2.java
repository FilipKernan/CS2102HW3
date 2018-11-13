import java.util.LinkedList;

class ShowManager2 {
	
	ShowManager2() {}

	/**
	 * Will return a show summary of all non special shows
	 * @param shows shows that you want to make a show summary of
	 * @return a ShowSummary of all non special shows
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		LinkedList<Show> dayTime = new LinkedList<>();
		LinkedList<Show> primeTime = new LinkedList<>();
		LinkedList<Show> lateNight = new LinkedList<>();
		LinkedList<Show> cleanShows = cleanShows(shows);


		for (Show x: cleanShows) {
			if(x.broadcastTime >= 600 && x.broadcastTime < 1700){
				dayTime.add(x);
			}else if (x.broadcastTime >= 1700 && x.broadcastTime < 2200){
				primeTime.add(x);
			}else  if (x.broadcastTime >= 2200 || x.broadcastTime < 100){
				lateNight.add(x);
			}

		}

		return new ShowSummary(dayTime, primeTime, lateNight);

	}

	/**
	 * Returns a LinkedList of shows that are not special in the same order
	 * @param shows LinkedList that is going to be cleaned
	 * @return A LinkedList of shows of all non special shows
	 */
	public LinkedList<Show> cleanShows(LinkedList<Show> shows){
		LinkedList<Show> result = new LinkedList<>();
		for (Show x: shows) {
			if(!x.isSpecial){
				result.add(x);
			}
		}
		return result;
	}
}
