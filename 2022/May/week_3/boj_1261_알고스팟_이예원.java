package May_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    int x;
    int y;
    int cnt; // 벽을 부순 개수
 
    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
 
    @Override
    public int compareTo(Point o) {
        return cnt - o.cnt;
    }
}


public class boj_1261_알고스팟_이예원 {

	static int N,M;
	static int[][] map;
	
	static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j]=str.charAt(j-1)-'0';
			}
		}
		
		int ans = BFS(1,1);
		
		System.out.println(ans);
	}


	static int BFS(int x, int y) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		pq.offer(new Point(x,y,0));
		boolean[][] isVisited = new boolean[N + 1][M + 1];
		isVisited[x][y] = true;
		
		
		int nx,ny;
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			//도착점에 도착하면 종료 
			if(cur.x==N && cur.y==M) {
				return cur.cnt;
			}
			
			for (int d = 0; d < 4; d++) {
				nx = cur.x+dx[d];
				ny = cur.y+dy[d];
				
                if (nx < 1 || ny < 1 || nx > N || ny > M) {
                    continue;
                }
 
                if (!isVisited[nx][ny] && map[nx][ny] == 0) {
                	isVisited[nx][ny] = true;
                    pq.offer(new Point(nx, ny, cur.cnt));
                }
 
                if (!isVisited[nx][ny] && map[nx][ny] == 1) {
                	isVisited[nx][ny] = true;
                	pq.offer(new Point(nx, ny, cur.cnt + 1));
                }
			}
		}	
		return 0;
	}

}
