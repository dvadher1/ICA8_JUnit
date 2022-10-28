import java.util.ArrayList;

/**
 * 
 * @author Dhaval Vadher (dvadher1 - 1225618953)
 *
 */

public class urinals {
	
	public ArrayList<String> urinalsInput = new ArrayList<String>();
	
	public static void main(String[] args) {

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
}