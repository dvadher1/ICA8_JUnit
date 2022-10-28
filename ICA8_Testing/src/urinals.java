import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	
	public static void main(String[] args) {
		urinals u = new urinals();
		try {
			u.readFromFile("files\\urinalss.dat");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
}