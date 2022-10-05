package Sep_2022;

import java.util.*;

public class Solution_Programmers_42839_소수찾기 {
	
	static boolean[] checked;
	static HashSet<Integer> answer;
	
	public int Solution(String numbers) {
		answer = new HashSet<Integer>();
		checked = new boolean[numbers.length()];
		
		recursion("", 0, numbers);
		
		return answer.size();
	}
	
	public void recursion(String makedNumber, int idx, String numbers){
        if(makedNumber != ""){
            int num = Integer.parseInt(makedNumber);
            if(isPrimeNumber(num)) answer.add(num); // 소수이면 set에 추가
        }
        
        if(idx == numbers.length()) return; // 체크를 마친 경우
        
        for(int i = 0; i < numbers.length(); i++){
            if(checked[i]) continue; // 이미 체크되어 있는 경우
            
            checked[i] = true;
            recursion(makedNumber+numbers.charAt(i), idx+1, numbers);
            checked[i] = false;
        }
    }
	
	public boolean isPrimeNumber(int num) {
		if(num < 2) return false;
		
		for(int i = 2; i*i <= num; i++)
			if(num % i == 0) return false;
			
		return true;
	}
}