package Mar_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16234_인구이동 {
	
	static int N,L,R;
	static int [][] world;
	static boolean isVisited[][];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1}; //상좌하우 
	static Queue<Point> que;
	static List<Point> group;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken()); //땅의 크기 
		L = Integer.parseInt(st.nextToken()); //인구차이가 L명 이상 
		R =Integer.parseInt(st.nextToken()); //인구차이가 R명 이하 
		
		world = new int[N][N];
		group = new LinkedList<>();
		que = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				world[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(move());
	}
	
	private static int move() {
		int cnt =0; //인구 이동 발생수
		boolean isMove=false;
		
		//인구이동이 발생하지 않을 때까지 연합국 확인 
		while(true) {
			isVisited = new boolean[N][N];
			isMove=false;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 이미 확인한 나라는 pass
					if(isVisited[r][c]) continue;
					// 연합국 확인하기 
					if(open(r,c)) isMove=true;
				}
			}
			//연합국이 존재한다면 인구 이동 
			if(isMove) cnt++;
			else return cnt;
		}
	}

	private static boolean open(int r, int c) {
		que.clear();
		group.clear();
		
		que.add(new Point(r,c));
		group.add(new Point(r,c));
		isVisited[r][c]=true;
		
		int sum = world[r][c];
		
		//연합국 방문 
		while(!que.isEmpty()) {
			Point now = que.poll();
			
            for (int d = 0; d < 4; d++) {
                int rr = now.r + dr[d];
                int cc = now.c + dc[d];
                // 범위를 초과하거나 이미 방문한 국가 pass
                if(rr < 0 || cc < 0 || rr >= N || cc >= N || isVisited[rr][cc]) continue;
                // 두 나라의 인구 차이가 L명 이상, R명 이하가 아니라면 pass
                int diff = Math.abs(world[now.r][now.c] - world[rr][cc]);
                if(diff < L || diff > R) continue;
                
                // 연합국에 포함되는 국가일 경우 
                sum += world[rr][cc]; //인구수 누적 
                que.add(new Point(rr, cc)); //큐에 추가 
                group.add(new Point(rr, cc)); //현재 연합에 속한 list에 추가 
                isVisited[rr][cc] = true; //방문 처리 
            	}
			}
            
			//연합국이 존재하지 않는다면 
            if(group.size()==1) return false;
            else {
            	//(연합의 인구수)/(연합을 이루고 있는 칸의 개수)
            	int temp = sum/group.size();
            	
            	for (Point p : group) {
					world[p.r][p.c]=temp;
				}
            	
            	return true;
            }

		}

	static class Point {
		int r,c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
