package Sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 프로그래머스_lv2_메뉴리뉴얼_경혜안 {
	static Map<String, Integer> menu;
	static int max;
	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		ArrayList<String> ans = new ArrayList<String>();
		
		for (int i = 0; i < orders.length ; i++) {
			char[] arr = orders[i].toCharArray();
			
			Arrays.sort(arr);
			
			orders[i] = String.valueOf(arr);
		}
		
		for (int i : course) {
			menu = new HashMap<String, Integer>();
			max = Integer.MIN_VALUE;
			for (String str : orders ) {
				if(str.length() < i) continue;
				comb(str, "", i);
			}
			
			for (String key : menu.keySet()) {
				if(menu.get(key) == max) {
					ans.add(key);
				}
			}
			
		}
		
		Collections.sort(ans);
		
		for (String string : ans) {
			System.out.println(string);
		}

	}
	
	static void comb(String str, String c, int cnt) {
		if(cnt == 0) {
			menu.put(c, menu.getOrDefault(c, 0) + 1);
			max = Math.max(max, menu.get(c));
			return;
		}
		
		for (int i = 0; i < str.length(); i++) {
			// 중복방지 조합을 위해 문자열자르기 진행 
			comb(str.substring(i+1), c+str.charAt(i), cnt-1);
		}
		
	}
	
	

}
