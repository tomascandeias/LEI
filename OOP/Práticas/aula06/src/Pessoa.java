public class Pessoa {
	private String nome;
	private int cc;
	private  Data dataNasc;

	public Pessoa(String nome, int cc, Data dataNasc) {
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dataNasc;
	}

	public String getNome() {
		return nome;
	}

	public int getCc() {
		return cc;
	}

	public Data getDataNasc() {
		return dataNasc;
	}

	@Override
	public String toString() {
		return nome + ", CC: " + cc + ", Data: " + dataNasc;
	}
}
