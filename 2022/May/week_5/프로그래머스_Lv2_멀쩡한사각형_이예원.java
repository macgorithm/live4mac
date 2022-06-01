package May_5;

import java.math.BigInteger;

public class 프로그래머스_Lv2_멀쩡한사각형_이예원 {

	static long solution(int w, int h) {
		int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
		//전체크기 - (한 패턴 직사각형 당 사용하지 못하는 정사각형의 크기 * 반복횟수)
		return (long)w*h - (((w/gcd) + (h/gcd) -1) * gcd);
	}
	
//	static int gcd(int a, int b) {
//		if(b==0) return a;
//		return gcd(a,a%b);
//	}
	
	public static void main(String[] args) {
		System.out.println(solution(8,12));
//		System.out.println(solution(12,8));
//		System.out.println(solution(6,9));
	}

}
