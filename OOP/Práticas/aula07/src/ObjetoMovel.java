public class ObjetoMovel {
	private Ponto p;
	private double distancia;

	public ObjetoMovel(Ponto p) {
		this.p = p;
		this.distancia = 0;
	}

	public void move(int x, int y){
		distancia += p.dist(new Ponto(x,y));
		p = new Ponto(x,y);
	}

	public void move(Ponto a){
		distancia += p.dist(a);
		p = a;
	}

	public void reset(){ this.distancia = 0;}

	@Override
	public String toString() {
		return "p=" + p + ", distancia=" + distancia;
	}
}
