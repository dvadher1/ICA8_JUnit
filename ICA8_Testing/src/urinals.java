
/**
 * 
 * @author Dhaval Vadher (dvadher1 - 1225618953)
 *
 */

public class urinals {
	
	public static void main(String[] args) {
		
	}
	
	public boolean isValidUrinals(String currentUrinals) {
		boolean isValid = true;
		if(currentUrinals.length() <= 0) return true;
		char[] ch = currentUrinals.toCharArray();
		for(char c : ch) {
			if(c == '0' || c == '1') {
				continue;
			} else {
				return false;
			}
		}
		char prev = ch[0];
		for(int i=1; i<ch.length; i++) {
			if(ch[i] == prev && prev==1) return false;
			prev = ch[i];
		}
		
		
		return isValid;
	}
}