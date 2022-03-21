package Mar_2022.week3;

import java.io.*;
import java.util.*;

public class boj_16234_인구이동 {
	
	static int[][] D = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	static int N, L, R, time;
	static int[][] map;
	static boolean[][] checked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 땅 크기
		L = Integer.parseInt(st.nextToken()); // 이상
		R = Integer.parseInt(st.nextToken()); // 이하
		time = 0;
		
		map = new int[N][N]; // 인구 수
		
		for(int n1 = 0; n1 < N; n1++) {
			st = new StringTokenizer(br.readLine());
			
			for(int n2 = 0; n2 < N; n2++) map[n1][n2] = Integer.parseInt(st.nextToken());
		}
		
		boolean flag; // 연합의 유무
		
		do {
			checked = new boolean[N][N];
			flag = false;
			
			for(int n1 = 0; n1 < N; n1++) {
				for(int n2 = 0; n2 < N; n2++) {
					if(!checked[n1][n2] && bfs(n1, n2)) flag = true;
				}
			}
			
			if(flag) time++;
		} while(flag); // 연합이 있었을 경우
		
		System.out.println(time);
	}
	
	public static boolean bfs(int row, int column) {
		Queue<int[]> queue = new LinkedList<>();
		ArrayList<int[]> list = new ArrayList<>(); // 연합인 나라들의 위치
		int num = 1; // 연합의 나라 수
		int sum = map[row][column]; // 연합의 인구 수
		
		queue.offer(new int[] {row, column});
		checked[row][column] = true;
		list.add(new int[] {row, column});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int[] next = new int[] {cur[0]+D[d][0], cur[1]+D[d][1]};
				
				if(next[0]<0 || next[0]>=N || next[1]<0 || next[1]>=N || checked[next[0]][next[1]]) continue;
				
				int diff = Math.abs(map[cur[0]][cur[1]]-map[next[0]][next[1]]); // 인접한 지역의 인구 차
				if(L <= diff && R >= diff) { // L이상, R이상인 경우
					queue.offer(new int[] {next[0], next[1]});
					checked[next[0]][next[1]] = true;
					list.add(new int[] {next[0], next[1]});
					
					num++;
					sum += map[next[0]][next[1]];
				}
			}
		}
		
		for(int[] l : list) map[l[0]][l[1]] = sum / num; // 인구 이동
		
		if(num == 1) return false; // 연합이 없는 경우
		else return true; // 연합이 있는 경우
	}
}
