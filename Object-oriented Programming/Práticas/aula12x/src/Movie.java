public class Movie implements Comparable<Movie>{
	private String name;
	private double score;
	private String rating;
	private Type genre;
	private int runningTime;

	public Movie(String name, double score, String rating, Type genre, int runningTime) {
		this.name = name;
		this.score = score;
		this.rating = rating;
		this.genre = genre;
		this.runningTime = runningTime;
	}

	public String getName() {
		return name;
	}

	public double getScore() {
		return score;
	}

	public String getRating() {
		return rating;
	}

	public Type getGenre() {
		return genre;
	}

	public int getRunningTime() {
		return runningTime;
	}

	@Override
	public String toString() {
		return String.format("%-50s %-10.1f %-10s %-15s %-15d", name, score, rating, genre, runningTime);
	}

	@Override
	public int compareTo(Movie m) {
		return this.name.compareToIgnoreCase(m.getName());
	}

}
