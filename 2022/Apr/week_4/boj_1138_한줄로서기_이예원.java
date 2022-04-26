package Apr_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1138_한줄로서기_이예원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] talls = new int[N+1];
		
		List<Integer> list = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			talls[i]=Integer.parseInt(st.nextToken());
		}

		for (int i = N; i >=1; i--) {
			list.add(talls[i],i);
		}
		
		for (int num : list) {
			System.out.print(num+" ");
		}
	}

}
