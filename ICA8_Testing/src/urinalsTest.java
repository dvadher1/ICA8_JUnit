import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

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
	
	@Test
	void testReadFromFileFileDoesNotExist() {
		urinals urinal = new urinals();
		
		Throwable exception = assertThrows(FileNotFoundException.class, () -> urinal.readFromFile("files\\urinalsss.dat"));
		assertEquals("files\\urinalsss.dat (The system cannot find the file specified)", exception.getMessage());
	}
}
