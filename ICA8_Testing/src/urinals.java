import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Dhaval Vadher (dvadher1 - 1225618953)
 *
 */

public class urinals {
	
	public ArrayList<String> urinalsInput = new ArrayList<String>();
	public int countOfOutputFiles = 0;
	
	public static void main(String[] args) {
//		urinals urinal = new urinals();
//		try {
//			urinal.readFromFile("files\\urinal.dat");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		ArrayList<Integer> ans = new ArrayList<>();
//		for(String currentUrinalSetup : urinal.urinalsInput) {
//			if(urinal.isValidUrinals(currentUrinalSetup)) {
//				ans.add(urinal.calculateFreeUrinals(currentUrinalSetup));
//			} else {
//				ans.add(-1);
//			}
//		}
//		try {
//			urinal.writeToFile(ans, "file\\t.txt");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
	}

	
	public boolean isValidUrinals(String currentUrinal) {
		boolean isValid = true;
		if(currentUrinal.length() <= 0 || currentUrinal.length() > 20) return false;
		char[] ch = currentUrinal.toCharArray();
		for(char c : ch) {
			if(c == '0' || c == '1') {
				continue;
			} else {
				return false;
			}
		}
		char prev = ch[0];
		for(int i=1; i<ch.length; i++) {
			if(ch[i] == '1' && prev == '1') return false;
			prev = ch[i];
		}
		
		
		return isValid;
	}
	
	public void readFromFile(String fileName) throws Exception {
		try {
			System.setIn(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			throw e;
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		try {
			while((line = br.readLine()) != null) {
				if(line.equals("EOF") || line.equals("-1")) break;
				urinalsInput.add(line);
			}
		} catch (IOException e) {
			throw e;
		}
	}
	
	public void writeToFile(ArrayList<Integer> ans, String fileName) throws Exception {
		try {
			File file = new File(fileName);
			if(file.createNewFile()) {
				System.out.println("File created");
				FileWriter fileWriter = new FileWriter(fileName);
				for(int a : ans) {
					fileWriter.write(a + "\n");
				}
				fileWriter.close();
			} else {
				System.out.println("File already exists");
				countOfOutputFiles++;
				fileName = fileName.substring(0, 10) + countOfOutputFiles + fileName.substring(10);
				FileWriter fileWriter = new FileWriter(fileName);
				for(int a : ans) {
					fileWriter.write(a + "\n");
				}
				fileWriter.close();
			}			
		} catch(IOException e) {
			throw e;
		}
	}
	
	public int calculateFreeUrinals(String currentUrinal) {
		int freeUrinals = 0;
		
		char[] ch = currentUrinal.toCharArray();
		char prev = '0';
		for(int i=0; i<currentUrinal.length(); i++) {
			if(i+1 < currentUrinal.length()) {
				char next = ch[i+1];
				if(prev == '0' && next == '0' && ch[i] == '0') {
					freeUrinals++;
					ch[i] = '1';
				}
			} else {
				if(prev == '0' && ch[i] == '0') {
					freeUrinals++;
					ch[i] = '1';
				}
			}
			prev = ch[i];
		}
		
		return freeUrinals;
	}
}