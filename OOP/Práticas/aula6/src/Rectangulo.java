public class Rectangulo extends FiguraGeo{
	private double c, l;

	public Rectangulo(String cor, Ponto centro, double c, double l){
		super(cor, centro);
		this.c = c;
		this.l = l;
	}

	public Rectangulo(String cor, Ponto centro, double lado){
		super(cor, centro);
		this.c = lado;
		this.l = lado;
	}

	public Rectangulo(String cor, double x, double y, double c, double l) {
		super(cor, x, y);
		this.c = c;
		this.l = l;
	}

	public Rectangulo(String cor, double x, double y, double lado) {
		super(cor, x, y);
		this.c = lado;
		this.l = lado;
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
		return super.toString() + "Rectangulo{" +
				"c=" + c +
				", l=" + l +
				'}';
	}
}
