package convert;

import static org.junit.Assert.*;
import static convert.Arabic.convert;

import org.junit.Test;

public class ConvertArabicToRomanTest {

	@Test
	public void testNumerals() {
		checkRomanNumerals("I",1);
		checkRomanNumerals("V",5);
	}
	
	@Test
	public void testAddition() {
		checkRomanNumerals("II",2);
		checkRomanNumerals("III",3);
	}
	
	@Test
	public void testSubtraction() {
		checkRomanNumerals("IV",4);
	}
	
	private void checkRomanNumerals(String roman, int arabic) {
		assertEquals(roman, convert(arabic));
	}
}
