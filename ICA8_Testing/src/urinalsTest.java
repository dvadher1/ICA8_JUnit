import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class urinalsTest {

	@Test
	void testIsValidUrinals() {
		urinals urinal = new urinals();
		String currentUrinalSetup = "10011";
		boolean actual = urinal.isValidUrinals(currentUrinalSetup);
		boolean expected = false;
		
		System.out.println("====== Dhaval Vadher == TEST ONE EXECUTED =======");
		assertEquals(actual, expected);
	}

}
