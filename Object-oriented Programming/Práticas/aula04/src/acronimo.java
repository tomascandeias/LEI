import java.util.Scanner;
import static java.lang.System.*;

public class acronimo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		out.print("-> ");
		String s = sc.nextLine();

		s = readString2.oneSpace(s);
		String[] words = s.split(" ");
		String acronimo = "";
		for (int i = 0; i < words.length; i++) {
			if (words[i].substring(0, 1).toUpperCase().equals(words[i].substring(0, 1)) && words[i].length() >= 3)
				acronimo += words[i].substring(0, 1);
		}

		out.println("Acronimo é igual a: "+acronimo);
		sc.close();
	}
}