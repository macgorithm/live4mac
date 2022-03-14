package Mar_2022.week1;

import java.util.*;
import java.io.*;

public class boj_14889_스타트와링크_손수연 {
	
	static int N, minDiff;
	static int[][] skill;
	
	static int[] select;
	static HashSet<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 사람 수
		skill = new int[N][N];
		
		for(int n1 = 0; n1 < N; n1++) {
			st = new StringTokenizer(br.readLine());
			for(int n2 = 0; n2 < N; n2++)
				skill[n1][n2] = Integer.parseInt(st.nextToken());
		}
		
		minDiff = Integer.MAX_VALUE;
		select = new int[N/2];
		
		combination(0, 0); // 스타트 팀 뽑기
		
		System.out.println(minDiff);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == N/2) {
			set = new HashSet<>();
			for(int i = 0; i < N/2; i++) set.add(select[i]);
			
			findMin();
			return;
		}
		
		for(int i = start; i < N; i++) {
			select[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	public static void findMin() {
		int skillSum1 = 0, skillSum2 = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(set.contains(i) && set.contains(j)) skillSum1 += skill[i][j]; // 스타트 팀인 경우
				else if(!set.contains(i) && !set.contains(j)) skillSum2 += skill[i][j]; // 링크 팀인 경우
			}
		}
		
		minDiff = Math.min(Math.abs(skillSum1-skillSum2), minDiff); // 최소값 갱신
	}
}