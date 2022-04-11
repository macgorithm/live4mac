package Dec_2021.week2;

import java.io.*;
import java.util.*;

public class Main_BJ_14499_주사위굴리기 {
	
	static int N, M, x, y, K;
	static int[][] map;
	
	static int[] dice;
	static int[][] d1 = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int[][] d2 = {{}, {0, 2, 3, 5, 4, 1}, {0, 5, 1, 2, 4, 3}, {5, 1, 0, 3, 2, 4}, {2, 1, 4, 3, 5, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
		M = Integer.parseInt(st.nextToken()); // 지도의 가로 크기
		map = new int[N][M];
		dice = new int[] {0, 0, 0, 0, 0, 0};
		
		x = Integer.parseInt(st.nextToken()); // 주사위의 좌표 (열)
		y = Integer.parseInt(st.nextToken()); // 주사위의 좌표 (행)
		K = Integer.parseInt(st.nextToken()); // 명령의 개수
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) map[n][m] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int k = 0; k < K; k++) {
			int move = Integer.parseInt(st.nextToken());
			
			int moveX = x+d1[move][0];
			int moveY = y+d1[move][1];
			if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= M) continue; // 바깥으로 이동하려는 경우, 명령 무시
			
			x = moveX;
			y = moveY;
			
			int[] tmp = dice.clone();
			for(int i = 0; i < 6; i++)
				dice[i] = tmp[d2[move][i]]; // 주사위 이동
			
			if(map[x][y] == 0) map[x][y] = dice[2];
			else {
				dice[2] = map[x][y];
				map[x][y] = 0;
			}
			
			System.out.println(dice[5]);
		}
	}
}