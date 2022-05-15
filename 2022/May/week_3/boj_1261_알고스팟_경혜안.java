package May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1261_알고스팟_경혜안 {
	static int[][] dist;
	static char[][] map;
	static int N, M;
	static boolean[][] visited;
	
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		int cnt;
		
		public Pos (int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pos o) { // 우선순위큐에서 작은순으로 정렬 
			
			return this.cnt - o.cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			map[i] = bf.readLine().toCharArray();
		} // 입력 
		
		Dijkstra();
	}
	
	static void Dijkstra() {
		int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}; //방향 
		PriorityQueue<Pos> pq = new PriorityQueue<Pos>(); // 우선순위큐 선언 
		pq.offer(new Pos(0,0,0)); 
		visited[0][0] = true; 
		while(!pq.isEmpty()) {
			Pos cur = pq.poll();
			
			if(cur.x == M-1 && cur.y == N-1) { // 끝에 왔다면 종료 
				System.out.println(cur.cnt);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				
				if(isValid(x, y) && !visited[x][y]) { // 범위 안이고, 방문전이라면 
		
					visited[x][y] = true;
					if(map[x][y] == '1') pq.add(new Pos(x,y, cur.cnt+1)); // 벽이 있으면 +1 
					else pq.add(new Pos(x,y,cur.cnt)); // 벽이 없으면 그대로 갱신 
				}
				
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		if(x >= 0 && x < M && y >= 0 && y < N) return true;
		return false;
	}

}
