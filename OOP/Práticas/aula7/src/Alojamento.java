public class Alojamento{
	private final String codigo, nome, local; //final = imutável
	private double preco, rating;
	private boolean disponivel=true;
	private String nome_hospede, cc_hospede;
	private int numero_hospede;
	private Data data_entrada;

	public Alojamento(String codigo, String nome, String local, double preco, double rating) {
		this.codigo = codigo;
		this.nome = nome;
		this.local = local;
		this.preco = preco;
		this.rating = rating;
	}

	public void checkIn(String nome, String cc, int n, Data d){
		if (disponivel){
			this.nome_hospede = nome;
			this.cc_hospede = cc;
			this.numero_hospede = n;
			this.data_entrada = d;
		}else{
			System.out.println("Erro: Alojamento de momento insdisponível");
		}
	}

	public void checkIn(String nome, String cc, int n){
		checkIn(nome, cc, n, Data.today());
	}


	public double checkOut(Data d){
		double divida = preco;
		if (!disponivel){
			divida = Data.daysBetween(data_entrada, d)*preco;
			this.nome_hospede = null;
			this.cc_hospede = null;
			this.numero_hospede=0;
			this.data_entrada = null;
			this.disponivel = true;
		}else{
			System.out.println("Erro: Alojamento livre");
		}
		return divida;
	}

	public double checkOut(){
		return checkOut(Data.today());
	}


	//GET and SET


	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getLocal() {
		return local;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getNome_hospede() {
		return nome_hospede;
	}

	public void setNome_hospede(String nome_hospede) {
		this.nome_hospede = nome_hospede;
	}

	public String getCc_hospede() {
		return cc_hospede;
	}

	public void setCc_hospede(String cc_hospede) {
		this.cc_hospede = cc_hospede;
	}

	public int getNumero_hospede() {
		return numero_hospede;
	}

	public void setNumero_hospede(int numero_hospede) {
		this.numero_hospede = numero_hospede;
	}

	public Data getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Data data_entrada) {
		this.data_entrada = data_entrada;
	}

	@Override
	public String toString() {
		return "Alojamento{" +
				"codigo='" + codigo + '\'' +
				", nome='" + nome + '\'' +
				", local='" + local + '\'' +
				", preco=" + preco +
				", rating=" + rating +
				", disponivel=" + disponivel +
				", nome_hospede='" + nome_hospede + '\'' +
				", cc_hospede='" + cc_hospede + '\'' +
				", numero_hospede=" + numero_hospede +
				", data_entrada=" + data_entrada +
				'}';
	}
}
