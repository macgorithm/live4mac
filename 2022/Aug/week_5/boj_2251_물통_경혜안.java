package Agust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj_2251_물통_경혜안 {
	static Set<Integer> answer;
	static int A, B, C;
	static int[] glass = new int[3];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		glass[0] = A;
		glass[1] = B;
		glass[2] = C;
		
		answer = new TreeSet<Integer>();
		
		boolean[][][] liter = new boolean[201][201][201];
		
		DFS(liter, 0, 0, C);
		for (int a : answer) {
			System.out.print(a + " ");
		}
		
	}
	
	static public void DFS(boolean[][][] liter, int a, int b, int c) {
		
		if(liter[a][b][c]) return;
		
		if(a == 0) answer.add(c);
		
		liter[a][b][c] = true;
		
		// A -> B 
		if(a + b > B) DFS(liter, a - (B - b), B, c);
		else DFS(liter, 0, a+b, c);
		
		// A -> C 
		if(a + c > C) DFS(liter, a - (C - c), b, C);
		else DFS(liter, 0, b, a+c);
		
		// B -> A
		if(a + b > A) DFS(liter, A, b - (A - a) , c);
		else DFS(liter, a+b, 0, c);
		
		// B -> C
		if(b + c > C) DFS(liter, a, b - (C - c), C);
		else DFS(liter, a, 0, b+c);
		
		// C -> A
		if(c + a > A) DFS(liter, A, b , c - (A - a));
		else DFS(liter, a+c, b, 0);
				
		// C -> B
		if(b + c > B) DFS(liter, a, B, c - (B - b));
		else DFS(liter, a, b + c, 0);
		
	}

}
