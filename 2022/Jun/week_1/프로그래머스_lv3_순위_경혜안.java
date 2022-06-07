package Jun;

import java.util.Arrays;

public class 프로그래머스_lv3_순위_경혜안 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int answer = 0;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		
		int[][] floyd = new int[n+1][n+1];
		
		for (int i = 0; i <= n; i++) {
			Arrays.fill(floyd[i], 9999);
		} // 초기화 
		
		for (int i = 0; i < results.length; i++) {
			floyd[results[i][0]][results[i][1]] = 1;
		} // 초기화 2 
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(floyd[i][j] > floyd[i][k] + floyd[k][j]) floyd[i][j] = floyd[i][k] + floyd[k][j];
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if(floyd[i][j] < 9999 || floyd[j][i] < 9999) {
					cnt++;
				}
			}
			
			if(cnt == n-1) answer++;
		}
		
		System.out.println(answer);
	}

}
