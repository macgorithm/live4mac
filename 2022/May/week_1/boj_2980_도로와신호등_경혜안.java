package May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2980_도로와신호등_경혜안 {
	static class Sign {
		int d;
		int r;
		int g;
		
		public Sign(int d, int r, int g) {
			this.d = d;
			this.r = r;
			this.g = g;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n, l, d, r, g;
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		Sign[] signs = new Sign[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			d = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			signs[i] = new Sign(d, r, g);
		}
		
		int dist = 0; 
		int total = 0; 
		
		for (int i = 0; i < n; i++) {
			d = signs[i].d;
			r = signs[i].r;
			g = signs[i].g;
			
			total += (d - dist);
			dist += (d - dist);
			
			int mod = total % (r+g);
			
			if(mod < r) total += (r - mod);
			
		}
		total += (l - dist);
		System.out.println(total);

	}

}
