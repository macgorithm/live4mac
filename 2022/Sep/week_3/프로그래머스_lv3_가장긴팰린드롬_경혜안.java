package Sep;

public class 프로그래머스_lv2_가장긴팰린드롬_경혜안 {
	static int answer = 1;
	
	public static void main(String[] args) {
		String s = "abacde";
		
		
		
		findPalindrome(s);
		
		System.out.println(answer);
		
	}
	
	static void findPalindrome( String str) {
		
		int len = str.length();
		for (int i = len; i > 1; i--) {
			
			for (int j = 0; j + i <= len ; j++) {
				
				boolean isPalindrome = true;
				
				for (int k = 0; k < i/2; k++) {
					if(str.charAt(j+k) != str.charAt(j + i - k - 1)) {
						isPalindrome = false;
						break;
					}
				}
				
				if(isPalindrome) {
					answer = i;
					return;
				}
			}
		}
		
	}

}
