import java.util.Objects;

public class Taxi extends Automovel {
	private int licenca;

	public Taxi(String matricula, String marca, String modelo, int cc, int nquadro, double capacidadeBagageira, int licenca) {
		super(matricula, marca, modelo, cc, nquadro, capacidadeBagageira);
		this.licenca = licenca;
	}

	public int getLicenca() {
		return licenca;
	}

	public void setLicenca(int licenca) {
		this.licenca = licenca;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Taxi)) return false;
		if (!super.equals(o)) return false;
		Taxi taxi = (Taxi) o;
		return Objects.equals(getLicenca(), taxi.getLicenca());
	}

	@Override
	public String toString() {
		return super.toString() + ", Nº Licença: " + licenca;
	}
}
