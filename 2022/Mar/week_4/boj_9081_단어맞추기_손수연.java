package Mar_2022.week3;

import java.io.*;
import java.util.*;

public class boj_9081_단어맞추기_손수연 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			String word = br.readLine();
			
			int idx1 = -1;
			int idx2 = 0;
        
            for(int i = word.length()-1; i > 0 ; i--) {
                if(word.charAt(i-1) < word.charAt(i)) { // 바로 뒤에 있는 문자가 더 큰 경우
                    idx1 = i-1;
                    break;
                }
            }
            
            if(idx1 == -1)  // 내림차순인 경우 (모두 바로 앞에 있는 문자가 더 큰 경우) -> 주어진 단어가 마지막 단어인 경우
                System.out.println(word);
            else {
                for(int i = word.length()-1; i >= 0; i--) {
                    if(word.charAt(idx1) < word.charAt(i)) {
                        idx2 = i;
                        break;
                    }
                }
                
                char tmp = word.charAt(idx1);
                word = word.substring(0, idx1) + word.charAt(idx2) + word.substring(idx1+1);
                word = word.substring(0, idx2) + tmp + word.substring(idx2+1);
                
                char[] wordArr = word.toCharArray();
                Arrays.sort(wordArr, idx1+1, wordArr.length);
                
                for(int i = 0; i < wordArr.length; i++) System.out.print(word);
            }
		}
	}
}
