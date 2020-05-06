import java.util.*;
import static java.lang.System.*;

public class kmtomiles{
    public static void main(String[] args){
        Scanner sc = new Scanner(in);
        out.print("Km = ");
        double km = sc.nextDouble();
        out.printf("Miles = %.1f", (km/1.609));
        sc.close();
    }
}