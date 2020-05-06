import java.util.*;
import static java.lang.System.*;

public class CelsiusToFahrenheit {
    public static void main(String[] args){
        Scanner sc = new Scanner(in);
        out.print("Celsius = ");
        double c = sc.nextDouble();
        out.printf("Fahrenheit = %.1f", (1.8*c)+32);
        sc.close();
    }
}
