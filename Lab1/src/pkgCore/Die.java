package pkgCore;
import java.util.Random;

public class Die {

	private int DieValue;

	public Die() {
		Random rand = new Random();
		DieValue = rand.nextInt(6) + 1;
	}

	public int getDieValue() {
		return DieValue;
	}
}
