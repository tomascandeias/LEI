import java.util.*;

public class ALDemo {
	public static void main(String[] args) {
		ArrayList<Integer> c1= new ArrayList<>();
		for(int i= 10; i<= 100; i+=10)
			c1.add(i);
		System.out.println("Size: "+ c1.size());

		for(int i= 0; i< c1.size(); i++)
			System.out.println("Elemento: "+ c1.get(i));

		ArrayList<String> c2= new ArrayList<>();
		c2.add("Vento");
		c2.add("Calor");
		c2.add("Frio");
		c2.add("Chuva");
		System.out.println(c2);

		Collections.sort(c2);
		System.out.println(c2);

		c2.remove("Frio");
		c2.remove(0);
		System.out.println(c2);


		Set<Pessoa> c3 = new HashSet<>();
		c3.add(new Pessoa("Pedro Silva", 12345, new Data(1,1,2000)));
		c3.add(new Pessoa("Tiago Rodrigues", 54321, new Data(5,5,2000)));
		c3.add(new Pessoa("Tomás Candeias", 45673, new Data(21,11,1999)));
		c3.add(new Pessoa("Carla Santos", 63846, new Data(10,7,2001)));
		c3.add(new Pessoa("Sofia Andrade", 10293, new Data(18,12,2001)));
		c3.add(new Pessoa("Pedro Silva", 12345, new Data(1,1,2000))); //igual!
		Iterator<Pessoa> it_c3 = c3.iterator();
		while (it_c3.hasNext()){
			System.out.println(it_c3.next());
		}

		Set<Data> c4 = new TreeSet<>();
		c4.add(new Data(1,1,2000));
		c4.add(new Data(2,1,2000));
		c4.add(new Data(21,11,1999));
		c4.add(new Data(6,6,2001));
		c4.add(new Data(5,6,2001));
		Iterator<Data> it_c4 = c4.iterator();
		while(it_c4.hasNext()){
			System.out.println(it_c4.next());
		}


	}
}
