import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class exExtra {
	public static void main(String[] args) {
		Map<String, Integer> vowels = new TreeMap<>();

		try (Scanner scf = new Scanner(new File("src/extra.txt"))){
			while (scf.hasNext()){
				String word = scf.next().toLowerCase();
				printReverseString(word);
				vowels.put(word, 0);
			}
			scf.close();
		}catch (IOException e){
			System.out.println(e.getMessage());
		}

		vowels.forEach((word, value) -> {
			for (char c : word.toCharArray()) {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					if (vowels.containsKey(word)) {
						vowels.put(word, vowels.get(word) + 1);
					} else {
						vowels.put(word, 1);
					}
				}
			}
		});


		System.out.printf("\n%-20s %-15s\n", "Word", "Number vowels");
		for (Map.Entry<String, Integer> entry : vowels.entrySet()){
			System.out.printf("%-20s %-15d\n", entry.getKey(), entry.getValue());
		}

	}

	public static void printReverseString(String s){
		StringBuilder reverse = new StringBuilder(s);
		reverse.reverse();
		System.out.print(reverse + " ");
	}
}
