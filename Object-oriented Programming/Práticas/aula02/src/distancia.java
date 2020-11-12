import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;

public class distancia {
	public static void main(String[] args){
		Scanner sc = new Scanner(in);

		out.print("p1 x?");
		double p1_x = sc.nextDouble();
		out.print("p1 y?");
		double p1_y = sc.nextDouble();

		out.print("p2 x?");
		double p2_x = sc.nextDouble();
		out.print("p2 y?");
		double p2_y = sc.nextDouble();

		out.printf("Distância entre p1/p2 : %.3f", sqrt(pow(p2_x-p1_x,2) + pow(p2_y-p1_y,2)));
		sc.close();

	}
}
