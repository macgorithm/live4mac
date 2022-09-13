package Sep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10815_숫자카드_경혜안 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < M; i++) {
			bw.write(findNum(arr, Integer.parseInt(st.nextToken())) + " ");
		}
		
		bw.flush();

	}

	static int findNum(int[] arr, int num) {
		int start = 0, end = arr.length-1;
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(num > arr[mid]) start = mid+1;
			else if (num < arr[mid]) end = mid-1;
			else return 1;
		}
		
		return 0;
	}
}
