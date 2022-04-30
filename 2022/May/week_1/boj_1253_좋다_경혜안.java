package May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1253_좋다_경혜안 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[] nums = new int[n];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		int cnt = 0;
		for (int i = 0; i < n ; i++) {
			int sum = nums[i];
			
			int s = 0, e = n-1;
			
			while(s < e) {
				if(nums[s] + nums[e] > sum) e--;
				else if (nums[s] + nums[e] < sum) s++;
				else {
					if(s != i && e != i) {
						cnt++;
						break;
					} else if(s == i) s++;
					else if (e == i) e--;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
// 0 0 0 1 1
}
