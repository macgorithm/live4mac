package Apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11265_끝나지않는파티_경혜안 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n,m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] party = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n ; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 거리 입력 
		
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n ; i++) {
				for (int j = 1; j <= n; j++) {
					party[i][j] = Math.min(party[i][k] + party[k][j], party[i][j]);
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			if(party[from][to] <= time) System.out.println("Enjoy other party");
			else System.out.println("Stay here");
		}
		
		
	}

}
