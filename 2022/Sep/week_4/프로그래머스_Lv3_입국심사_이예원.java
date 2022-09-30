package Sep_4;

import java.util.Arrays;

public class 프로그래머스_Lv3_입국심사_이예원 {

	public static void main(String[] args) {
		int n = 6;
		int [] times = {7,10};
		
		long answer = 0;
		
		Arrays.sort(times);
		
		long start = 0;
		long end= (long)n*times[times.length-1];
		
		while(start <= end) {
			long mid = (start+end)/2;
			long sum = 0;
			
			for (int i = 0; i < times.length; i++) {
				sum += mid/times[i];
			}
			
			if(sum < n) {
				start = mid+1;
			}else {
				end = mid-1;
				answer = mid;
			}
		}

//		return answer;
		System.out.println(answer);
	}

}
