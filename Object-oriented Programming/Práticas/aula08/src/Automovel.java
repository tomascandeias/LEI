public class Automovel extends Veiculo {
	private double capacidadeBagageira;

	public Automovel(String matricula, String marca, String modelo, int cc, int nquadro, double capacidadeBagageira) {
		super(matricula, marca, modelo, cc, nquadro);
		this.capacidadeBagageira = capacidadeBagageira;
	}

	public double getCapacidadeBagageira() {
		return capacidadeBagageira;
	}

	public void setCapacidadeBagageira(double capacidadeBagageira) {
		this.capacidadeBagageira = capacidadeBagageira;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Automovel)) return false;
		if (!super.equals(o)) return false;
		Automovel automovel = (Automovel) o;
		return Double.compare(automovel.getCapacidadeBagageira(), getCapacidadeBagageira()) == 0;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t" +
				"Capacidade da Bagageira: " + capacidadeBagageira;
	}
}
