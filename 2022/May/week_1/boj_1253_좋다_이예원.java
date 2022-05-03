package May_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1253_좋다_이예원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());;
		
		for (int i = 0; i < N; i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int cnt = 0;
		
		for (int i = 0; i <N; i++) {
			int val = nums[i];
			
			int l =0;
			int r = N-1;
			
			while(l<r) {
				if(nums[l]+nums[r]>val) r--;
				else if(nums[l]+nums[r]<val) l++;
				else {
					if(l != i && r != i) {
						cnt++;
						break;
					}else if(l==i) l++;
					else if (r==i) r--;
				}
			}
		}
		System.out.println(cnt);
		
	}
}
