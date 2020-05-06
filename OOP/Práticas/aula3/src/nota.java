import java.util.Scanner;
import static java.lang.System.*;

public class nota {
	public static void main(String[] args){
		Scanner sc = new Scanner(in);
		double teorica, pratica, notat, notap, notaf; double[][] v1;

		v1 = new double[16][2];

		for (int student = 0; student < 2 ; student++) {

			do {
				out.print("Nota da componente prática:");
				notap = sc.nextDouble();
				v1[student][0] = notap;

			}   while ((notap < 0) || (notap > 20));

			do {

				out.print("Nota da componente teórica:");
				notat = sc.nextDouble();
				v1[student][1] = notat;

			}   while ((notat < 0) || (notat > 20));

		}

		out.println("NotaT\tNotaP\tPauta");

		for (int student=0; student<16; student++){

			teorica = v1[student][1];
			pratica = v1[student][0];
			notaf = 0.4*teorica + 0.6*pratica;

			out.printf("\n%5.1f %7.1f %7.0f", teorica, pratica, notaf);
		}

	}
}
