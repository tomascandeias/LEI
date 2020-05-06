import java.util.LinkedList;

public class Jogo {
	private LinkedList<Equipa> teams = new LinkedList<Equipa>();
	private final Bola bola;
	private double duracaoJogo; //milissegundos
	private float tempoDecorrido; //milissegundos
	private long start;

	public Jogo(LinkedList<Equipa> teams, Bola bola, double duracaoJogo) {
		this.teams = teams;
		this.bola = bola;
		this.duracaoJogo = duracaoJogo;
		this.start = System.currentTimeMillis();
	}

	public float getTempoDecorrido(){
		long end = System.currentTimeMillis();
		tempoDecorrido = (end-start)/(60*1000F); //minutos
		return tempoDecorrido;
	}


	public boolean progressoTempoJogo(){
		long end = System.currentTimeMillis();
		this.tempoDecorrido = (end-start);
		return !(tempoDecorrido >= duracaoJogo);
	}
}
