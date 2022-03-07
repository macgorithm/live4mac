package Mar_2022.week1;

import java.io.*;

public class programmers_문자열압축_손수연 {
	
	static String input;
	static int minLen;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();
		minLen = Integer.MAX_VALUE;
		
		for(int i = 1; i <= input.length()/2; i++) { // i:자르는 단위 개수
			String output = "";
			String before = "";
			int degree = 1; // 동일한 문자열이 반복되는 횟수
			
			for(int j = 0; j < input.length()/i; j++) { // j : offset
				String now = input.substring(i*j, i*(j+1));
				
				if(now.equals(before)) // 이전 문자열과 같은 경우
					degree++;
				else { // 이전 문자열과 다른 경우
					if(degree != 1) output += degree;
					output += before;
					degree = 1;
				}
				before = now;
			}
			
			output += degree!=1 ? degree+before: before; // 마지막 문자열
			if(input.length()%i != 0) output += input.substring(input.length()/i*i); // 문자열이 남을 경우
			minLen = Math.min(output.length(), minLen);
		}
		
		System.out.println(minLen);
	}
}
