package primeFactors;

import org.junit.Test;
import static org.junit.Assert.*;

public class PrimeFactorsTest {
	@Test
	public void factorsOf0() {
		assertEquals(null, PrimeFactors.calculate(0));
	}
}
