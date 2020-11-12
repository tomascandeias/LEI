import java.util.Scanner;
import static java.lang.System.*;


public class investimento {
	public static void main(String[] args){
		Scanner sc = new Scanner(in);

		out.print("Investimento inicial? ");
		double fundos = sc.nextDouble();

		out.print("Quantos meses? ");
		int meses = sc.nextInt();

		out.print("Taxa de juros mensal(%) ? ");
		double juros = sc.nextDouble();

		for (int i=0; i<meses; i++){
			fundos += fundos*juros;
		}

		out.printf("Ao fim de %s meses tem %f €", meses, fundos);
		sc.close();
	}
}
