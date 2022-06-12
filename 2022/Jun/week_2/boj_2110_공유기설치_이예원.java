package Jun_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110_공유기설치_이예원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] map = new int[N];
		
		for (int i = 0; i < N; i++) {
			map[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(map);
		
		int left = 1; //가능한 최소거리 
		int right = map[N-1]-map[0]; //가능한 최대거리
		int d = 0;
		int ans =0; 
		
		while(left<= right) {
			int mid =(left+right)/2; //기준
			int start = map[0];
			int cnt = 1;
			
			//간격을 기준으로 공유기 설치 
			for (int i = 1; i < N; i++) {
				d= map[i]-start;
				
				if(mid<=d) {
					++cnt;
					start=map[i];
				}
			}
			
			if(cnt>=C) {
				//공유기를 줄여도 되면 간격 넓혀주고 
				ans = mid;
				left = mid+1;
			}else {
				//공유기를 더 설치해야 하면 간격을 줄여줌 
				right = mid-1;
			}
			
		}
		
		System.out.println(ans);
		
	}
}
