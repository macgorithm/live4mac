package Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 프로그래머스_Lv2_문자열압축_경혜안 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 문자열 입력 
		String s = bf.readLine();
		// 문자열의 길이 저장 (최대 길이) 
		int len = s.length();
		
		StringBuilder str;
		// 문자열의 길이의 절반길이까지 반복 (1개씩 비교 -> 2개씩 비교... -> len/2개씩 비교)
		for (int i = 1; i <= s.length() / 2; i++) {
			str = new StringBuilder();
			//비교 문자열 
			String temp = s.substring(0, i);
			// 같은갯수 
			int cnt = 1;
			// 시작위치 초기화 
			int j = i;
			// 문자열의 길이만큼만 반복 (시작 위치 j는 비교문자 길이만큼 증가) 
			for (j = i; j <= s.length() - i ; j = j+i) {
				// temp의 글자와 같다면 
				if(temp.equals(s.substring(j, j+i))) {
					cnt++;
				} else { // 다르다면 
					if(cnt > 1) str.append(cnt);
					str.append(temp);
					cnt = 1;
					temp = s.substring(j, j+i);
				}
				
			}
			// 마지막에 비교했던것 추가 
			if(cnt > 1) str.append(cnt);
			str.append(temp);
			// 문자열을 끝까지 훑지 않았다면, 길이가 부족한 것이므로 비교가 안된 문자열들 추가 
			if(j < s.length()) {
				str.append(s.substring(j));
			} 
			
			// 짧은 길이 갱신 
			len = Math.min(len, str.length());
		}
		
		System.out.println(len);
	}

}
