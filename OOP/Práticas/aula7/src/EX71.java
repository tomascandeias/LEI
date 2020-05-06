public class EX71 {
	public static void main(String[] args){
		//Testes à classe Data
		System.out.println("[TESTES] CLASSE DATA\n");
		Data d1 = new Data(30,11,1999);
		Data d2 = new Data(31,03,2000);
		Data d3 = new Data();
		Data d4 = new Data(30,11,2000);
		Data d5 = new Data(31,03,2001);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3); //data de hoje
		System.out.println(Data.daysBetween(d1, d2)); //122 pq fev tem 29 dias
		System.out.println(Data.daysBetween(d4, d5)); //121 pq fev tem 28 dias

		//Testes à classe AgenciaViagens e classes adjacentes(Carro, Alojamento e heranças deste)
		System.out.println("\n\nCLASSE AGENCIAVIAGENS\n");
		Agencia ag = new Agencia("Abreu", "Lisboa");
		System.out.println(ag);
		ag.add(new Quarto("A2C4","Edifício Colombo","Lisboa, Portugal",60.56,5,"Triple"));
		ag.add(new Quarto("A2C5","Edifício Belick","Anadia, Portugal",23.56,5,"Twin"));
		ag.add(new Apartamento("A2C6","Edifício UA","Barquinha, Portugal",54.56,5,6));
		ag.add(new Quarto("A2C7","Edifício WTv","Lisboa, Portugal",56.56,5,"Single"));
		ag.add(new Apartamento("A2C8","Edifício Ola","Pedrogao, Portugal",76.56,5,3));
		ag.add(new Quarto("A2C9","Edifício Java","Porto, Portugal",90.56,5,"Double"));
		ag.add(new Viatura('a',"Diesel", "C1"));
		ag.add(new Viatura('c',"Gasolina", "C2"));
		System.out.println(ag);
		ag.getAlojamento("A2C4").checkIn("Gonçalo Matos", "14824244ZX4", 3, new Data(01,04,2019)); //A pagar 60.56xnoites desde 01/04/2019
		ag.getAlojamento("A2C4").checkIn("Teresa Matos", "12345BA", 2); //Erro
		System.out.println(ag.getAlojamento("A2C4")); //dados primeira tentativa
		System.out.println("Checkout realizado! A pagar:"+ag.getAlojamento("A2C4").checkOut());
		System.out.println(ag.getAlojamento("A2C4")); //Quarto livre
		ag.getViatura("C2").entregar();	//Erro
		ag.getViatura("C2").levantar("Gonçalo Matos", "123456nbgv");
		System.out.println(ag.getViatura("C2"));
		ag.getViatura("C2").entregar();
		ag.getAlojamento("A2C5").setRating(1);
		System.out.println(ag);
		ag.removeAllAlojamentos();
		ag.removeAllViaturas();
		System.out.println(ag);
	}
}
