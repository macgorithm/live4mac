package Jun_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class 프로그래머스_Lv3_N으로표현_이예원 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 5;
		int number = 12;
		
		int answer = -1;
		
		Set<Integer>[] dp = new Set[9];
		
		for (int i = 1; i < 9; i++) {
			dp[i]=new HashSet<>();
			dp[i].add(N);
			N=N*10+N;
		}
		
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < i; j++) {
				for (Integer a : dp[j]) {
					for (Integer b : dp[i-j]) {
						dp[i].add(a+b);
						dp[i].add(a-b);
						dp[i].add(b-a);
						dp[i].add(a*b);
						
						if(a!=0) {
							dp[i].add(b/a);
						}
						
						if(b!=0) {
							dp[i].add(a/b);
						}
					}
					
				}
			}
		}
		
		for (int i = 1; i < 9; i++) {
			if(dp[i].contains(number)) {
				answer=i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
