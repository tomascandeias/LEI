public class Robo extends ObjetoMovel {
	private String id;
	private String posicao;
	private int golos;


	public Robo(Ponto p, String id, String posicao) {
		super(p);
		this.id = id;
		this.posicao = posicao;
		this.golos = 0;
	}

	public Robo(String id, String posicao) {
		super(new Ponto(0,0));
		this.id = id;
		this.posicao = posicao;
	}



	public void marcar(){
		this.golos++;
	}

	public String getId() {
		return id;
	}

	public String getTp_jogador() {
		return posicao;
	}

	public int getGolos() {
		return golos;
	}

	public void setGolos(int golos) {
		this.golos = golos;
	}

	@Override
	public String toString() {
		return "Robo:" + "id='" + id + '\'' + ", posicao='" + posicao + '\'' + ", golos=" + golos + super.toString();
	}
}
