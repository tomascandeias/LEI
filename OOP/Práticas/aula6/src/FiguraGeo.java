public class FiguraGeo {
	protected String cor;
	protected Ponto centro;

	public FiguraGeo(String cor, Ponto centro) {
		this.centro = centro;
		this.cor = cor;
	}

	public FiguraGeo(String cor, double x, double y){
		this.centro = new Ponto(x,y);
		this.cor = cor;
	}


	public Ponto getCentro() {
		return centro;
	}

	public void setCentro(Ponto centro) {
		this.centro = centro;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Cor: " + cor + ", Centro: " + centro;
	}
}
