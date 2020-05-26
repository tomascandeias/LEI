import java.io.*;
import java.util.*;

public class ex2 {
	public static void main(String[] args) {
		Set<Movie> movies = new TreeSet<>();

		try (Scanner scf = new Scanner(new File("src/movies.txt"))){
			scf.nextLine();

			while (scf.hasNextLine()){
				String[] line = scf.nextLine().split("\t");
				movies.add(new Movie(line[0], Double.parseDouble(line[1]), line[2], Type.valueOf(line[3]), Integer.parseInt(line[4])));
			}

			scf.close();
		}catch (IOException e){
			System.out.println("[ERRO] " + e.getMessage());
			System.exit(0);
		}

		System.out.println("TABELA DE FILMES (SEM ORDENAÇÃO)");
		System.out.printf("%-50s %-10s %-10s %-15s %-15s\n", "Name", "Score", "Rating", "Genre", "Running Time");
		for (Movie m : movies){
			System.out.println(m.toString());
		}


		//c)
		List<Movie> lstMovies = new ArrayList<>();
		lstMovies.addAll(movies);
		lstMovies.sort(new ScoreComparator());

		System.out.println("\nORDENAÇÃO DECRESCENTE POR SCORE:");
		System.out.printf("%-50s %-10s %-10s %-15s %-15s\n", "Name", "Score", "Rating", "Genre", "Running Time");
		for (Movie m : lstMovies){
			System.out.println(m.toString());
		}


		lstMovies.sort(new RunningTimeComparator());

		System.out.println("\nORDENAÇÃO CRESCENTE POR RUNNING TIME:");
		System.out.printf("%-50s %-10s %-10s %-15s %-15s\n", "Name", "Score", "Rating", "Genre", "Running Time");
		for (Movie m : lstMovies){
			System.out.println(m.toString());
		}

		//d)
		Set<Type> generos = new HashSet<>();
		lstMovies.forEach(movie -> generos.add(movie.getGenre()));
		System.out.println("\nGÉNEROS EXISTENTES:");
		for (Type g : generos){
			System.out.println(g);
		}

		//e)
		Set<Movie> selection = new TreeSet<>();
		lstMovies.forEach(movie -> {
			if (movie.getScore() > 60 && movie.getGenre().equals(Type.comedy))
				selection.add(movie);
		});

		System.out.println("\nSCORE >60 E GÉNERO COMEDY:");
		System.out.printf("%-50s %-10s %-10s %-15s %-15s\n", "Name", "Score", "Rating", "Genre", "Running Time");

		try (PrintWriter pw = new PrintWriter(new FileWriter("src/myselection.txt"))){
			for (Movie m : selection){
				System.out.println(m.toString());
				pw.append(m.toString() + "\n");
			}

		}catch (IOException e){
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
