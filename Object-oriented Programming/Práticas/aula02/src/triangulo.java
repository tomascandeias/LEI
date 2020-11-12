import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;


public class triangulo{
	public static void main(String[] args){
		Scanner sc = new Scanner(in);

		out.print("Lado A = ");
		double a = sc.nextDouble();
		out.print("Lado B = ");
		double b = sc.nextDouble();

		double c = sqrt(pow(a,2) + pow(b,2)); //pow(a,2) == a^2

		double angulo = toDegrees(atan(b/a));

		out.printf("Hipotenusa: %.2f, Angulo: %.1f°", c, angulo);
		sc.close();
	}
}