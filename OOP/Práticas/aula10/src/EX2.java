import java.util.*;

public class EX2 {
	//ANSI escape code
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {
		Map<String, ArrayList<String>> dict = new TreeMap<>();
		dict.put("Prorrogar", new ArrayList<>(Arrays.asList("Tornar mais longo"
				, "Fazer durar para além do tempo ou prazo definido")));

		dict.put("Medo", new ArrayList<>(Arrays.asList("Preocupação com determinado facto ou " +
						"com determinada possibilidade", "Ausência de coragem", "Estado emocional " +
						"resultante da consciência de perigo ou de ameaça, reais, hipotéticos ou imaginários")));

		dict.put("Assíncrono", new ArrayList<>(Arrays.asList("Contrário de simultâneo"
				, "Que não se realiza ao mesmo tempo que outro")));

		dict.put("Resiliência", new ArrayList<>(Arrays.asList("Capacidade de superar, de recuperar de adversidades"
				, "Propriedade de um corpo de recuperar a sua forma original após sofrer choque ou deformação")));

		dict.put("Inerente", new ArrayList<>(Arrays.asList("Intimamente unido"
				, "Que é atributo ou propriedade de algo ou alguém"
				, "Que faz parte de pessoa ou coisa")));



		System.out.println(ANSI_GREEN+"->Termo: Significado"+ANSI_RESET);
		for (String termo : dict.keySet()) {
			System.out.print(termo + ": ");
			for (String s : dict.get(termo))
				System.out.printf("%dº) %s ", dict.get(termo).indexOf(s) + 1, s);

			System.out.println();
		}

		System.out.println(ANSI_GREEN+"\n->Termos"+ANSI_RESET);
		for (String termo : dict.keySet())
			System.out.println(termo);

		System.out.println(ANSI_GREEN+"\n->Significado"+ANSI_RESET);
		for (String termo : dict.keySet()) {
			for (String s : dict.get(termo))
				System.out.printf("%dº) %s ", dict.get(termo).indexOf(s) + 1, s);
			System.out.println();
		}

		System.out.println(ANSI_GREEN+"\n\nSelecionar termo aleatório: "+ANSI_RESET);
		System.out.println(significadoAleatorio(dict, "Medo")); // true
		System.out.println(significadoAleatorio(dict, "Não é termo")); // false
		System.out.println(significadoAleatorio(dict, "Assíncrono")); // true
		System.out.println(significadoAleatorio(dict, "Resiliência")); // true


	}

	private static String significadoAleatorio(Map<String, ArrayList<String>> dict, String termo){
		if (dict.containsKey(termo)){
			return String.format("%s: %s", termo, dict.get(termo).get(new Random().nextInt(dict.get(termo).size())));
		}

		return String.format("O termo \"%s\" não consta no dicionário.", termo);
	}
}
