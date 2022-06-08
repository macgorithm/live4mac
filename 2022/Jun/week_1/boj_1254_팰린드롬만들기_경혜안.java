package Jun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1254_팰린드롬만들기_경혜안 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		
		for (int i = 0; i < s.length(); i++) {
			if(isFalindrome(s.substring(i))) {
				
				System.out.println(s.length() + i);
				break;
			}
		}

	}
	
	static boolean isFalindrome(String s) {
		
		int len = s.length();
		
		for (int i = 0; i < len / 2; i++) {
			if(s.charAt(i) != s.charAt(len-i-1)) return false;
		}
		return true;
	}

}
