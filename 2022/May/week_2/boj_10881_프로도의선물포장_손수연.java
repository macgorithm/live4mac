package May_2022.week1;

import java.util.*;
import java.io.*;

public class Main_BJ_10881_프로도의선물포장 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int[][] papers = new int[6][2];
			int min = Integer.MAX_VALUE;
			
			for(int n = 0; n < 3; n++) {
				st = new StringTokenizer(br.readLine());
				papers[n] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
				papers[n+3] = new int[] {papers[n][1], papers[n][0]}; // n번째 포장지를 너비, 높이만 바꿔서 n+3번째에 저장
			}
			
			min = Math.min(one(papers), min);
			min = Math.min(two(papers), min);
			
			System.out.println(min);
		}
	}
	
	public static int one(int[][] papers) { // ㅁㅁㅁ
		int min = Integer.MAX_VALUE;
		
		for(int n1 = 0; n1 < 6; n1++) {
			for(int n2 = 0; n2 < 6; n2++) {
				if(Math.abs(n1-n2)%3 == 0) continue; // 같은 포장지인 경우
				for(int n3 = 0; n3 < 6; n3++) {
					if(Math.abs(n1-n3)%3 == 0 || Math.abs(n2-n3)%3 == 0) continue; // 같은 포장지인 경우
					int maxH = Math.max(Math.max(papers[n1][0], papers[n2][0]), papers[n3][0]);
					int sumW = papers[n1][1] + papers[n2][1] + papers[n3][1];
					min = Math.min(maxH*sumW, min);
				}
			}
		}
		
		return min;
	}
	
	public static int two(int[][] papers) { // ㅁ믐
		int min = Integer.MAX_VALUE;
		
		for(int n1 = 0; n1 < 6; n1++) {
			for(int n2 = 0; n2 < 6; n2++) {
				if(Math.abs(n1-n2)%3 == 0) continue; // 같은 포장지인 경우
				for(int n3 = 0; n3 < 6; n3++) {
					if(Math.abs(n1-n3)%3 == 0 || Math.abs(n2-n3)%3 == 0) continue; // 같은 포장지인 경우
					int maxH = Math.max(papers[n1][0], papers[n2][0]+papers[n3][0]);
					int sumW = papers[n1][1] + Math.max(papers[n2][1], papers[n3][1]);
					min = Math.min(maxH*sumW, min);
				}
			}
		}
		
		return min;
	}
}
