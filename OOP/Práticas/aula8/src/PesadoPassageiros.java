import java.util.Objects;

public class PesadoPassageiros extends Pesado {
	private int maxPassageiros;

	public PesadoPassageiros(String matricula, String marca, String modelo, int cc, int nquadro, int peso, int maxPassageiros) {
		super(matricula, marca, modelo, cc, nquadro, peso);
		this.maxPassageiros = maxPassageiros;
	}

	public int getMaxPassageiros() {
		return maxPassageiros;
	}

	public void setMaxPassageiros(int maxPassageiros) {
		this.maxPassageiros = maxPassageiros;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PesadoPassageiros)) return false;
		if (!super.equals(o)) return false;
		PesadoPassageiros that = (PesadoPassageiros) o;
		return getMaxPassageiros() == that.getMaxPassageiros();
	}

	@Override
	public String toString() {
		return super.toString() + " , " + maxPassageiros + " pessoas";
	}
}
