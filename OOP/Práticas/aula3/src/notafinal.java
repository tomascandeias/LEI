import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class notafinal {

	public static Scanner sc = new Scanner(in);

	public static void main(String[] args){
		out.println("--->Cálculo da nota final de Programação Orientada a Objetos<---");


		double atp1 = checkGrade("ATP1");
		double atp2 = checkGrade("ATP2");
		double ac = checkGrade("AC");
		double ep = checkGrade("EP");


		double notafinal = (atp1*0.2) + (atp2*0.2) + (ac*0.15) + (ep*0.45);
		if (notafinal < 7){
			out.println("Nota final: 66");
		}else{
			out.printf("Nota final: %.0f", notafinal);
		}

		sc.close();
	}

	public static double checkGrade(String s){
		double nota;

		do{
			out.printf("%s: ", s);
			nota = sc.nextDouble();
		}while (0>nota || 20<nota);

		return nota;
	}
}
