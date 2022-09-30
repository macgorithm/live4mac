package Sep_4;

import java.util.HashSet;

public class 프로그래머스_Lv2_소수찾기_이예원 {

	static HashSet<Integer> set = new HashSet<Integer>();
	static boolean[] check;
	
	public static void main(String[] args) {
		String numbers = "011";
		int answer = 0;
		
		check = new boolean[numbers.length()];
		
		recursion("", 0, numbers);
		
		answer = set.size();
		
//		return answer;
		System.out.println(answer);

	}

	public static void recursion(String str, int idx, String numbers) {
		if(str != "") {
			int num = Integer.parseInt(str);
			if(isPrime(num)) set.add(num); 
		}
		
		if(idx==numbers.length()) return;
		
		for (int i = 0; i < numbers.length(); i++) {
			if(check[i]) continue;
			check[i]=true;
			
			recursion(str+numbers.charAt(i), idx+1, numbers);
			check[i]=false;
		}

	}

	public static boolean isPrime(int num) {
		if(num== 0 || num==1) return false;
		
		for (int i = 2; i*i <= num; i++) {
			if(num%i==0) return false;
		}
		
		return true;
	}

}
