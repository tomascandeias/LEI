import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex1 {
	public static void main(String[] args) {
		Map<String, Integer> words = new HashMap<>();

		try (Scanner scf = new Scanner(new File("src/text_ex1.txt"))){
			while (scf.hasNextLine()){
				String[] line = scf.nextLine().split(" ");
				for (String word : line){
					if (words.containsKey(word)){
						words.put(word, words.get(word) + 1);
					}else{
						words.put(word, 1);
					}
				}
			}

			scf.close();
		} catch (IOException e) {
			System.out.println("[ERRO] " + e.getMessage());;
		}

		int total = 0;
		for (Integer value : words.values()){
			total += value;
		}

		System.out.println("Número Total de Palavras: " + total);
		System.out.println("Número Diferente Palavras: " + words.size());
	}
}
