import java.util.Scanner;
import static java.lang.System.*;

public class Ex51 {
	public static void main(String[] args){
		Ponto p = new Ponto(2,3);
		out.println("->PONTO");
		out.println("x: "+p.getX());
		out.println("y: "+p.getY());
		out.println(p.toString());

		Circulo c = new Circulo(p, 1);
		Circulo igual = new Circulo(p, 4);
		Circulo dif = new Circulo(10, 10, 1);
		out.println("\n->CIRCULO");
		out.println("centro: "+c.getCentro());
		out.println("raio: "+c.getR());
		out.println("Perimetro: "+c.perimetro());
		out.println("Area: "+c.area());
		out.println("Circulo igual: "+c.intersect(igual));
		out.println("Circulo diferente: "+c.intersect(dif));
		out.println(c.toString());

		Rectangulo r = new Rectangulo(5,10);
		out.println("\n->RECTANGULO");
		out.println("c: "+r.getC());
		out.println("l: "+r.getL());
		out.println("Perimetro: "+r.perimetro());
		out.println("Area: "+r.area());
		out.println(r.toString());

		Triangulo imp = new Triangulo(3,3,6);
		Triangulo t = new Triangulo(3,3,3);
		out.println("\n->TRIÂNGULO");
		out.println("l1: "+t.getL1());
		out.println("l2: "+t.getL2());
		out.println("l3: "+t.getL3());
		out.println("Perimetro: "+t.perimetro());
		out.println("Area: "+t.area());



	}
}
