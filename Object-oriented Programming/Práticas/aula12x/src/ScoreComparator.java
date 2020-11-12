import java.util.Comparator;

public class ScoreComparator implements Comparator<Movie> {
	@Override
	public int compare(Movie o1, Movie o2) {
		if (o1.getScore() < o2.getScore()){
			return 1;
		}else if (o1.getScore() > o2.getScore()){
			return -1;
		}else{
			return 0;
		}
	}
}
