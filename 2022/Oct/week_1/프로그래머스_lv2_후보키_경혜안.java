package Oct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 프로그래머스_lv2_후보키_경혜안 {
	static ArrayList<String> answer;
	static String[][] rel;
	public static void main(String[] args) {
		
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		rel = relation;
		answer = new ArrayList<String>();
		
		int[] arr = new int[relation[0].length];
		
		for (int i = 0; i < relation[0].length; i++) arr[i] = i;
		
		for (int i = 1; i <= relation[0].length; i++) {
			Comb(arr, new boolean[relation[0].length], 0, i);
		}
		
		System.out.println(answer.size());

	}
	
	static void Comb(int[] arr, boolean[] visited, int start, int d ) {
		
		if( d == 0) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) sb.append("1"); else sb.append("0");

			}

			int temp = Integer.parseInt(sb.toString(), 2);
			for (String a : answer) {
				if((temp & Integer.parseInt(a)) == Integer.parseInt(a)) {
					return;
				}
			}
			
			if(isPk(visited)) {
				answer.add(Integer.toString(temp));
			}
			
			
			
		}
		else {
			for (int i = start; i < visited.length; i++) {
				visited[i] = true;
				Comb(arr, visited, i+1, d-1);
				visited[i] = false;
			}
		}
	}
	
	static boolean isPk(boolean[] visited) {
		Set<String> list = new HashSet<String>();
		
		for (int i = 0; i < rel.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < visited.length; j++) {
				if(visited[j]) {
					sb.append(rel[i][j]);
				}
			}
			list.add(sb.toString());
		}
		
		if(list.size() == rel.length) return true;
		return false;
	}
	

}
