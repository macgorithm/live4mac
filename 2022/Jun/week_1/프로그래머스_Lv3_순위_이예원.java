package Jun_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class 프로그래머스_Lv3_순위_이예원 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 5;
		int [][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		
		int answer = 0;
		int [][] graph = new int[n+1][n+1];
		
		
		for (int i = 0; i < results.length; i++) {
			graph[results[i][0]][results[i][1]]=1;
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				for (int r = 0; r <= n; r++) {
					if(graph[j][i]==1 && graph[i][r]==1) {
						graph[j][r]=1;
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			
			for (int j = 1; j <= n; j++) {
				if(graph[i][j]==1 || graph[j][i]==1) {
					cnt++;
				}
			}
			
			if(cnt==n-1) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
