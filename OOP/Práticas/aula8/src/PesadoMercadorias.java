public class PesadoMercadorias extends Pesado {
	private int cargaMax;

	public PesadoMercadorias(String matricula, String marca, String modelo, int cc, int nquadro, int peso, int cargaMax) {
		super(matricula, marca, modelo, cc, nquadro, peso);
		this.cargaMax = cargaMax;
	}

	public int getCargaMax() {
		return cargaMax;
	}

	public void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PesadoMercadorias)) return false;
		if (!super.equals(o)) return false;
		PesadoMercadorias that = (PesadoMercadorias) o;
		return getCargaMax() == that.getCargaMax();
	}

	@Override
	public String toString() {
		return super.toString() + " , " + cargaMax + "kg";
	}
}
