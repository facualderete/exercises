package elementum;

public class Exercise1 {

	public static void main(String[] args) {
		System.out.println(isPalindrome("neuquen"));
		System.out.println(isPalindrome("anita lava la tina"));
		System.out.println(isPalindrome("madam, I'm adam"));
	}
	
	private static boolean isPalindrome(String string) {
		string = string.toLowerCase();
		string = removeNonLetters(string);
		for (int i = 0 ; i < Math.floor(string.length()/2) ; i++) {
			if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	private static String removeNonLetters (String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0 ; i < s.length() ; i++) {
			if (!Character.isLetter(s.charAt(i))) {
				sb.deleteCharAt(i);
			}
		}
		return sb.toString();
	}

}
