package net.hyrrmadr.cip7tocip13;

final public class CIP7toCIP13 {
	
	// Static class
	private CIP7toCIP13() {
	}

	public static String computeChecksum(String serial) {
	    int sum = 0;
	    
	    for (int i = 0, s = serial.length(); i < s; ++i) {
	    	int digit = (serial.charAt(i) - '0');
	    	
	    	if (i % 2 == s % 2)
	    		sum += digit;
	    	else
	    		sum += digit * 3;
	    }
	    if (sum % 10 <= 0)
	    	return ("0");
	    
	    int msum = ((sum / 10) + 1) * 10;
	    return "" + (msum - sum);
	}

	public static boolean checkCIP13(String cip13) {
		int size = cip13.length();
		if (size < 2)
			return false;
		String digit = cip13.substring(size - 1, size);
		String checksum = computeChecksum(cip13.substring(0, size - 1));
		
	    return (digit.equals(checksum));
	}

	public static String CIP7ToCIP13(String cip7) {
	    String num = "34009" + cip7;
	    String digit = computeChecksum(num);
	    
	    return (num + digit);
	}
}
