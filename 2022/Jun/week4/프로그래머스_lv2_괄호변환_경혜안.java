package Jun;

import java.util.Stack;

public class 프로그래머스_lv2_괄호변환_경혜안 {
	
	public static void main(String[] args) {
		String p = "()))((()";
		
		solution(p);
		

	}

	static public String solution(String p) {
		
		
		String answer = "";
		
		
		answer += change(p);
		
		
		
		
        return answer;
    }
	
	static String change(String p) {
		String u = "";
		String v = "";
		
		if(p.length() == 0 ) return p; // 빈 문자열이면 그대로 반환 
		
		for (int i = 1; i < p.length(); i++) { // 2. u, v 분리 
			if(balanceString(p.substring(0, i+1))) {
				
				u = p.substring(0, i+1);
				v = p.substring(i+1);
				
				break;
			} 
		}
		
		if(properString(u)) { // 3
			return u + change(v);
			
		} else { // 4 
			String temp = "("; // 4-1
			temp += change(v); // 4-2
			temp += ")"; 	   // 4-3
			temp += remove(u); // 4-4
			
			return temp;
			
		}
	}
	
	static String remove(String u) { // 4-4
		String temp = u.substring(1, u.length()-1);
		
		String tmp = "";
		
		for (int i = 0; i < temp.length(); i++) {
			if(temp.charAt(i) == '(') tmp += ")";
			else tmp += "(";
		}
		return tmp;
		
	}
	static boolean balanceString(String p) { // 균형잡힌 문자열 파악 
		int left = 0, right = 0;
		
		for (char c : p.toCharArray()) {
			if(c == '(') left++;
			else right++;
		}
		
		if(left == right) return true;
		else return false;
	}
	
	static boolean properString(String p) { // 올바른 문자열 파악 
		Stack<String> st = new Stack<String>();
		
		for (int i = 0; i < p.length(); i++) {
			
			if(p.charAt(i) == '(') st.push("(");
			else {
				if(st.isEmpty()) return false;
				st.pop();
			}
		}
		
		if(st.isEmpty()) return true;
		return false;
	}
	
}
