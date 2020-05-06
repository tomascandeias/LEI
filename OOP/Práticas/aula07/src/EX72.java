import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.StrictMath.random;

public class EX72 {

	private static final Scanner sc = new Scanner(System.in);
	private static int op; //variavel para sc
	private static Robo r; //variavel para armazenar robo temporário

	public static void main(String[] args){
		System.out.println("->Robô Futebol<-");
		LinkedList<Equipa> teams = new LinkedList<Equipa>();
		for (int i=0; i<2; i++){
			teams.add(setTeam());
		}


		double prob; //maior prob de marcar implica maior prob de sofrer e vice-versa
		System.out.println("Pré Game Check:");
		System.out.println("Equipa: "+teams.get(0).toString());
		System.out.print("Mentalidade de jogo:\n" +
				"1- Ultra Defensivo\n" +
				"2- Defensivo\n" +
				"3- Equilibrado\n" +
				"4- Pressão/Posse de bola\n" +
				"5- Pressão Alta\n" +
				"Opção: ");
		op = sc.nextInt();
		switch (op){
			case 1:
				prob = 0.15;
				break;
			case 2:
				prob = 0.3;
				break;
			case 4:
				prob = 0.65;
				break;
			case 5:
				prob = 0.85;
				break;
			default:
				prob = 0.5; //por default fica em equilibrado (3)
		}

		System.out.println("Vai começar o jogo, prepare-se");
		Jogo game = new Jogo(teams, new Bola(new Ponto(5,5), "laranja"), 10000);

		while(game.progressoTempoJogo()){
			System.out.print("1- Chutar para golo\n" +
					"2- Defender possível ataque\n" +
					"Opção: ");
			op = sc.nextInt();

			switch (op){
				case 1:
					if (random() < prob){ //random() = [0;1]
						r = teams.get(0).getRoboMarcador();
						teams.get(0).marcarGolo(r);
					}else{
						if (random() < prob){
							r = teams.get(1).getRoboMarcador();
							teams.get(1).marcarGolo(r);
						}
					}
					break;
				case 2:
					if (random() < prob){ //random() = [0;1]
						r = teams.get(1).getRoboMarcador();
						teams.get(1).marcarGolo(r);
					}else{
						if (random() < prob){
							r = teams.get(0).getRoboMarcador();
							teams.get(0).marcarGolo(r);
						}
					}
					break;
			}

			System.out.println("[TEMPO DE JOGO] "+ game.getTempoDecorrido());

		}

		System.out.println("\n!RESULTADO FINAL!");
		System.out.printf("%s %d:%d %s", teams.get(0).getNome(), teams.get(0).getMarcados(), teams.get(1).getSofridos(), teams.get(1).getNome());
	}






	private static Equipa setTeam(){
		System.out.println("[Aviso]: Irá jogar com a 1º equipa definida!");

		System.out.print("Nome da Equipa: ");
		String nome = sc.next();
		sc.nextLine();
		System.out.print("Nome do treinador: ");
		String treinador = sc.nextLine();

		LinkedList<Robo> robos = new LinkedList<>();
		System.out.println("Adicione os robôs da sua equipa (3 robôs)");
		String id, posicao;
		do{
			int x = getRandomInt(0, 10);
			int y = getRandomInt(0, 10);

			System.out.print("Id: ");
			id = sc.next();

			System.out.print("Posição (GR, D, M, A): ");
			posicao = sc.next();

			robos.add(new Robo(new Ponto(x,y), id, posicao));

		}while(robos.size()<3);

		return new Equipa(nome, treinador, robos);
	}

	private static int getRandomInt(int min, int max) { //[min; max]

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
