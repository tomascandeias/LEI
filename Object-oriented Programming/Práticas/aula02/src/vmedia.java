import java.util.*;
import static java.lang.System.*;


public class vmedia {
	public static void main(String[] args){
		Scanner sc = new Scanner(in);

		out.println("(v)elocidade expressa em m/s e (d)istância em m");

		out.print("v1 = ");
		double v1 = sc.nextDouble();
		out.print("d1 = ");
		double d1 = sc.nextDouble();


		out.print("v2 = ");
		double v2 = sc.nextDouble();
		out.print("d2 = ");
		double d2 = sc.nextDouble();

		//vmedia = total percorrido / total tempo ---> nos 2 trajetos
		out.printf("Total tempo para os dois trajetos: %.2f(s)\nVelocidade media: %.2f(m/s)", (d1/v1 + d2/v2), (d1+d2)/(d1/v1 + d2/v2));
		sc.close();


	}
}
