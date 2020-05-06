import java.util.Scanner;
import static java.lang.System.*;
import java.util.Random;

public class altobaixo {
	public static void main(String[] args){
		Random rand = new Random();
		Scanner sc = new Scanner(in);
		int count=0, guess=0, answer; String continuar;

		do {
			answer = rand.nextInt(100)+1;

			while (answer != guess){
				out.println("MAKE A GUESS");
				guess = sc.nextInt();

				if (guess>answer){
					out.println("High");
				}else{
					out.println("Low");
				}
				count++;
			}

			out.printf("Tentou %d vezes até acertar\n", count);
			out.printf("Deseja prosseguir? (S)im ");

			continuar = sc.next();

		} while ( continuar.equals("Sim") || continuar.equals("sim") || continuar.equals("S") || continuar.equals("s"));

		out.print("Bye!");
		sc.close();
	}
}
