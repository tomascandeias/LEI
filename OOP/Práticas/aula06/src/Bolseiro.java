public class Bolseiro extends Aluno {
	private double bolsa;

	public Bolseiro(String nome, int cc, Data dataNasc) {
		super(nome, cc, dataNasc);
	}

	public double getBolsa() {
		return bolsa;
	}

	public void setBolsa(double bolsa) {
		this.bolsa = bolsa;
	}

	@Override
	public String toString() {
		return super.toString() + ", Bolsa: €" + bolsa;
	}
}
