import java.util.Arrays;

public class Conjunto {
	private int[] c = new int[0];


	public boolean contains(int n){
		for (int i=0; i<c.length; i++){
			if (c[i] == n)
				return true;
		}
		return false;
	}

	public void insert(int n){
		if (!contains(n)) {
			int[] clone = new int[c.length+1];
			for (int i=0; i<c.length; i++){
				clone[i] = c[i];
			}
			clone[clone.length-1] = n;
			c = clone;
		}
	}

	public void remove(int n){
		int[] clone = new int[c.length-1];
		int count=0;

		for (int i=0; i<c.length; i++){
			if (c[i] != n){
				clone[i-count] = c[i];
			}else{ count++; }
		}
		c = clone;
	}

	public void empty(){ c = new int[0]; }

	public int size(){ return c.length; }

	public Conjunto unir(Conjunto add){
		Conjunto union = new Conjunto();

		for (int i=0; i<c.length; i++)
			union.insert(c[i]);

		for (int i=0; i<add.size(); i++){
			if (!contains(add.getByIndex(i)))
				union.insert(add.getByIndex(i));

		}

		return union;
	}

	public Conjunto interset(Conjunto add){
		Conjunto inter = new Conjunto();

		for (int i=0; i<c.length; i++){
			for (int j=0; j<add.size(); j++)
				if (c[i] == add.getByIndex(j)) inter.insert(c[i]);
		}

		return inter;
	}

	public Conjunto subtrair(Conjunto diff){
		Conjunto sub = new Conjunto();

		for (int i=0; i<c.length; i++)
			sub.insert(c[i]);

		for (int i=0; i<c.length; i++){
			for (int j=0; j<diff.size(); j++){
				if (c[i] == diff.getByIndex(j))
					sub.remove(c[i]);
			}
		}

		return sub;
	}


	private int getByIndex(int i){ return c[i];}

	@Override
	public String toString() {
		return "Conjunto: " + Arrays.toString(c);
	}
}
