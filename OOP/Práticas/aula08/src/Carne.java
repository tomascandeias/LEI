import java.util.Objects;

public class Carne extends Alimento{
	private final VariedadeCarne variedade;

	public Carne(VariedadeCarne variedade, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		this.variedade = variedade;
	}

	public VariedadeCarne getVariedade() {
		return variedade;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Carne carne = (Carne) o;
		return Objects.equals(variedade, carne.variedade);
	}

	@Override
	public String toString() {
		return super.toString() + ", " + variedade;
	}
}
