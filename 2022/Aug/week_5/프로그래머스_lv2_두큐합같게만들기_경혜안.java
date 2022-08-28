package Agust;


public class 프로그래머스_lv2_두큐합같게만들기_경혜안 {

	public static void main(String[] args) {
		int[] queue1 = {1, 1};
		int[] queue2 = {1, 5};
		
		int answer = -1;
		int[] total = new int[queue1.length + queue2.length];
		
		System.arraycopy(queue1, 0, total, 0, queue1.length);
		System.arraycopy(queue2, 0, total, queue1.length, queue2.length);
		
		long sum = 0;
		for (int i : total) sum += i;
		
		long mid = sum / 2;
		
		if(sum % 2 != 0) return ;
		
		long subSum = 0;
		
		for (int i : queue1) subSum += i;
		int s = 0, e = queue1.length - 1;
		
		int d = 0;
		while(s < total.length-1 && e < total.length-1 ) {
			if(subSum == mid) {
				System.out.println(d + " is answer ");
				return ;
			}
			if(subSum < mid) {
				e++;
				subSum += total[e];
			} else {
				subSum -= total[s];
				s++;
			}
			d++;
			
		}
		
		
		System.out.println(-1);
		
		
	}
	
	

}
