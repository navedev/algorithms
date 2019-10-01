package algo;

/**
 * 
 * Deletes some characters in a String to form the other String
 * 
 * @author ndevara
 *
 */
class StringDeleteCompare {
	
	public static void main(String[] args) throws java.lang.Exception {
		String a = "KXzQ"; 
		String b = "K";
		int i = a.length() - 1;
		int j = b.length() - 1;

		int count = 0;

		if (a.length() < b.length()) {
			System.out.println("NO");
		} else {
			while (i >= 0 && j >= 0) {
				if (Character.toLowerCase(a.charAt(i)) == Character.toLowerCase(b.charAt(j))) {
					i--;
					j--;
					count++;
				} else {
					i--;
				}
			}
			if (count == b.length()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}
}
