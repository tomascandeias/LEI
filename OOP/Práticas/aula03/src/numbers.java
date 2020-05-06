import java.util.Scanner;
import static java.lang.System.*;

public class numbers {
	public static void main(String[] args){
		Scanner sc = new Scanner(in);
		double n, count=1, min, max, sum, media;

		out.println("Introduza os números:");

		out.print("N? ");
		double n1 = sc.nextDouble();
		min = max = sum = n1;

		while (true){
			out.print("N? ");
			n = sc.nextDouble();

			if (n == n1){
				break;
			}

			sum += n;
			count++;

			if (n>max){
				max = n;
			}
			if (n<min){
				min = n;
			}
		}

		out.printf("\nNúmeros lidos = "+ count);
		out.printf("\nSoma = "+ sum);
		out.printf("\nMínimo = "+ min);
		out.printf("\nMáximo = "+ max);
		out.printf("\nMédia = %.2f", sum/count);

		sc.close();

	}
}
