package Jun_2022.week2;

import java.io.*;

public class Main_BJ_1254_팰린드롬만들기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer input = new StringBuffer(br.readLine());
		
		for(int i = 0; i < input.length(); i++) {
			if(input.toString().equals(input.reverse().toString()))
				break;
			
			input.reverse();
			input.insert(input.length()-i, input.charAt(i));
		}
		
		System.out.println(input.length());
	}
}