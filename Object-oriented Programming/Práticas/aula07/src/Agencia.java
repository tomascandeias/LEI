import java.util.Arrays;
import java.util.LinkedList;

public class Agencia {
	private String name;
	private String address;
	LinkedList<Alojamento> alojamentos = new LinkedList<>();
	LinkedList<Viatura> viaturas = new LinkedList<>();

	public Agencia(String name, String address) {
		this.name = name;
		this.address = address;
	}


	public void add(Alojamento a){ alojamentos.add(a);}

	public void add(Viatura v){ viaturas.add(v);}

	public void remove(Alojamento a){ alojamentos.remove(a);}

	public void remove(Viatura v){ viaturas.remove(v);}

	public void removeAllAlojamentos(){ alojamentos.clear(); }

	public void removeAllViaturas(){ viaturas.clear();}

	public boolean contains(Alojamento a){ return alojamentos.contains(a);}

	public boolean contains(Viatura v){ return viaturas.contains(v);}

	public Alojamento getAlojamento(String id){
		for (Alojamento a : alojamentos){
			if (a.getCodigo().equalsIgnoreCase(id)){
				return a;
			}
		}
		return null;
	}

	public Viatura getViatura(String id){
		for (Viatura v : viaturas){
			if (v.getId() == id)
				return v;
		}
		return null;
	}

	//GET and SET
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getAddress() { return address; }

	public void setAddress(String address) { this.address = address; }

	public LinkedList<Alojamento> getAlojamentos() { return alojamentos; }

	public LinkedList<Viatura> getViaturas() { return viaturas; }

	@Override
	public String toString() {
		return "Agencia{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", alojamentos=" + alojamentos +
				", viaturas=" + viaturas +
				'}';
	}
}
