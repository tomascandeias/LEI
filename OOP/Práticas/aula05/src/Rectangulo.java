public class Rectangulo {
	private double c, l;

	public Rectangulo(double c, double l){
		this.c = c;
		this.l = l;
	}

	public double getC() {
		return c;
	}

	public double getL() {
		return l;
	}

	public double area(){
		return c*l;
	}

	public double perimetro(){
		return 2*c+2*l;
	}


	@Override
	public String toString() {
		return "Rectangulo{" +
				"c=" + c +
				", l=" + l +
				'}';
	}
}
