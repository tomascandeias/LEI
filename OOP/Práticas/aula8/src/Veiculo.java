import java.util.Objects;

public class Veiculo implements KmPercorridosInterface, Comparable<Veiculo> {
	private String matricula, marca, modelo;
	private int cc, nquadro, kmPercorridos=0, ultimoTrajeto=0;

	public Veiculo(String matricula, String marca, String modelo, int cc, int nquadro) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.cc = cc;
		this.nquadro = nquadro;
	}

	public Veiculo(String matricula, String marca, String modelo, int cc){
		this(matricula, marca, modelo, cc, -1);
	}

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public int getNquadro() {
		return nquadro;
	}

	public int getCC() {
		return cc;
	}

	public void setCC(int cc) {
		this.cc = cc;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Veiculo)) return false;
		Veiculo veiculo = (Veiculo) o;
		return cc == veiculo.cc &&
				Objects.equals(getMatricula(), veiculo.getMatricula()) &&
				Objects.equals(getMarca(), veiculo.getMarca()) &&
				Objects.equals(modelo, veiculo.modelo) &&
				Objects.equals(getNquadro(), veiculo.getNquadro());
	}

	@Override
	public String toString() {
		return "\nVeiculo{" +
				"matricula='" + matricula + '\'' +
				", marca='" + marca + '\'' +
				", modelo='" + modelo + '\'' +
				", nquadro='" + nquadro + '\'' +
				", cc=" + cc +
				", kmPercorridos=" + kmPercorridos +
				", ultimoTrajeto=" + ultimoTrajeto +
				'}';
	}

	public void trajeto(int km) {
		kmPercorridos += km;
		ultimoTrajeto = km;
	}

	public int ultimoTrajeto() {
		return ultimoTrajeto;
	}

	public int distanciaTotal() {
		return kmPercorridos;
	}

	@Override
	public int compareTo(Veiculo o) {
		if(this.cc > o.getCC()){
			return 1;
		}else if(this.cc < o.getCC()){
			return -1;
		}else{
			return 0;
		}
	}
}
