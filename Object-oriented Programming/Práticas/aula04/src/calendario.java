import java.util.Scanner;
import static java.lang.System.*;

public class calendario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);

		out.print("Mês: ");
		int month = sc.nextInt();

		out.print("Ano: ");
		int year = sc.nextInt();

		out.print("Em que dia da semana começa: ");
		int dia_semana = sc.nextInt();

		while (year < 0){
			out.print("Ano inválido");
			year = sc.nextInt();
		}

		int dias = 0;

		switch(month){
			case 1: dias = 31;
				break;
			case 2 :
				if(year % 4 ==0 && year % 100 != 0 || year % 400 == 0){
					dias = 29;
				} else{
					dias = 28;
				} break;
			case 3:
				dias = 31;
				break;
			case 4:
				dias = 30;
				break;
			case 5:
				dias = 31;
				break;
			case 6:
				dias = 30;
				break;
			case 7:
				dias = 31;
				break;
			case 8:
				dias = 31;
				break;
			case 9:
				dias = 30;
				break;
			case 10:
				dias = 31;
				break;
			case 11:
				dias = 30;
				break;
			case 12:
				dias = 31;
				break;
			default:
				out.println("M�s Inv�lido");
		}

		out.println(" Mo Tu We Th Fr Sa Su");

		int d = 0 ;
		while (d < dias) {
			for (int i = 1; i <= 7; i++) {

				if ((d != 0 || i == dia_semana) && d < dias) {
					d += 1; // soma um dia

					if (d != 0){
						out.printf(" %2d", d);
					}

				} else{
					out.print("   ");
				}
			}
			out.println("");
		}

		sc.close();
	}

}
