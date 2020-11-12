import java.util.Scanner;
import static java.lang.System.*;

public class countdown {
	public static void main(String[] args){
		Scanner sc = new Scanner(in);

		out.print("N>=0: ");
		double n;
		do{
			n = sc.nextDouble();
		}while(n<0);

		out.println("--->COUNT DOWN<---");
		for (double i=n; i>=0; i--){
			out.printf("%.2f\n", i);
		}

		sc.close();
	}
}
