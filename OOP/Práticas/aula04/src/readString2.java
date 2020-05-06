import java.util.*;
import static java.lang.System.*;
import java.lang.String;

public class readString2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(in);

		out.print("->");
		String s = sc.nextLine();

		out.print("\na)Número de caracteres numéricos: ");
		countDigits(s);

		out.print("b)Número de espaços: ");
		spaces(s);

		out.println("c)Só tem minúsculas: "+lower(s));

		out.println("d)Só um espaço entre palavras: "+oneSpace(s));

		out.println("e)Palíndromo: "+palindrome(s));

	}

	public static void countDigits(String s){
		int count = 0;

		for(int i=0; i<s.length(); i++){
			if (Character.isDigit(s.charAt(i))){
				count++;
			}
		}

		out.println(count);
	}

	public static void spaces(String s){
		int count=0;

		for (int i=0; i<s.length(); i++){
			if (s.charAt(i) == ' '){
				count++;
			}
		}

		out.println(count);
	}

	public static boolean lower(String s){
		for (int i=0; i<s.length(); i++){
			if (!Character.isLowerCase(s.charAt(i)) && s.charAt(i) != ' ' && !Character.isDigit(s.charAt(i))){
				return false;
			}
		}
		return true;
	}

	public static String oneSpace(String s){
		String str = "";
		for (int i=0; i<s.length(); i++){
			str = s.replace("  ", " ");
			s = str;
		}

		return str;
	}

	public static boolean palindrome(String s){
		String[] newText = s.toLowerCase().split("");
		String reverseText = "";
		for (int i = newText.length-1; i >= 0; i--) {
			if (!(newText[i].equals(",")))
				reverseText += newText[i];
		}

		s = oneSpace(s);
		s = s.replace(" ", "");
		s = s.replace(",", "");

		reverseText = oneSpace(reverseText);
		reverseText = reverseText.replace(" ", "");

		return (s.equals(reverseText));
	}

}
