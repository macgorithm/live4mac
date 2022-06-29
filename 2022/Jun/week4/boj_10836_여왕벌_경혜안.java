package Jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_10836_여왕벌_경혜안 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
		
		int[] growth = new int[m*2 -1 ];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int idx = Integer.parseInt(st.nextToken());
			
			for (int j = 1; j <= 2; j++) {
				int cnt = Integer.parseInt(st.nextToken());
				
				for (int k = 0; k < cnt; k++) {
					growth[idx++] += j;
				}
			}
		}
		
		for (int i = m-1; i >= 0; i--) {
			bw.append(growth[i]+1 + " ");
			for (int j = m; j < m*2-1; j++) {
				bw.append(growth[j] + 1 + " ");
			}
			bw.append("\n");
		}
		
		bw.flush();
		

	}
	

}
