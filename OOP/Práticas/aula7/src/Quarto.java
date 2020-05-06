public class Quarto extends Alojamento {
	private String tipo;

	public Quarto(String codigo, String nome, String local, double preco, double rating, String tipo) {
		super(codigo, nome, local, preco, rating);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Quarto{" +
				"tipo='" + tipo + '\'' +
				"} " + super.toString();
	}
}
