import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
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
	
	@Test
	void testReadFromFileFileDoesNotExist() {
		urinals urinal = new urinals();
		
		Throwable exception = assertThrows(FileNotFoundException.class, () -> urinal.readFromFile("files\\urinalsss.dat"));
		assertEquals("files\\urinalsss.dat (The system cannot find the file specified)", exception.getMessage());
	}
	
	@Test
	void testReadFromFile() {
		urinals urinal = new urinals();
		try {
			urinal.readFromFile("files\\urinal.dat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> actual = urinal.urinalsInput;	
		ArrayList<String> expected = new ArrayList<>();
		expected.add("10001");
		expected.add("110");
		expected.add("1001");
		expected.add("00000");
		expected.add("0000");
		expected.add("01000");
		expected.add("");
		expected.add("0");
		expected.add("1");
		expected.add("10010001000010000010");
		expected.add("10010010010010010010");
		expected.add("10001011001010110101");
		assertEquals(actual, expected);
	}
	
	@Test
	void testReadFromEmptyFile() {
		urinals urinal = new urinals();
		try {
			urinal.readFromFile("files\\urinalEmpty.dat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(urinal.urinalsInput.size(), 0);
	}
	
	@Test
	void calculateFreeUrinals() {
		urinals urinal = new urinals();
		try {
			urinal.readFromFile("files\\urinal.dat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<Integer> actual = new ArrayList<>();
		for(String currentUrinalSetup : urinal.urinalsInput) {
			if(urinal.isValidUrinals(currentUrinalSetup)) {
				actual.add(urinal.calculateFreeUrinals(currentUrinalSetup));
			} else {
				actual.add(-1);
			}
		}
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(-1);
		expected.add(0);
		expected.add(3);
		expected.add(2);
		expected.add(1);
		expected.add(-1);
		expected.add(1);
		expected.add(0);
		expected.add(4);
		expected.add(0);
		expected.add(-1);
		assertEquals(actual, expected);
		
	}
}
