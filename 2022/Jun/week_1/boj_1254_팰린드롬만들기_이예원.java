package Jun_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1254_팰린드롬만들기_이예원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int ans = str.length();
		
		for (int i = 0; i < str.length(); i++) {
			if(isPalind(str.substring(i))) {
				break;
			}
			ans++;
		}
		
		System.out.println(ans);

	}

	static boolean isPalind(String str) {
		int start =0;
		int end = str.length()-1;
		
		while(start<=end) {
			if(str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
