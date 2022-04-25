package Apr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 프로그래머스_Lv3_보석쇼핑_경혜안 {

	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] answer = new int[2];
		Set<String> cntGems = new HashSet<String>(Arrays.asList(gems));
		Map<String, Integer> cart = new HashMap<String, Integer>(); // 각 위치에 대한 보석 갯수 
		int cnt = cntGems.size(); // 보석의 종류 
		
		int start = 0, end = 0, diff = Integer.MAX_VALUE;
		
		while(true) {
			
			if(cnt == cart.size()) { // 현재 카트의 사이즈와 보석들의 갯수가 같다면, 구간 크기 줄이기 
				
				if(end-start < diff) { // 정답 갱신 구간 
					answer[0] = start + 1;
					answer[1] = end;
					diff = end-start;
				}
				cart.put(gems[start], cart.get(gems[start])-1); // 앞의 보석의 갯수 하나 줄이기 
				
				if(cart.get(gems[start]) == 0) cart.remove(gems[start]);
				
				start++;
			} else if (end == gems.length) break; // 구간이 끝난다면 멈추
			else { // 그 외 (증가 구간 )
				cart.put(gems[end], cart.getOrDefault(gems[end], 0) + 1);
				end++;
			}

		}
		

	}

}
