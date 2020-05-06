public class Bola extends ObjetoMovel {
	private String cor;

	public Bola(Ponto p, String cor) {
		super(p);
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "cor='" + cor + '\'' + super.toString();
	}
}
