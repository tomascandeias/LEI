import java.util.Scanner;
import static java.lang.System.*;

public class checkprime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);

		out.print("Check number: ");
		int n = sc.nextInt();
		out.printf("The number %d %s", n, checkPrime(n) ? "is prime" : "isn't prime");

		sc.close();
	}

	public static boolean checkPrime(int n){
		if (n <= 0 || n == 1){
			return false;
		}else{
			for (int i=2; i<n; i++){
				if (n%i == 0){
					return false;
				}
			}
		}
		return true;
	}
}
