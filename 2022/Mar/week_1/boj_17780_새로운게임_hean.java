package Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_17780_새로운게임_hean {
	static int[][] board; // 체스판의 색상 정보 저장 
	static ArrayList<Integer>[][] stack; // 체스판의 쌓이는 말순서 저장 
	static int N, K;
	static class Knight {
		int col, row, dir;
		
		public Knight(int row, int col, int dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
			
		} // board 판 정보 입력 
		
		ArrayList<Knight> knights = new ArrayList<Knight>(); // 말의 정보 저장 
		stack = new ArrayList[N][N];
		
		for(int i = 0; i < N; i++) {
            for(int j = 0; j< N; j++)
                stack[i][j] = new ArrayList<>();
        }
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int row = Integer.parseInt(st.nextToken())-1;
			int col = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			stack[row][col].add(i);
			knights.add(new Knight(row, col, dir));
		} // 말 정보 입력 완료 
		
		int[] dx = {0, 0, 0, -1, 1}, dy = {0, 1, -1, 0, 0}; // 방향 
		int times = 0; // 게임 종료 턴 
		int[] change = {0, 2, 1, 4, 3}; // 바뀌는 방향에 대한 정보 
		boolean flag = true;
		// 1000번이 넘지 않을 때 까지 
		while(flag) {
			times++;
			if(times > 1000) break;
			for(int i = 0 ; i < K ; i++) {
				Knight cur = knights.get(i);
				// 맨 아래 있는 말이 아니라면 
				if(stack[cur.row][cur.col].get(0) != i)  continue;
				
				// 이동할 방향의 좌표 
				int curX = cur.row + dx[cur.dir], curY = cur.col + dy[cur.dir];

				boolean valid = isValid(curX, curY); // 범위안에 있는지 확인 
				
				if(!valid || board[curX][curY] == 2) { // 범위 밖이거나, 이동칸이 파란색인 경우 
					cur.dir = change[cur.dir];
					knights.set(i, new Knight(cur.row, cur.col, cur.dir));
					int tx = cur.row + dx[cur.dir], ty = cur.col + dy[cur.dir];
					
					//방향을 바꾼 후 이동하려는 방향이 범위 안이고, 파란색이 아닐 경우 
					if(isValid(tx, ty) && board[tx][ty] != 2) {
						
						for (int j = 0; j < stack[cur.row][cur.col].size(); j++) {
							stack[tx][ty].add(stack[cur.row][cur.col].get(j));
							int idx = stack[cur.row][cur.col].get(j);
							knights.set(idx , new Knight(tx, ty, knights.get(idx).dir));
						} // 쌓여있는 모든것 이동 
						stack[cur.row][cur.col].clear(); // 빈칸으로 초기화 
						if(stack[tx][ty].size() >= 4) {
							flag = false;
							break;
						}
					}
					
				} else if(board[curX][curY] == 1) { // 빨강일 경우 
					
					for (int j = stack[cur.row][cur.col].size()-1; j >= 0; j--) {
						stack[curX][curY].add(stack[cur.row][cur.col].get(j));
						int idx = stack[cur.row][cur.col].get(j);
						knights.set(idx, new Knight(curX, curY, knights.get(idx).dir));
					}
					stack[cur.row][cur.col].clear();
					if(stack[curX][curY].size() >= 4) {
						flag = false;
						break;
					}
				} else if(board[curX][curY] == 0) { // 흰색일 경우 
					
					for (int j = 0; j < stack[cur.row][cur.col].size(); j++) {
						stack[curX][curY].add(stack[cur.row][cur.col].get(j));
						int idx = stack[cur.row][cur.col].get(j);
						knights.set(idx, new Knight(curX, curY, knights.get(idx).dir));
					} // 쌓여있는 모든것 이동 
					stack[cur.row][cur.col].clear();
					if(stack[curX][curY].size() >= 4) {
						flag = false;
						break;
					}
				}
			}
			
		}
		
		System.out.println(times > 1000 ? -1 : times);
	}
	
	static boolean isValid(int x, int y) {
		if(0 <= x && x < N && 0 <= y && y < N) return true;
		return false;
	}

}
