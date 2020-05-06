public class Circulo{
	private Ponto centro;
	private double r;

	public Circulo(Ponto centro, double r){
		this.centro = centro;
		this.r = r;
	}

	public Circulo(double x, double y, double r){
		this.centro = new Ponto(x,y);
		this.r = r;
	}



	public double area(){
		return Math.PI*r*r;
	}

	public double perimetro(){
		return 2*Math.PI*r;
	}

	public double getX(){return centro.getX();}

	public double getY(){return centro.getY();}

	public Ponto getCentro() {
		return centro;
	}

	public double getR() {
		return r;
	}

	public boolean intersect(Circulo c2){
		double dist = Math.pow(centro.getX()-c2.getX(), 2)+Math.pow(centro.getY()-c2.getY(), 2);
		double rSum = Math.pow(r+c2.getR(), 2);

		if (dist <= rSum){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String toString() {
		return "Circulo{" +
				"centro=" + centro.toString() +
				", r=" + r +
				'}';
	}
}
