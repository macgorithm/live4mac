package Agust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_21608_상어초등학교_경혜안 {
	static int[][] classRoom;
	static int N;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		
		classRoom = new int[N][N];
		
		int[][] points = new int[(N*N) + 1][4];
		for (int i = 0; i < N*N; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int student = Integer.parseInt(st.nextToken());
			int f1 , f2, f3, f4;
			
			f1 = Integer.parseInt(st.nextToken());
			f2 = Integer.parseInt(st.nextToken());
			f3 = Integer.parseInt(st.nextToken());
			f4 = Integer.parseInt(st.nextToken());
			
			points[student] = new int[] {f1, f2, f3, f4};
			ArrayList<int[]> ans = condition1(f1, f2, f3, f4);
			
			if(ans.size() == 1) {
				classRoom[ans.get(0)[0]][ans.get(0)[1]] = student;
				continue;
			} 

			ans = condition2(ans);
			
			if(ans.size() == 1) {
				classRoom[ans.get(0)[0]][ans.get(0)[1]] = student;
				continue;
			}
			
			Collections.sort(ans, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0] == o2[0]) return o1[1] - o2[1];
					return o1[0] - o2[0];
				}
				
			});

			classRoom[ans.get(0)[0]][ans.get(0)[1]] = student;
			
					
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += sum(i, j, points[classRoom[i][j]]);
			}

		}
		
		System.out.println(sum);

	}
	public static boolean isValid(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < N) return true;
		return false;
	}
	
	public static ArrayList<int[]> condition1(int f1, int f2, int f3, int f4) {
		int max = 0;
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(temp[i], -1);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(classRoom[i][j] != 0) continue;
				int cnt = 0;
				for (int l = 0; l < 4; l++) {
					int x = i + dx[l];
					int y = j + dy[l];
					if(isValid(x, y)) { // 비어있는 칸이고, 인접한 곳에 접근가능하다면 
						if(classRoom[x][y] == f1 || classRoom[x][y] == f2 || classRoom[x][y] == f3 || classRoom[x][y] == f4) cnt++;
					}
				}
				temp[i][j] = cnt;
				max = Math.max(max, cnt);
			}
		}
		
		ArrayList<int[]> tmp = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(temp[i][j] == max) {
					tmp.add(new int[] {i, j});
				}
			}
		}
		
		return tmp;
		
	}
	
	public static ArrayList<int[]> condition2(ArrayList<int[]> near) {
		ArrayList<int[]> tmp = new ArrayList<int[]>();
		int max = 0;
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(temp[i], -1);
		}
		for (int[] seat : near) {
			if(classRoom[seat[0]][seat[1]] != 0) continue;
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int x = seat[0] + dx[i];
				int y = seat[1] + dy[i];
				
				if(isValid(x, y) && classRoom[x][y] == 0) cnt++;
			}
			temp[seat[0]][seat[1]] = cnt;
			max = Math.max(max, cnt);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(temp[i][j] == max) tmp.add(new int[] {i, j});
			}
		}
		
		return tmp;
		
	}
	
	public static int sum(int i, int j, int[] p) {
		
		int[] score = {0, 1, 10, 100, 1000};
		int cnt = 0;
		
				
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
					
			if(isValid(x, y) && (classRoom[x][y] == p[0] || classRoom[x][y] == p[1] || classRoom[x][y] == p[2] || classRoom[x][y] == p[3])) cnt++;
		}
	
		
		return score[cnt];
	}
	

}
/*

3
1 2 3 4 5
2 1 3 4 5
3 1 2 4 5
4 1 2 3 5
5 1 2 3 4
6 1 2 3 4
7 1 2 3 4
8 1 2 3 4
9 1 2 3 4
*/