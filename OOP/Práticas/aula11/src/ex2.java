import java.io.*;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class ex2 {
	public static void main(String[] args) throws IOException {
		Map<String, String> companhias = new TreeMap<>();
		List<Voo> lstVoos = new LinkedList<>();

		//Leitura de ficheiros
		Scanner scv = null, scc = null;

		try{
			scv = new Scanner(new File("src/voos.txt"));
			scc = new Scanner(new File("src/companhias.txt"));
		}catch (FileNotFoundException e){
			System.out.println("O ficheiro não foi encontrado!");
		}

		scc.nextLine();
		while (scc.hasNextLine()){
			String[] line = scc.nextLine().split("[\t]");
			companhias.put(line[0], line[1]);
		}
		scc.close();

		scv.nextLine();
		while (scv.hasNextLine()){
			String[] line = scv.nextLine().split("[\t]");
			if (line.length == 4){
				lstVoos.add(new Voo(line[0], line[1], line[2], line[3]));
			}else{
				lstVoos.add(new Voo(line[0], line[1], line[2]));
			}
		}
		scv.close();

		//Imprimir tabela a), gravá-la b)
		System.out.println("a)");
		try(PrintWriter info = new PrintWriter(new FileWriter("src/Infopublico.txt", true))) {

			System.out.printf("%-10s%-10s%-30s%-30s%-10s%s\n", "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");
			for (Voo v : lstVoos) {
				String sf = String.format("%-10s%-10s%-30s%-30s%-10s%s\n", v.getHora(), v.getCodigo(), companhias.get(v.getCompanhia()),
						v.getOrigem(), v.getAtraso(), ((!v.getPrevisto().equals("")) ? "Previsto: " + v.getPrevisto() : v.getPrevisto()));

				System.out.print(sf);
				info.append(sf);
			}
			info.close();
		}catch (IOException e){
			System.out.printf("[ERRO] %s\n", e.getMessage());
		}

		//calc media de atraso por companhia c)
		System.out.println("\nc)");
		Map<String, ArrayList<Double>> delay = new HashMap<>(); // sigla = [numero, soma, media]
		for (Voo v : lstVoos){
			if (v.getTimeM(v.getAtraso()) != 0) {
				if (delay.containsKey(v.getCompanhia())) {

					double n = delay.get(v.getCompanhia()).get(0) + 1;
					double soma = delay.get(v.getCompanhia()).get(1) + v.getTimeM(v.getAtraso());
					double media = soma / n;

					delay.put(v.getCompanhia(), new ArrayList<>());
					delay.get(v.getCompanhia()).add(n);
					delay.get(v.getCompanhia()).add(soma);
					delay.get(v.getCompanhia()).add(media);

				} else {
					delay.put(v.getCompanhia(), new ArrayList<>());
					delay.get(v.getCompanhia()).add(1.0);
					delay.get(v.getCompanhia()).add(v.getTimeM(v.getAtraso()));
					delay.get(v.getCompanhia()).add(v.getTimeM(v.getAtraso()));
				}
			}
		}

		HashMap<String, Double> delay2 = new HashMap<>();
		delay.forEach((k,v) -> delay2.put(k, v.get(2)));
		Map<String, Double> delaySorted = delay2.entrySet().stream().sorted(comparingByValue()).
				collect(
						toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

		System.out.printf("%-15s%-15s\n", "Companhia", "Atraso Médio");
		for (Map.Entry<String, Double> entry : delaySorted.entrySet()){
			String key = entry.getKey();
			Double value = entry.getValue();
			System.out.printf("%-15s%-15.2f\n", key, value);
		}

		//print & write cidades por numeros de voos d)
		System.out.println("\nd)");
		HashMap<String, Integer> cidades = new HashMap<>();

		for (Voo v : lstVoos){
			if (cidades.containsKey(v.getOrigem())){
				cidades.put(v.getOrigem(), cidades.get(v.getOrigem()) + 1);
			}else{
				cidades.put(v.getOrigem(), 1);
			}
		}

		Map<String, Integer> cidadesSorted = cidades.entrySet().stream()
				.sorted(Collections.reverseOrder(comparingByValue())).collect(
						toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

		Iterator it = cidadesSorted.entrySet().iterator();
		PrintWriter pwCidades = new PrintWriter(new FileWriter("src/cidades.txt", true));

		System.out.printf("%-30s%-10s\n", "Origem", "Voos");
		while (it.hasNext()){
			Map.Entry pair = (Map.Entry) it.next();
			String sf = String.format("%-30s%-10s\n", pair.getKey(), pair.getValue());
			System.out.printf(sf);
			pwCidades.append(sf);
		}
		pwCidades.close();

	}
}

