package Apr_2022.week2;

import java.util.*;
import java.io.*;

public class Main_BJ_11265_끝나지않는파티 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 파티장의 크기
		int M = Integer.parseInt(st.nextToken()); // 서비스를 요청한 손님의 수
		
		int[][] map = new int[N+1][N+1]; // 파티장으로 이동하는 시간
		
		for(int n1 = 1; n1 <= N; n1++) {
			st = new StringTokenizer(br.readLine());
			
			for(int n2 = 1; n2 <= N; n2++) {
				int T = Integer.parseInt(st.nextToken());
				
				if(n1!=n2 && T==0) map[n1][n2] = 1000000*N+1;
				else map[n1][n2] = T;
			}
		}
		
		for(int k = 1; k <= N; k++) {
			for(int n1 = 1; n1 <= N; n1++) {
				for(int n2 = 1; n2 <= N; n2++) {
					map[n1][n2] = Math.min(map[n1][n2], map[n1][k] + map[k][n2]);
				}
			}
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 서비스를 요청한 손님이 위치한 파티장의 번호
			int B = Integer.parseInt(st.nextToken()); // 다음 파티가 열리는 파티장의 번호
			int C = Integer.parseInt(st.nextToken()); // 지금으로부터 다음 파티가 열리는데 걸리는 시간
			
			if(map[A][B] <= C) System.out.println("Enjoy other party");
			else System.out.println("Stay here");
		}
	}
}
