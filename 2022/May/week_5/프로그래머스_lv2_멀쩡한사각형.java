package May;

public class 프로그래머스_lv2_멀쩡한사각형 {

	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		int gcd = gcd(w,h);
		
		//사각형 규칙 - 최대공약수의 갯수만큼 패턴이 반복됨 
		//직사각형 중 사용 못하는 정사각형의 갯수가 w+h에 겹치는것 1개 
		long answer = (long)w*h - ((w/gcd + h/gcd -1) * gcd);
		
		System.out.println(answer);

	}
	
	static int gcd(int a , int b) { // 최대 공약수 
		if( b == 0 ) return a; 
		return gcd(a, a % b);
	}

}
