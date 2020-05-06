import java.util.*;
import static java.lang.System.*;
import java.lang.String;

public class readString {
	public static void main(String[] args){
		Scanner sc = new Scanner(in);

		out.print("->");
		String s = sc.nextLine();

		out.print("\na)");
		lower(s);

		out.print("\nb)");
		lastChar(s);

		out.print("\nc)");
		three(s);


		sc.close();
	}


	public static void lower(String s){
		out.println(s.toLowerCase());
	}

	public static void lastChar(String s){
		String[] words = s.split(" ");
		String[] last = new String[words.length];

		for (int i=0; i<words.length; i++){
			last[i] = words[i].substring(words[i].length()-1);
		}

		for (int i=0; i<last.length; i++){
			out.printf("\t%dº: %s\n", i, last[i]);
		}

	}

	public static void three(String s){
		String[] words = s.split(" ");
		String[] last = new String[words.length];

		for (int i=0; i<words.length; i++){
			if (words[i].length()>=3) {
				last[i] = words[i].substring(0, 3);
			}else{
				last[i] = words[i];
			}
		}

		for (int i=0; i<last.length; i++){
			out.printf("\t%dº: %s\n", i, last[i]);
		}
	}





}
