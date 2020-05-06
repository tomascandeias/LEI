import java.util.ArrayList;

public class Prato implements Comparable<Prato>{
	private String nome;
	ArrayList<Alimento> composicao = new ArrayList<Alimento>();
	double totalCalorias = 0;

	public Prato(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTotalCalorias(){
		return totalCalorias;
	}

	public boolean addIngrediente(Alimento a){
		for (Alimento ing : composicao){
			if (ing.equals(a))
				return false;
		}
		composicao.add(a);
		this.totalCalorias += a.getCalorias();
		return true;
	}

	@Override
	public String toString() {
		return nome + " composto por " + composicao.size() + " ingredientes";
	}

	@Override
	public int compareTo(Prato p) {
		if (this.totalCalorias > p.getTotalCalorias())
			return 1;
		else if (this.totalCalorias < p.getTotalCalorias())
			return -1;

		return 0;
	}
}
