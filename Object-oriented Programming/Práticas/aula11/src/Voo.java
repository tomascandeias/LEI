public class Voo {
	private String hora, codigo, origem, atraso, previsto;

	public Voo(String hora, String codigo, String origem) {
		this.hora = hora;
		this.codigo = codigo;
		this.origem = origem;
		this.atraso = "";
		this.previsto = "";
	}

	public Voo(String hora, String codigo, String origem, String atraso) {
		this.hora = hora;
		this.codigo = codigo;
		this.origem = origem;
		this.atraso = atraso;
		this.previsto = horaPrevista(hora, atraso);
	}

	public String getHora() {
		return hora;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getOrigem() {
		return origem;
	}

	public String getAtraso() {
		return atraso;
	}

	public String getPrevisto() {
		return previsto;
	}

	public String getCompanhia(){
		return codigo.substring(0, 2);
	}

	public double getTimeM(String time){
		if (!time.equals("")) {
			String[] arrH = time.split(":");
			return Integer.parseInt(arrH[0]) * 60 + Integer.parseInt(arrH[1]);
		}
		return 0;
	}

	private String horaPrevista(String hora, String atraso){
		String[] arrH = hora.split(":");
		int horaMinutos = Integer.parseInt(arrH[0])*60 + Integer.parseInt(arrH[1]);
		String[] arrA = atraso.split(":");
		int atrasoMinutos = Integer.parseInt(arrA[0])*60 + Integer.parseInt(arrA[1]);
		int previstoMinutos = horaMinutos + atrasoMinutos;
		return String.format("%02d:%02d", previstoMinutos/60, previstoMinutos%60);
	}



	@Override
	public String toString() {
		return "Voo{" +
				"hora='" + hora + '\'' +
				", codigo='" + codigo + '\'' +
				", origem='" + origem + '\'' +
				", atraso='" + atraso + '\'' +
				", previsto='" + previsto + '\'' +
				'}';
	}
}
