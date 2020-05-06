public class Viatura {
	private final char classe;
	private String combustivel;
	private boolean disponivel=true;
	private String nome, cc, id; //info condutor

	public Viatura(char classe, String combustivel, String id) {
		this.classe = classe;
		this.combustivel = combustivel;
		this.id = id;
	}

	public void levantar(String nome, String cc){
		if (disponivel){
			this.nome = nome;
			this.cc = cc;
			this.disponivel = false;
		}else{
			System.out.println("Erro: Carro alugado de momento");
		}
	}

	public void entregar(){
		if (disponivel) {
			System.out.println("Erro: Carro não alugado (disponivel)");
		}else{
			this.nome = null;
			this.cc = null;
			this.disponivel = true;
		}
	}

	//GET and SET

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public char getClasse() {
		return classe;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Viatura{" +
				"classe=" + classe +
				", combustivel='" + combustivel + '\'' +
				", disponivel=" + disponivel +
				", nome='" + nome + '\'' +
				", cc='" + cc + '\'' +
				", id='" + id + '\'' +
				'}';
	}
}
