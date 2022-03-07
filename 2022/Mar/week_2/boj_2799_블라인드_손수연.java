package Mar_2022.week1;

import java.util.*;
import java.io.*;

public class boj_2799_블라인드_손수연 { 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); // 층 수
		int N = Integer.parseInt(st.nextToken()); // 한 층 당 창문 개수
		
		int[][] windows = new int[M][N]; // 창문 상태
		int[] typeNum = new int[5]; // 타입 별 개수;
		
		for(int m = 0; m < M; m++) {
			br.readLine(); // 층 구분(#)
			
			for(int g = 1; g <= 4; g++) { // 창문 당 4 그리드
				st = new StringTokenizer(br.readLine(), "#"); // 같은 층 모든 창문의 한 줄
				
				for(int n = 0; n < N; n++) {
					String line = st.nextToken();
					
					if(line.equals("****"))
						windows[m][n] = g; // 블라인드의 마지막 위치 갱신
				}
			}
		}
		br.readLine(); // 층 구분(#)
		
		for(int m = 0; m < M; m++) {
			for(int n = 0; n < N; n++) {
				typeNum[windows[m][n]]++; // 블라인드의 마지막 위치(= 창문 상태) 카운트
			}
		}
		
		for(int t = 0; t < 5; t++)
			System.out.print(typeNum[t] + " ");
	}
}