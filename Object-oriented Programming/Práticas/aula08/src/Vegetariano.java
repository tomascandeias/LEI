import java.util.Objects;

public class Vegetariano extends Alimento{
	private String nome;

	public Vegetariano(String nome, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Vegetariano that = (Vegetariano) o;
		return Objects.equals(nome, that.nome);
	}

	@Override
	public String toString() {
		return nome + " , " + super.toString();
	}
}
