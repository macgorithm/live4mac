package Jul_1;

import java.util.Stack;

public class 프로그래머스_Lv2_괄호변환_이예원 {

	public static void main(String[] args) {
		
		String p = "()))((()";
		solution(p);
	}

	 public static String solution(String p) {

		String answer = dfs(p);
		System.out.println(answer);
		
		return answer;		
	}

	 static String dfs(String str) {
		int cnt = 0;
		int idx = 0;
		int len = str.length();
		String res = "";
		
		//1
		if(str.equals("")) return str;
		
		while(idx<len) {
			char c = str.charAt(idx++);
			
			if(c=='(') cnt++;
			else cnt--;
			
			if(cnt==0) break;
		}
		
		//2
		String u = str.substring(0,idx);
		String v = str.substring(idx,len);
		
		//3
		if(isComplete(u)) {
			res = u + dfs(v);
		}
		else {
			res = "(" + dfs(v) + ")";
			int ulen = u.length();
			
			for (int i = 1; i < ulen-1; i++) {
				
				char c = u.charAt(i);
				if(c=='(') {
					res +=')';
				}else {
					res+='(';
				}
			}
			
		}
		return res;
	}

	 static boolean isComplete(String str) {
		Stack<Character> stack = new Stack<>();
		
		int len = str.length();
		
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if(c=='(') {
				stack.add(c);

			}else {
				if(stack.isEmpty()) return false;
				else stack.pop();
			}
		}
		return stack.isEmpty();
	}

}
