public class EX1 {
	public static void main(String[] args) {
		Empresa emp = new Empresa("Aluguer Motor", "1234-123", "geral@aluguermotor.pt");
		Automovel l1 = new Automovel("23-XA-56", "BMW", "X1", 2000, 65249, 600);
		Taxi t1 = new Taxi("26-MN-89", "Mercedes-Benz", "C200d", 2000, 124576, 400, 315);
		Motociclo m1 = new Motociclo("44-ZX-44", "Honda", "CBR500R", 500, "DESPORTIVO");
		PesadoPassageiros pg1 = new PesadoPassageiros("10-LP-01", "Iveco", "Midirider", 4000, 131313, 20000, 40);

		emp.getVeiculos().add(l1);
		emp.getVeiculos().add(t1);
		emp.getVeiculos().add(m1);
		emp.getVeiculos().add(pg1);

		emp.getVeiculos().get(0).trajeto(5);
		emp.getVeiculos().get(1).trajeto(10);
		emp.getVeiculos().get(2).trajeto(20);
		emp.getVeiculos().get(3).trajeto(20);
		emp.getVeiculos().get(3).trajeto(10);

		System.out.print("\n\nm1 compareTo t1: ");
		System.out.println(m1.compareTo(t1)); //m1>t1

		System.out.print("l1 compareTo t1: ");
		System.out.println(l1.compareTo(t1)); //l1==t1

		System.out.print("pg1 compareTo t1: ");
		System.out.println(pg1.compareTo(t1)); //l1==t1

		emp.getVeiculos().sort(Veiculo::compareTo);

		System.out.println(emp);

	}
}
