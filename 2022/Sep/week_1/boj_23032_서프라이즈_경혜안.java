import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] ans = new int[2];
	static boolean[][] check ;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		
		ans[0] = Integer.MAX_VALUE;
		ans[1] = Integer.MIN_VALUE;
		check = new boolean[N+1][N+1];
		
		int[] sum = new int[N+1];
		
		int total = 0;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			total += num;
			sum[i] = total;
		}
		
		
		selectLine(1, N, sum, N);

		
		bw.write(String.valueOf(ans[1]));
		bw.flush();
	}
	
	public static void selectLine(int s, int e, int[] sum, int N) {
		if(s < 1 || e > N || s == e) return;
		
		
		if(check[s][e]) return;
		check[s][e] = true;
		splitTeam(s, e, sum);
		selectLine(s+1, e, sum, N);
		selectLine(s, e-1, sum, N);
		
		
	}
	
	public static void splitTeam(int s, int e,int[] sum) {
		
		for (int i = 1; i < (e-s+1); i++) {
			
			int A = sum[s+i-1] - sum[s-1] ;
			int B = sum[e] - sum[s-1] - A;
			int E = Math.abs(A - B);

			if(ans[0] > E || (ans[0] == E && ans[1] < A+B)) ans = new int[]{E, A+B};
			
			
			
		}
	}
	
	

}
