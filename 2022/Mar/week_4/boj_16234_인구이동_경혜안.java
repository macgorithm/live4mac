package Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16234_인구이동_경혜안 {
	static int N, L, R;
	static int[][] country;
	static boolean isStop;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		country = new int[N][N];
		
		// 나라 별 인구 입력 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while(true) {
			isStop = true;
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) BFS(i, j, visited);
				}
			}
			
			if(isStop) break;
			cnt++;
		}
		System.out.println(cnt);
	}
	
	static void BFS(int x, int y, boolean[][] visited) {
		ArrayList<int[]> change = new ArrayList<int[]>();
		int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {x, y});
		
		
		visited[x][y] = true;
		int popul = 0; 
		int cnt = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			popul += country[cur[0]][cur[1]];
			cnt++;
			change.add(cur);
			for (int i = 0; i < 4; i++) {
				int posX = cur[0] + dx[i];
				int posY = cur[1] + dy[i];
				
				if(isValid(posX, posY) && !visited[posX][posY] 
						&& isRange(Math.abs(country[cur[0]][cur[1]] - country[posX][posY]))) {
					visited[posX][posY] = true;
					queue.offer(new int[] {posX, posY});
				}
			}
		}
		
		if(cnt > 1) {
			move(change, popul, cnt);
			isStop = false;
		}
		
	}
	
	static boolean isValid(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < N) return true;
		return false;
	}
	
	static boolean isRange(int p) {
		if(p >= L && p <= R) return true;
		return false;
	}
	
	static void move(ArrayList<int[]> change, int popul, int cnt) {
		
		int newPopul = popul / cnt;
		
		for (int[] is : change) {
			country[is[0]][is[1]] = newPopul;
		}
	}

}
