package Jun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110_공유기설치_경혜안 {
	static int[] arr;
	static int shortest = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n, c; 
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		Arrays.sort(arr);
		
		int start = 1, end = arr[n-1] - arr[0] + 1;
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(findMax(mid) < c) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(start - 1);
		
	}
	
	static int findMax(int dist) {
		int cnt = 1;
		
		int last = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] - last >= dist) {
				cnt++;
				last = arr[i];
			}
		}
		
		return cnt;
		
	}

}


