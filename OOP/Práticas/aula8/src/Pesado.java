public class Pesado extends Veiculo {
	private int peso;

	public Pesado(String matricula, String marca, String modelo, int cc, int nquadro, int peso) {
		super(matricula, marca, modelo, cc, nquadro);
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pesado)) return false;
		if (!super.equals(o)) return false;
		Pesado pesado = (Pesado) o;
		return getPeso() == pesado.getPeso();
	}

	@Override
	public String toString() {
		return super.toString() + " , " + peso + "kg";
	}
}
