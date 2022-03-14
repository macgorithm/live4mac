package Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14889_스타트와링크_경혜안 {
	static int depth, N, score;
	static int[][] ability;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		
		// 깊이를 나타내는 변수 
		depth = N/2;
		// 능력치를 저장할 배열 
		ability = new int[N][N];
		// 차이의 최솟값을 저장할 배열 
		score = Integer.MAX_VALUE;

		// 능력치 입력 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 팀구분을 하기 위한 변수 
		boolean[] visited = new boolean[N];
		
		// 팀 나누는 함수 (팀 구분을 위한 변수, 깊이, 시작위치)
		divide(visited, 0, 0);
		
		System.out.println(score);
	}
	
	
	static void divide(boolean[] visited, int d, int s) {
		if(d == depth) { // 깊이가 N/2이면 기저 조건 완료 
			calc(visited); // 팀별 능력치 계산 함수 
			return;
		}
		
		for (int i = s; i < N; i++) { // 시작위치부터 N까지 돌며 
			if(!visited[i]) { // 팀 구분이 안되어있다면 
				visited[i] = true; // 팀 구분 (true -> A)
				divide(visited, d+1, i+1); // 깊이+1, 시작위치 +1 로 재귀 
				visited[i] = false; // 팀 초기화 
			}
		}
	}
	
	static void calc(boolean[] visited) {
		int teamA = 0, teamB = 0; // 각 팀의 능력치 계산 변수 
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) { // N 번씩 반복하며 
				if(visited[i] && visited[j]) { // 둘다 true 일 경우 (같은 A팀일 경우) 
					teamA += ability[i][j] + ability[j][i]; // 능력치 계산 
				} else if (!visited[i] && !visited[j]) { // 둘다 false일 경우 (같은 B팀일 경우) 
					teamB += ability[i][j] + ability[j][i]; // 능력치 계산 
				}
			}
		}
		
		score = Math.min(score, Math.abs(teamA-teamB)); // 최저 차이값 찾기 
	}

}
