package Jun_2022.week4;

import java.io.*;

public class boj_1003_피보나치함수_손수연 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] DP = new int[41][2];
            
            DP[0][0] = DP[1][1] = 1;
            
            for(int k = 2; k <= N; k++){
                DP[k][0] = DP[k-1][0] + DP[k-2][0];
                DP[k][1] = DP[k-1][1] + DP[k-2][1];
            }
            
            System.out.println(DP[N][0] + " " + DP[N][1]);
        }
    }
}
