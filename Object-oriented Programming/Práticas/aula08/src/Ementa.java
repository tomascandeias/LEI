import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ementa {
	private String nome, local;
	Map<String, ArrayList<Prato>> pratos = new HashMap<>();

	public Ementa(String nome, String local) {
		this.nome = nome;
		this.local = local;
		pratos.put("Segunda", new ArrayList<>());
		pratos.put("Terça", new ArrayList<>());
		pratos.put("Quarta", new ArrayList<>());
		pratos.put("Quinta", new ArrayList<>());
		pratos.put("Sexta", new ArrayList<>());
		pratos.put("Sábado", new ArrayList<>());
		pratos.put("Domingo", new ArrayList<>());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void addPrato(Prato p, String dia){
		pratos.get(dia).add(p);
	}

	@Override
	public String toString() {
		String s = "\n---EMENTA---\n";

		for (String dia : pratos.keySet()){
			for (Prato p : pratos.get(dia)){
				s += p.toString() + " , " + dia + "\n";
			}
		}

		return s;
	}
}
