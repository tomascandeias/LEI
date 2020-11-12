import java.util.HashMap;
import java.util.Map;

public class EX1 {
	//ANSI escape code
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {
		Map<String, String> dict = new HashMap<>();
		dict.put("Prorrogar", "Tornar mais longo");
		dict.put("Medo", "Estado emocional resultante da consciência de perigo ou de ameaça, reais, hipotéticos ou imaginários");
		dict.put("Assíncrono", "Que não se realiza ao mesmo tempo que outro");
		dict.put("Resiliência", "Capacidade de superar, de recuperar de adversidades");
		dict.put("Inerente", "Que é atributo ou propriedade de algo ou alguém");


		System.out.println(ANSI_GREEN+"->Termo: Significado"+ANSI_RESET);
		for (String termo : dict.keySet())
			System.out.println(termo + ": "+ dict.get(termo));

		System.out.println(ANSI_GREEN+"\n->Termos"+ANSI_RESET);
		for (String termo : dict.keySet())
			System.out.println(termo);

		System.out.println(ANSI_GREEN+"\n->Significado"+ANSI_RESET);
		for (String termo : dict.keySet())
			System.out.println(dict.get(termo));
	}
}
