package May_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2980_도로와신호등_이예원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); //신호등의 개수
		int L = Integer.parseInt(st.nextToken()); //도로의 길이 
		
		Pair[] set = new Pair[L+1];
		
		for (int i = 0; i < N; i++) {		
			st = new StringTokenizer(br.readLine()," ");
			
			int D = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			
			set[D]= new Pair(R,G);
		}
		
		int time = 0;
		int cur = 0;
		
		while(cur<L) {
			++time;
			++cur;
			
			//신호등이 있으면 
			if(set[cur] != null) {
				int signal = time %(set[cur].r + set[cur].g);
				
				if(signal <= set[cur].r) {
					time += (set[cur].r - signal);
				}
			}
		}
		System.out.println(time);
	}
	
	static class Pair{
		int r;
		int g;
		
		public Pair(int r, int g) {
			this.r = r;
			this.g = g;
		}
	}

}
