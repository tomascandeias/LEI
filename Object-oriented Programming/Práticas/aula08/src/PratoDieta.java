public class PratoDieta extends Prato{
	private double limite;
	private double calorias = 0;

	public PratoDieta(String nome, double limite) {
		super(nome);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public boolean addIngrediente(Alimento a){
		if (a.getCalorias()+calorias > limite)
			return false;
		return super.addIngrediente(a);
	}

	@Override
	public String toString() {
		return "Dieta com máximo de " + limite + " calorias; " + super.toString();
	}
}
