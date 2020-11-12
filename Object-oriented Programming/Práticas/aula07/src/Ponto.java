import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Ponto {
	private double x, y;

	public Ponto(double x, double y){
		this.x = x;
		this.y = y;
	}


	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double dist(Ponto a){
		return sqrt(pow(x-a.getX(), 2) + pow(y-a.getY(), 2));
	}

	@Override
	public String toString() {
		return "Ponto{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
