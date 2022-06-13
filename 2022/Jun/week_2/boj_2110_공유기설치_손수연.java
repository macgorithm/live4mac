package Jun_2022.week3;

import java.io.*;
import java.util.*;

public class Main_BJ_2110_공유기설치 {
	
	static int N, C;
	static int[] modem;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 집의 수
		C = Integer.parseInt(st.nextToken()); // 공유기 수	
		modem = new int[N];
		
		for(int n = 0; n < N; n++) modem[n] = Integer.parseInt(br.readLine());
			
		Arrays.sort(modem);
		
		int min = 1;
		int max = modem[N-1] - modem[0];
		int answer = 0;
		
		while(max >= min) {
			int mid = (min+max) / 2; // 가장 인접한 공유기 사이의 거리

			if(isPossible(mid)) {
				answer = mid;
				min = mid + 1;
			} else
				max = mid - 1;
		}
		
		System.out.println(answer);
	}
	
	public static boolean isPossible(int dist) {
		int cnt = 1; // 설치한 공유기의 개수
		int installIdx = 0; // 직전에 공유기를 설치한 집의 인덱스
		
		for(int n = 1; n < N; n++) {
			if(modem[n]-modem[installIdx] < dist) continue;
			
			cnt++;
			installIdx = n;
			
			if(cnt == C) return true; // 설치해야 하는 공유기를 모두 설치한 경우
		}
		
		return false; // 설치해야 하는 공유기가 남아 있는 경우
	}
}