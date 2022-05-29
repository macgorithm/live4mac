package May_2022.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_1261_알고스팟 {
	
	static int N;
	static int M;
	static char[][] map;
	static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int[][] brokens;

	static class Point implements Comparable<Point> {
		int x, y, broken;

		public Point(int x, int y, int broken) {
			this.x = x;
			this.y = y;
			this.broken = broken;
		}

		public int compareTo(Point o) {
			return Integer.compare(this.broken, o.broken);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		brokens = new int[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(brokens[i], Integer.MAX_VALUE);
		}

		bfs();
		System.out.println(brokens[N - 1][M - 1]);
	}

	private static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.offer(new Point(0, 0, map[0][0] - '0'));
		brokens[0][0] = map[0][0] - '0';

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (brokens[cur.y][cur.x] < cur.broken) continue;

			for (int d = 0; d < 4; d++) {
				int ny = cur.y + D[d][0];
				int nx = cur.x + D[d][1];
				
				if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				
				if (brokens[ny][nx] > brokens[cur.y][cur.x] + (map[ny][nx] - '0')) {
					brokens[ny][nx] = brokens[cur.y][cur.x] + (map[ny][nx] - '0');
					pq.offer(new Point(ny, nx, brokens[ny][nx]));
				}
			}

		}
	}
}
