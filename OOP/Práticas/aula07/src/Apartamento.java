public class Apartamento extends Alojamento {
	private int n;

	public Apartamento(String codigo, String nome, String local, double preco, double rating, int n) {
		super(codigo, nome, local, preco, rating);
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return "Apartamento{" +
				"n=" + n +
				"} " + super.toString();
	}
}
