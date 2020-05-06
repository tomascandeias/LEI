public class Utilizador {
	private String nome;
	private int nmec;
	private String curso;
	private int[] books = new int[3];

	public Utilizador(String nome, int nmec, String curso){
		this.nome = nome;
		this.nmec = nmec;
		this.curso = curso;
	}

	public String getNome() { return nome; }

	public int getNmec() { return nmec; }

	public String getCurso() { return curso; }

	public void setnMec(int nmec){ this.nmec = nmec; }

	public int[] getBooks() { return books; }

	public void setBooks(int[] books) { this.books = books; }

	public void setBook1(int book) { this.books[0] = book; }

	public void setBook2(int book) { this.books[1] = book; }

	public void setBook3(int book) { this.books[2] = book; }


	@Override
	public String toString() {
		return "Aluno " + nmec + "; " + nome + "; " + curso;
	}
}
