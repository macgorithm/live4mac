package Apr_2022.week5;

import java.io.*;
import java.util.*;

public class Main_BJ_1280_도로와신호등 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 신호등의 개수
		int L = Integer.parseInt(st.nextToken()); // 도로의 길이
		
		int[][] signal = new int[N][3];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			signal[n][0] = Integer.parseInt(st.nextToken()); // 신호등의 위치
			signal[n][1] = Integer.parseInt(st.nextToken()); // 빨간색 신호가 지속되는 시간
			signal[n][2] = Integer.parseInt(st.nextToken()); // 초록색 신호가 지속되는 시간
		}
		
		int time = 0; // 현재 시간 (절대 시간)
		
		for(int n = 0; n < N; n++) {
			
			int temp = time % (signal[n][1]+signal[n][2]);
			
			if(temp >= 0 && temp < signal[n][1]) // 현재 빨간색 신호인 경우
				time += signal[n][1] - temp;
			
			if(n == N-1) time += (L - signal[n][0]); // 마지막 신호등을 지난 경우	
			else time += (signal[n+1][0] - signal[n][0]);
		}
		
		System.out.println(time);
	}
}
