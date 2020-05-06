import java.util.*;
import static java.lang.System.*;

public class energia {
    public static void main(String[] args){
        Scanner sc = new Scanner(in);

        out.print("M = ");
        double m = sc.nextDouble();

        out.print("Ti = ");
        double ti = sc.nextDouble();

        out.print("Tf = ");
        double tf = sc.nextDouble();


        out.printf("Q = %.2f", m*(tf-ti)*4184);
        sc.close();
    }
}
