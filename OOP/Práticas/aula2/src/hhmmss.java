import java.util.*;
import static java.lang.System.*;

public class hhmmss {
	public static void main(String[] args){
		Scanner sc = new Scanner(in);

		out.print("Tempo em segundos?");
		int seconds = sc.nextInt();

		int h = seconds / 3600;
		int s_left = seconds - (h * 3600);
		int m = s_left / 60;
		int s = s_left - (m * 60);

		String time = "";

		if (h < 10){time += "0";}
		time += h + ":";

		if (m < 10){time += "0";}
		time += m + ":";

		if (s < 10) {time += "0";}
		time += s;

		out.println(time);
		sc.close();
	}
}
