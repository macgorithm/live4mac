package Jun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 프로그래머스_lv3_N으로표현_경혜안 {

	public static void main(String[] args) {
		int N = 5 , number = 12, answer = 0;
		
		ArrayList<Set<Integer>> box = new ArrayList<Set<Integer>>();
		
		for (int i = 0; i < 9; i++) box.add(new HashSet<Integer>()); // 초기화 
		if(N == number) System.out.println(1);
		box.get(1).add(N);
		
		for (int i = 2; i < 9; i++) {
			for (int j = 1; j < i; j++) {
				DP(box.get(i), box.get(j), box.get(i-j));
			}
			
			
			box.get(i).add(repeat(N, i));
			
			for (Integer num : box.get(i)) {
				if(num == number) {
					System.out.println(i);
					return;
				}
			}
		}
		
		System.out.println(-1);

	}
	static int repeat(int n, int i) {
		
		String s = Integer.toString(n);
		
		for (int j = 1; j < i; j++) {
			s += Integer.toString(n);
		}
		
		return Integer.parseInt(s);
	}
	static void DP(Set<Integer> list, Set<Integer> next, Set<Integer> pre) {
		
		for (Integer n : next) {
			for (Integer p : pre) {
				list.add(n + p);
				list.add(n - p);
				list.add(n * p);
				
				if(p != 0) list.add(n / p);
			}
		}
	}

}
