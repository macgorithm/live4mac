package May_2022.week2;

import java.util.Stack;

public class Solution_Programmers_81303_표편집 {

	public String solution(int n, int k, String[] cmd) {
		StringBuilder sb = new StringBuilder("");
		Stack<Integer> stack = new Stack<>();
		int size = n;
	
		for(int i = 0; i < cmd.length; i++) {
			String[] order = cmd[i].split(" ");
			
			if(order[0].equals("U")) k -= Integer.parseInt(order[1]);
			else if(order[0].equals("D")) k += Integer.parseInt(order[1]);
			else if(order[0].equals("C")) {
				stack.push(k);
				size -= 1;
				if(k == size) k -= 1;
			} else {
				if(stack.pop() <= k) k += 1;
				size += 1;
			}
		}
		
		for(int i = 0; i < size; i++) sb.append("O");
		while(!stack.isEmpty()) sb.insert(stack.pop(), "X");
		
		return sb.toString();
	}
}