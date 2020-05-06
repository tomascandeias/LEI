import java.util.Scanner;
import static java.lang.System.*;

public class EX62 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);

		Circulo c1 = new Circulo("Vermelho",new Ponto(1.0,2.0),12.3);
		out.println(c1);
		Circulo c2 = new Circulo("Azul", new Ponto(2.0,3.0),65.3);
		out.println(c2);
		c1.intersect(c2);
		Rectangulo q1 = new Rectangulo("Preto", new Ponto(3.2,6.2),33.0);
		out.println(q1);
		Triangulo r1 = new Triangulo ("Branco", new Ponto(6.2,4.4),2.0,3.0, 2.0);
		out.println(r1);
		sc.close();
	}
}
