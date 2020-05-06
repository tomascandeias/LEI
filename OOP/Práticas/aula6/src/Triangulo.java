public class Triangulo extends FiguraGeo{
	private double l1, l2, l3;

	public Triangulo(String cor, Ponto centro, double l1, double l2, double l3){
		super(cor, centro);
		if (l1+l2<=l3 || l1+l3<=l2 || l2+l3<=l1){
			System.out.println("Triângulo geometricamente impossível!");
		}else{
			this.l1 = l1;
			this.l2 = l2;
			this.l3 = l3;
		}
	}

	public Triangulo(String cor, double x, double y, double l1, double l2, double l3) {
		super(cor, x, y);
		if (l1+l2<=l3 || l1+l3<=l2 || l2+l3<=l1){
			System.out.println("Triângulo geometricamente impossível!");
		}else{
			this.l1 = l1;
			this.l2 = l2;
			this.l3 = l3;
		}
	}

	public double getL1(){
		return l1;
	}

	public double getL2(){
		return l2;
	}

	public double getL3(){
		return l3;
	}

	public double area(){
		double p = (l1+l2+l3)/2;
		return Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
	}

	public double perimetro(){
		return l1+l2+l3;
	}

	@Override
	public String toString() {
		return super.toString() + "Triangulo{" +
				"l1=" + l1 +
				", l2=" + l2 +
				", l3=" + l3 +
				'}';
	}
}
