package Jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_1003_피보나치함수_경혜안 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());
			
			int[][] dp = new int[n+1][2];
			
			dp[0][0] = 1;
			if(n > 0) {
				dp[1][1] = 1;
			}
			
			if(n > 1) {
				dp[2][0] = 1;
				dp[2][1] = 1;
			}
			
			makeDP(dp, n);
			
			bw.write(dp[n][0] + " " + dp[n][1] + "\n");
		}
		bw.flush();
		

	}
	
	static void makeDP(int[][] dp, int n ) {
		
		
		for (int i = 3; i <= n; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
	}

}
