import java.util.*;

import static java.lang.System.*;

public class EX3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		out.print("->");
		String s = sc.nextLine().replace(" ", "");
		sc.close();

		Map<Character, Set<Integer>> dict = new HashMap<>();

		for (int i=0; i < s.length(); i++){
			char c = Character.toLowerCase(s.charAt(i));
			if (!dict.containsKey(c)) {
				dict.put(c, new HashSet<>(Arrays.asList(i)));
			} else {
				dict.get(c).add(i);
			}
		}

		out.println(dict.toString());
	}
}
