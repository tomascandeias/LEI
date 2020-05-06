import java.util.Objects;

public class Alimento {
	private double proteinas, calorias, peso;

	public Alimento(double proteinas, double calorias, double peso) {
		this.proteinas = proteinas;
		this.calorias = calorias;
		this.peso = peso;
	}

	public double getProteinas() {
		return proteinas*peso/100;
	}

	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	public double getCalorias() {
		return calorias*peso/100;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Alimento alimento = (Alimento) o;
		return Double.compare(alimento.proteinas, proteinas) == 0 &&
				Double.compare(alimento.calorias, calorias) == 0 &&
				Double.compare(alimento.peso, peso) == 0;
	}

	@Override
	public String toString() {
		return String.format("Proteínas: %.2f, Calorias: %.2f, Peso: %.2f", proteinas, calorias, peso);
	}
}
