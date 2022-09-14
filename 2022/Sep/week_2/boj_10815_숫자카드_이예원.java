package Sep_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10815_숫자카드_이예원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		int M = Integer.parseInt(br.readLine());
		
	    StringBuilder sb = new StringBuilder();
	    
	    st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < M; i++) {
	    	int temp = Integer.parseInt(st.nextToken());
	        sb.append(binarySearch(cards, N, temp) + " ");
	    }
	    System.out.println(sb.toString());
	}

	private static int binarySearch(int[] cards, int N, int findNum) {
		int start = 0;
		int end = N-1;
		int mid = 0;
		
		while(start<=end) {
			mid = (start+end)/2;
			
			if(cards[mid]==findNum) return 1;
			
			if(cards[mid]<findNum) {
				start = mid+1;
			}else {
				end=mid-1;
			}
		}
		return 0;
	}

}
