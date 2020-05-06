public enum DiaSemana {
	segunda, terça, quarta, quinta, sexta, sábado, domingo;

	public static String getEnum(int i) {
		switch (i){
			case 1:
				return "Terça";
			case 2:
				return "Quarta";
			case 3:
				return "Quinta";
			case 4:
				return "Sexta";
			case 5:
				return "Sábado";
			case 6:
				return "Domingo";
			default:
				return "Segunda";

		}

	}
}
