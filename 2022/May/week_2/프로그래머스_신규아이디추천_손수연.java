package May_2022.week2;


public class Solution_Programmers_72410_신규아이디추천 {
	
	public String solution(String new_id) {
		String answer = "";
		
		answer = new_id.toLowerCase(); // 1단계: 소문자로 치환
		answer = answer.replaceAll("[^0-9a-z-_.]", ""); // 2단계: 알파벳 소문자, 숫자, -, _, .를 제외한 모든 문자 제거
		answer = answer.replaceAll("[.]{2,}", "."); // 3단계: ..를 .로 치환
		answer = answer.replaceAll("^[.]|[.]$", ""); // 4단계: .가 처음이나 끝에 위치하면 제거
		answer = answer.length()==0 ? "a" : answer; // 5단계: 빈 문자열이면 "a"를 대입
		
		if(answer.length() >= 16) { // 6단계: 길이가 16자 이상이면
			answer = answer.substring(0, 15); // 16번째 문자부터 제거
			answer = answer.replaceAll("[.]$", ""); // .가 끝에 위치하면 끝에 위치한 .를 제거
		}
		
		if(answer.length() <= 2) { // 7단계: 길이가 2자 이하이면
			char c = answer.charAt(answer.length()-1); // 마지막 문자를
			while(answer.length() < 3) { // 길이가 3이 될 때까지
				answer += c; // 반복해서 끝에 추가
			}
		}
		
		return answer;
	}
}
