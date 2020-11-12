import java.util.Objects;

public class Motociclo extends Veiculo {
	private String tipo;

	public Motociclo(String matricula, String marca, String modelo, int cc, String tipo) {
		super(matricula, marca, modelo, cc);
		if (tipo.toLowerCase().equals("estrada") || tipo.toLowerCase().equals("desportivo")){
			this.tipo = tipo;
		} else {
			this.tipo = "estrada";
		}
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Motociclo)) return false;
		if (!super.equals(o)) return false;
		Motociclo motociclo = (Motociclo) o;
		return Objects.equals(getTipo(), motociclo.getTipo());
	}

	@Override
	public String toString() {
		return super.toString() + " , " + tipo;
	}
}
