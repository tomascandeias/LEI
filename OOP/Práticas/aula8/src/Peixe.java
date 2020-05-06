import java.util.Objects;

public class Peixe extends Alimento{
	private final TipoPeixe tipo;

	public Peixe(TipoPeixe tipo, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		this.tipo = tipo;
	}

	public TipoPeixe getTipo() {
		return tipo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Peixe peixe = (Peixe) o;
		return Objects.equals(tipo, peixe.tipo);
	}

	@Override
	public String toString() {
		return super.toString() + " , " + tipo;
	}
}
