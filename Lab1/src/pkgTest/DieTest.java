package pkgTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Die;

public class DieTest {

	@Test
	public void TestDie() {

		for (int a = 0; a < 10000; a++) {
			Die d = new Die();
			if(d.getDieValue() < 1 || d.getDieValue() > 6)
				fail("Fail d = " + d.getDieValue());
		}
	}

}
