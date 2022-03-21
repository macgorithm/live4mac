package Mar_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_9081_단어맞추기_이예원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			char [] str = br.readLine().toCharArray();
			
			int idx = -1, idx2=0;
			char temp;
			
			//맨 뒤에서부터 하나씩 비교 
			for (int j = str.length-1; j>0; j--) {
				if(str[j-1]<str[j]) {
					idx=j-1;
					break;
				}
				
			}
			
			//주어진 단어가 마지막 단어면 그대로 출력 
			if(idx==-1) {
				for (int j = 0; j < str.length; j++) {
					sb.append(str[j]);
				}
				sb.append("\n");
			}
			
			else {
				for (int j = str.length-1; j>=0; j--) {
					if(str[idx]<str[j]) {
						idx2=j;
						break;
					}
				}
				temp=str[idx];
				str[idx]=str[idx2];
				str[idx2]=temp;
				
				Arrays.sort(str,idx+1,str.length);
				
				for (int j = 0; j < str.length; j++) {
					sb.append(str[j]);
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb.toString());

	}

}
