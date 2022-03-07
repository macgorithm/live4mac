package Mar_2;

import java.util.Scanner;

public class programmers_문자열압축_이예원 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int ans = input.length(); // 압축하기 전 문자열의 길이로 초기화
		
		for (int i = 1; i <= input.length()/2; i++) { //자르는 단위 개수
			int lv = 1; //압축되는 정도
			String zipInput = input.substring(0,i); //압축할 문자 
			StringBuilder sb = new StringBuilder();

			for (int j =i; j <= input.length(); j+=i) {
				//다음 문자 
				String next = input.substring(j,j+i>input.length()?input.length(): i + j);
				//다음 문자와 현재 문자가 같으면 lv ++
				if(zipInput.equals(next)) lv++;
				//다르면
				else {
					//압축이 안됐으면 공백을, 압축이 되었으면 압축된 단어만큼 lv 붙여줌 
					sb.append((lv !=1 ? lv : "")+zipInput);
					zipInput = next; //다음 문자를 압축할 문자로 지정
					lv=1; // 압축되는 단어 정도를 다시 1로 초기화 
				}
			}
			sb.append(zipInput);
			ans = Math.min(ans, sb.length());
			
		}		
		System.out.println(ans);
	}

}
