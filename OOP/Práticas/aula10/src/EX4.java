import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EX4 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new FileReader("words.txt"));
		Set<String> words = new HashSet<>();

		System.out.println("a)");
		while (input.hasNext()){
			String word = input.next();
			if (word.length() > 2)
				words.add(word);
			System.out.println(word);
		}


		System.out.print("\n\nb)");
		System.out.println(words.toString());


		System.out.print("\n\nc)");
		Set<String> wordsEndS = new HashSet<>();
		for (String word : words){
			if (word.charAt(word.length() - 1) == 's')
				wordsEndS.add(word);
		}
		System.out.println(wordsEndS.toString());


		System.out.print("\n\nd)");
		Set<String> wordsRemove = new HashSet<>();
		for (String word : words){
			for (char c : word.toCharArray()){
				if (!Character.isLetter(c)) {
					wordsRemove.add(word);
					break;
				}
			}
		}
		for (String word : wordsRemove){
			if (words.contains(word))
				words.remove(word);
		}

		System.out.println(words.toString());

	}
}
