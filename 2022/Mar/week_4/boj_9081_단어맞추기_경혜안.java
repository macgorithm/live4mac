package Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9081_단어맞추기_경혜안 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < t; i++) {
			String str = bf.readLine();
			int len = str.length();
			int[] alpha = new int[26];
			int idx = str.charAt(len-1) - 'A'; // 비교 기준 문자 
			alpha[idx]++;
			int breakPoint = -1;
			int breakIdx = -1;
			for (int j = len-2; j >= 0 ; j--) {
				int cur = str.charAt(j) - 'A';
				alpha[cur]++;
				if(cur < idx) {
					breakPoint = cur;
					breakIdx = j;
					break;
				}
				idx = cur;
			}
			if(breakPoint == -1) {
				System.out.println(str);
				continue;
			}
			
			String answer = "";
			
			// 바뀐 포인트 이 전의 문자들은 그대로 저장 
			for (int j = 0; j < breakIdx; j++) {
				answer += str.charAt(j);
			}
			
			// 바뀐 포인트보다 바로 다음 큰 문자 저장 
			for (int j = breakPoint+1; j < 26; j++) {
				if(alpha[j] > 0) {
					alpha[j]--;
					answer += (char)('A' + j);
					break;
				}
			}
			
			for (int j = 0; j < 26; j++) {
				while(alpha[j] > 0) {
					alpha[j]--;
					answer += (char)('A'+j);
				}
			}
			
			System.out.println(answer);
			
			
			
			
			
		}

	}
	
}

