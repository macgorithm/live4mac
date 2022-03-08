package Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2799_블라인드_경혜안 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = bf.readLine().split(" ");
		int M = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);
		
		// 5개 상태에 따른 갯수를 저장할 배열 
		int[] ans = new int[5];
		// 층수 변수 floor 
		int floor = -1;
		// 창문 배열 
		int[][] windows = new int[M][N];
		for (int i = 0; i < (5*M)+1; i++) {
			char[] temp = bf.readLine().toCharArray();
			// 5로 나누어지면 넘어감 => 창틀일 경우 넘어감 + 층 수 증가 
			if(i % 5 == 0 ) {
				floor++;
				continue;
			}
			
			// N개의 창문을 돌며 
			for (int j = 0; j < N; j++) {
				// 각 창문의 첫번째 문자열만 확인하며 블라인드가 쳐져있으면 블라인드 칸 갯수 증가 
				if(temp[(5*j)+1] == '*') windows[floor][j]++; 
				
			}	
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				ans[windows[i][j]]++;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.print(ans[i]+" ");
		}
		
	}

}
