package Aug_2022.week4;

import java.io.*;
import java.util.*;

public class Main_BJ_2251_물통 {
	
	static int A, B, C;
	static boolean[] answer;
	static boolean[][] checked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		answer = new boolean[201];
		checked = new boolean[201][201];
		
		dfs(0, 0, C);
		
		for(int i = 0; i < answer.length; i++) System.out.print(answer[i] ? i+" " : "");
	}
	
	
	public static void dfs(int volumeA, int volumeB, int volumeC) {
		if(checked[volumeA][volumeB]) return;
		
		if(volumeA == 0) answer[volumeC] = true;
		
		checked[volumeA][volumeB] = true;
		
		// A -> B
		if(volumeA+volumeB > B) dfs((volumeA+volumeB)-B, B, volumeC);
		else dfs(0, volumeA+volumeB, volumeC);
		
		// B -> A
		if(volumeB+volumeA > A) dfs(A, (volumeB+volumeA)-A, volumeC);
		else dfs(volumeB+volumeA, 0, volumeC);
		
		// C -> A
		if(volumeC+volumeA > A) dfs(A, volumeB, (volumeC+volumeA)-A);
		else dfs(volumeC+volumeA, volumeB, 0);
		
		// C -> B
		if(volumeC+volumeB > B) dfs(volumeA, B, (volumeC+volumeB)-B);
		else dfs(volumeA, volumeC+volumeB, 0);
		
		dfs(volumeA, 0, volumeB+volumeC);
		dfs(0, volumeB, volumeA+volumeC);
	}
}
