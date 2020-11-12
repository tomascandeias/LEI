import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ex1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("src/major.txt"));
		sc.useDelimiter("[\t\n\r .,:'‘’;?!-*{}=+&/()\\[\\]”“\"\']+");
		Map<String, TreeMap<String, Integer>> words = new TreeMap<>();

		String anterior = null;
		while (sc.hasNext()) {
			String atual = sc.next().toLowerCase();

			if(atual.length() >= 3) {

				if (words.get(atual) == null)
					words.put(atual, new TreeMap<>());

				if(anterior != null) {

					if(words.get(anterior).get(atual) == null) {
						words.get(anterior).put(atual, 1);
					}else {
						int valor = Integer.parseInt(words.get(anterior).get(atual).toString());
						words.get(anterior).put(atual, valor + 1);
					}
				}
				anterior = atual;
			}
		}

		sc.close();

		for (String s : words.keySet())
			System.out.println(s + "= "+words.get(s));

	}
}
