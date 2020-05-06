public class Livro {
	private int id;
	private static int count=0;
	private String titulo;
	private String tipoEmprestimo;
	private boolean disponiblidade = true;

	public Livro(String titulo){
		id = 100 + count;
		count++;
		this.titulo = titulo;
		this.tipoEmprestimo = "NORMAL";
	}

	public Livro(String titulo, String tipoEmprestimo){
		id = 100 + count;
		count++;
		this.titulo = titulo;
		this.tipoEmprestimo = tipoEmprestimo;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTipoEmprestimo() { return tipoEmprestimo; }

	public void setTipoEmprestimo(String tipoEmprestimo) {
		this.tipoEmprestimo = tipoEmprestimo;
	}

	public boolean getDisponibilidade() {
		return disponiblidade;
	}
	public void setDisponiblidade(boolean disponiblidade) {
		this.disponiblidade = disponiblidade;
	}

	@Override
	public String toString() {
		return "Livro "+ id + "; " + titulo + "; " + tipoEmprestimo;
	}

}
