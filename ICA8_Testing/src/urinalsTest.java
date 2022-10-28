import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
		System.out.println("====== Dhaval Vadher == TEST THREE EXECUTED =======");
		urinals urinal = new urinals();
		
		Throwable exception = assertThrows(FileNotFoundException.class, () -> urinal.readFromFile("files\\urinalsss.dat"));
		assertEquals("files\\urinalsss.dat (The system cannot find the file specified)", exception.getMessage());
	}
	
	@Test
	void testReadFromFile() {
		System.out.println("====== Dhaval Vadher == TEST FOUR EXECUTED =======");
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
		System.out.println("====== Dhaval Vadher == TEST FIVE EXECUTED =======");
		urinals urinal = new urinals();
		try {
			urinal.readFromFile("files\\urinalEmpty.dat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(urinal.urinalsInput.size(), 0);
	}
	
	@Test
	void testCalculateFreeUrinals() {
		System.out.println("====== Dhaval Vadher == TEST SIX EXECUTED =======");
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
	
	@Test
	void testWriteToFileIOException() {
		System.out.println("====== Dhaval Vadher == TEST SEVEN EXECUTED =======");
		urinals urinal = new urinals();
		try {
			urinal.readFromFile("files\\urinal.dat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(String currentUrinalSetup : urinal.urinalsInput) {
			if(urinal.isValidUrinals(currentUrinalSetup)) {
				ans.add(urinal.calculateFreeUrinals(currentUrinalSetup));
			} else {
				ans.add(-1);
			}
		}
		Throwable exception = assertThrows(IOException.class, () -> urinal.writeToFile(ans, "file\\rule.txt"));
		assertEquals("The system cannot find the path specified", exception.getMessage());
	}
	
	@Test
	void testWriteToFile() {
		System.out.println("====== Dhaval Vadher == TEST EIGHT EXECUTED =======");
		urinals urinal = new urinals();
		try {
			urinal.readFromFile("files\\urinal.dat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(String currentUrinalSetup : urinal.urinalsInput) {
			if(urinal.isValidUrinals(currentUrinalSetup)) {
				ans.add(urinal.calculateFreeUrinals(currentUrinalSetup));
			} else {
				ans.add(-1);
			}
		}
		try {
			urinal.writeToFile(ans, "files\\rule.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Integer> actual = new ArrayList<>();
		try {
			System.setIn(new FileInputStream("files\\\\rule.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			try {
				while((line = br.readLine()) != null) {
//					if(line.equals("EOF") || line.equals("-1")) break;
					actual.add(Integer.parseInt(line));
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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