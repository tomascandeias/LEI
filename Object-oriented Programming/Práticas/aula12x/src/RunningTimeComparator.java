import java.util.Comparator;

public class RunningTimeComparator implements Comparator<Movie> {
	@Override
	public int compare(Movie o1, Movie o2) {
		return Integer.compare(o1.getRunningTime(), o2.getRunningTime());
	}
}
