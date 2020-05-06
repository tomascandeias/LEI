import java.util.Scanner;
import static java.lang.System.*;

public class checkdate {
	public static void main(String[] args){
		Scanner sc = new Scanner(in);
		int mes, ano;

		do {
			out.print("Mês: ");
			mes = sc.nextInt();
			out.print("Ano: ");
			ano = sc.nextInt();
		}while (mes>12 || mes<1 || ano<0);

		switch (mes){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				out.println("O mês tem 31 dias.");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				out.println("O mês tem 30 dias.");
				break;
			case 2:
				if (ano%4==0){
					out.println("O mês tem 29 dias.");
				}else{
					out.println("O mês tem 28 dias.");
				}
				break;
		}


	}
}
