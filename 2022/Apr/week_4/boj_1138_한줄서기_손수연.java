package Mar_2022.week3;

import java.io.*;
import java.util.*;

public class boj_1138_한줄서기_손수연 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int[] taller = new int[N]; // 자기보다 키 큰 사람의 수
		boolean checked[] = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int n1 = 0; n1 < N; n1++) {
			int num = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			for(int n2 = 0; n2 < N; n2++) {
				if(!checked[n2]) {
					if(cnt == num) {
						checked[n2] = true;
						taller[n2] = n1+1;
						break;
					}
					
					cnt++;
				}
			}
		}
		
		for(int n = 0; n < N; n++) System.out.println(taller[n] + " ");
	}
}
