import java.util.LinkedList;
import java.util.Random;

public class Equipa {
	private String nome;
	private String treinador;
	private int marcados, sofridos;
	private LinkedList<Robo> robos;

	public Equipa(String nome, String treinador) {
		this.nome = nome;
		this.treinador = treinador;
		this.robos = new LinkedList<Robo>();
	}

	public Equipa(String nome, String treinador, LinkedList<Robo> robos) {
		this.nome = nome;
		this.treinador = treinador;
		this.robos = robos;
	}

	public void addPlayer(Robo r){
		this.robos.add(r);
	}


	public void marcarGolo(Robo r){ this.marcados++; }

	public void sofrerGolo(){ this.sofridos++; }


	//GETTER AND SETTER
	public String getNome() {
		return nome;
	}

	public String getTreinador() {
		return treinador;
	}

	public int getMarcados() {
		return marcados;
	}

	public int getSofridos() {
		return sofridos;
	}

	public LinkedList<Robo> getRobos() {
		return robos;
	}
	public Robo getRoboMarcador() { return robos.get(getRandomInt(0,2)); }


	private static int getRandomInt(int min, int max) { //[min; max]

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	@Override
	public String toString() {
		return "\n"+nome +"\n Treinador: " + treinador + "\n Robôs: " + robos;
	}
}
