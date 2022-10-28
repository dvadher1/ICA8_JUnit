import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class urinalsTest {

	@Test
	void testIsValidUrinalsForValidString() {
		System.out.println("====== Dhaval Vadher == TEST ONE EXECUTED =======");
		urinals urinal = new urinals();
		
		String currentUrinalSetup = "10001";
		boolean actual = urinal.isValidUrinals(currentUrinalSetup);
		boolean expected = true;
		assertEquals(actual, expected);
	}
	
	@Test
	void testIsValidUrinalsForInvalidString() {
		System.out.println("====== Dhaval Vadher == TEST TWO EXECUTED =======");
		urinals urinal = new urinals();
		
		String currentUrinalSetup = "10110000";
		boolean actual = urinal.isValidUrinals(currentUrinalSetup);
		boolean expected = false;
		assertEquals(actual, expected);
	}
}
