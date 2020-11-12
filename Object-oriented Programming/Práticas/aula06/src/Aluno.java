public class Aluno extends Pessoa {
	private final int nmec;
	private static int count = 100;
	private Data dataInscricao;

	public Aluno(String nome, int cc, Data dataNasc) {
		super(nome, cc, dataNasc);
		this.nmec = count;
		count++;
		this.dataInscricao = new Data();
	}

	public Aluno(String nome, int cc, Data dataNasc, Data dataInscricao) {
		super(nome, cc, dataNasc);
		this.nmec = count;
		count++;
		this.dataInscricao = dataInscricao;
	}

	public int getNmec() {
		return nmec;
	}

	public static int getCount() {
		return count;
	}

	public Data getDataInscricao() {
		return dataInscricao;
	}


	@Override
	public String toString() {
		return super.toString() + ", N.Mec: " + nmec + ", Data Inscrição: " + dataInscricao;
	}
}
