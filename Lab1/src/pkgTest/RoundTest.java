package pkgTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Round;

public class RoundTest {

	@Test
	public void testRollCount() {
		for (int i = 0; i < 10000; i++) {
			Round r = new Round();
			if(r.RollCount() < 0)
				fail("Game didn't roll once");
		}
	}
}
