package May_2;

import java.io.IOException;
import java.util.Stack;

public class 프로그래머스_Lv3_표편집_이예원 {

	public static void main(String[] args) throws IOException {		
		int n = 8;
		int k = 2;
		String [] cmd  = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		
		Stack <Integer> stack = new Stack<>();
		
		for (String str : cmd) {
			char key = str.charAt(0);
			
			switch(key) {
				case 'U':
					k -= Integer.valueOf(str.substring(2));
					break;
				case 'D' :
					k += Integer.valueOf(str.substring(2));
				case 'C':
					stack.push(k);
					n--; 
					if(k==n) k--; 
					break;
				case 'Z': 
					int val = stack.pop();
					if(val<=k) k++;
					n++; 
					break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) { 
			sb.append('O'); 
		}
		
		while(!stack.isEmpty()) {
			sb.insert(stack.pop().intValue(), 'X');
		}
		
		System.out.println(sb.toString());
	}

}
