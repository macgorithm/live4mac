package May;

import java.util.Stack;

public class 프로그래머스_lv3_표편집_경혜안 {
	static Stack<Integer> trash = new Stack<Integer>();
	static int size;
	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		StringBuilder sb = new StringBuilder();
		size = n;
		for (String order : cmd) {
			String[] temp = order.split(" ");
			
			switch(temp[0]) {
			case "U" : 
				k = Up(Integer.parseInt(temp[1]), k);
				break;
			case "D" :
				k = Down(Integer.parseInt(temp[1]), k);
				break;
			case "C" :
				k = cancel(k,n);
				break;
			case "Z" :
				k = cntrZ(k);
				break;
			}
		}
		
		for (int i = 0; i < size; i++) {
			sb.append("O");
		}
		
		while(!trash.isEmpty()) {
			sb.insert(trash.pop(), "X");
		}
		
		System.out.println(sb.toString());
	}
	
	static int Up(int m, int k) {
		return k-m;
	}
	
	static int Down(int m, int k) {
		return k+m;
	}
	
	static int cancel( int k, int n) {
		trash.push(k);
		size--;
		if(size == k) k--;
		return k;
	}
	
	static int cntrZ(int k) {
		int num = trash.pop();
		
		size++;
		if(k >= num) k++;
		return k;
		
	
	}

}
