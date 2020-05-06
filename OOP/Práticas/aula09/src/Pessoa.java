import java.util.Objects;

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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pessoa pessoa = (Pessoa) o;
		return cc == pessoa.cc &&
				Objects.equals(nome, pessoa.nome) &&
				Objects.equals(dataNasc, pessoa.dataNasc);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, cc, dataNasc);
	}

	@Override
	public String toString() {
		return nome + ", CC: " + cc + ", Data: " + dataNasc;
	}
}
