import java.util.Scanner;
import static java.lang.System.*;

public class investimentos {
	public static void main(String[] args){
		Scanner sc = new Scanner(in);

		double taxa, investimento, saldo=0;

		do {
			out.print("Montante para investir: ");
			investimento = sc.nextDouble();
		}while (investimento<0 && investimento%1000 !=0);

		do {
			out.print("Taxa de juro/mês: ");
			taxa = sc.nextDouble();
		}while (taxa<0 || taxa>5);

		for (int i=0; i<12; i++){
			if (i==0){
				saldo = investimento + (investimento*taxa*0.01);
			}else{
				saldo = saldo + (saldo*taxa*0.01);
			}
			out.println((i+1)+"º Mês: €"+saldo);
		}

		sc.close();
	}
}
