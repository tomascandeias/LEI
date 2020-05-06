import java.util.*;

public class CollectionTester {
	//ANSI escape code
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {
		System.out.printf("%s%-20s%15d%15d%15d%15d%15d%15d%s%n", ANSI_GREEN, "Collection",
																1000, 5000, 10000, 20000, 40000, 100000, ANSI_RESET);

		Collection<Integer> al = new ArrayList<>();
		printPerformance(al);

		Collection<Integer> ll = new LinkedList<>();
		printPerformance(ll);

		Collection<Integer> ts = new TreeSet<>();
		printPerformance(ts);

		Collection<Integer> hs = new HashSet<>();
		printPerformance(hs);
	}

	private static double[] checkPerformance(Collection<Integer> col, int DIM) {
		double start, stop, delta;
		double[] values = new double[3];
		// Add
		start = System.nanoTime(); // clock snapshot before
		for (int i = 0; i < DIM; i++)
			col.add(i);
		stop = System.nanoTime();  // clock snapshot after
		delta = (stop - start) / 1e6; // convert to milliseconds
		values[0] = delta;
		//System.out.println(col.size() + ": Add to " + col.getClass().getSimpleName() + " took " + delta + "ms");

		// Search
		start = System.nanoTime(); // clock snapshot before
		for (int i = 0; i < DIM; i++) {
			int n = (int) (Math.random() * DIM);
			if (!col.contains(n))
				System.out.println("Not found???" + n);
		}
		stop = System.nanoTime();  // clock snapshot after
		delta= (stop-start)/1e6; // convert nanoseconds to milliseconds
		values[1] = delta;
		//System.out.println(col.size()+ ": Search to "+ col.getClass().getSimpleName() +" took "+ delta+ "ms");

		// Remove
		start= System.nanoTime(); // clock snapshot before
		Iterator<Integer>iterator= col.iterator();
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		stop= System.nanoTime();  // clock snapshot after
		delta= (stop-start)/1e6; // convert nanoseconds to milliseconds
		values[2] = delta;
		//System.out.println(col.size() + ": Remove from "+ col.getClass().getSimpleName() +" took "+ delta+ "ms");

		return values;
	}

	private static void printPerformance(Collection<Integer> c){
		int[] DIM = {1000, 5000, 10000, 20000, 40000, 100000};
		double[][] values = new double[3][6];
		int x = 0;
		for (int i : DIM){
			double[] tmp = checkPerformance(c, i);
			values[0][x] = tmp[0];
			values[1][x] = tmp[1];
			values[2][x] = tmp[2];
			x++;
		}

		System.out.printf("%n%s%-20s%s%n",ANSI_GREEN, c.getClass().getSimpleName(), ANSI_RESET);
		x = 0;
		String[] methods = {"add", "search", "remove"};
		for (double[] m : values) {
			System.out.printf("%-20s%15.1f%15.1f%15.1f%15.1f%15.1f%15.1f%n", methods[x], m[0], m[1], m[2], m[3], m[4], m[5]);
			x++;
		}
	}
}
