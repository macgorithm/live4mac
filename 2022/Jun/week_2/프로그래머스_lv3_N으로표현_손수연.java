package Jun_2022.week3;

import java.io.*;
import java.util.*;

public class Solution_Programmers_42895_N으로표현 {
	
	static Set<Integer>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 사칙연산에 사용할 수
		int number = Integer.parseInt(br.readLine()); // 사칙연산으로 만들 수
		
		System.out.println(solution(N, number));
		
	}
	
	public static int solution(int N, int number) {
        if(N == number) return 1;
        
        list = new Set[9];
        
        for(int n = 1; n <= 8; n++) { // i: N의 사용횟수
        	list[n] = new HashSet<Integer>();
        	
        	String num = "";
        	for(int i = 0; i < n; i++) num += N+"";
        	
        	list[n].add(Integer.parseInt(num));
        	
        	for(int setIdx = 1; setIdx < n; setIdx++) connect(n, setIdx);
        	
        	if(list[n].contains(number)) return n;
        }
        
        return -1;
    }
	
	public static void connect(int n, int setIdx) {
		for(int i : list[setIdx]) {
			for(int j : list[n-setIdx]) {
				list[n].add(i + j);
				list[n].add(i - j);
				list[n].add(i * j);
				if(j != 0) list[n].add(i / j);
			}
		}
	}
}
