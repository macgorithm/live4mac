package Feb_2022;

import java.util.*;
import java.io.*;

public class Main_BJ_17780_새로운게임 {
	
	static class ChessMan {
		int row, column, direction; // 행, 열, 이동방향
		boolean playing; // 움직일 수 있는 말인지의 여부
		ChessMan(int row, int column, int direction, boolean playing){
			this.row = row;
			this.column = column;
			this.direction = direction;
			this.playing = playing; 
		}
	}
	
	static int[][] D = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 1:우, 2:좌, 3:상, 4:하
	
	static int N, K, turn;
	static int[][] map;
	static ArrayList<Integer>[][] checkMap;
	static ChessMan[] chessMans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 체스판의 크기
		K = Integer.parseInt(st.nextToken()); // 말의 개수
		
		map = new int[N+1][N+1]; // 체스판
		checkMap = new ArrayList[N+1][N+1]; // 체스말을 표시한 체스판
		
		for(int n1 = 1; n1 <= N; n1++) {
			st = new StringTokenizer(br.readLine());
			for(int n2 = 1; n2 <= N; n2++) {
				map[n1][n2] = Integer.parseInt(st.nextToken()); // 0:흰색, 1:빨간색, 2:파란색
				checkMap[n1][n2] = new ArrayList<Integer>();
			}
		}
		
		chessMans = new ChessMan[K+1]; // 체스말들의 정보
		
		for(int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			
			chessMans[k] = new ChessMan(row, column, direction, true);
			checkMap[row][column].add(k); // 체스판에 말 표시
		}
		
		turn = 1; // 턴 수
		
		loop: while(true) {
			for(int k = 1; k <= K; k++) {
				if(!chessMans[k].playing) continue; // 움직일 수 있는 말이 아닌 경우
				else checkColor(chessMans[k], false); // 움직일 수 있는 말인 경우
				
				if(checkMap[chessMans[k].row][chessMans[k].column].size() >= 4) break loop;
			}
			
			if(turn > 1000) break; // turn 값이 1000을 초과한 경우, 게임 종료
			
			turn++;
		}
		
		System.out.println(turn > 1000 ? -1 : turn);
	}
	
	
	public static void checkColor(ChessMan cur, boolean beforeBlue) {
		int nextRow = cur.row + D[cur.direction][0]; // 이동하려는 위치(행)
		int nextColumn = cur.column + D[cur.direction][1]; // 이동하려는 위치(열)
				
		if(nextRow < 1 || nextRow > N || nextColumn < 1 || nextColumn > N || map[nextRow][nextColumn] == 2) isBlue(cur, beforeBlue); // 체스판을 벗어나거나 이동하려는 칸이 파란색인 경우
		else if(map[nextRow][nextColumn] == 0) isWhite(cur, cur.row, cur.column, nextRow, nextColumn); // 이동하려는 칸이 흰 색인 경우
		else if(map[nextRow][nextColumn] == 1) isRed(cur, cur.row, cur.column, nextRow, nextColumn); // 이동하려는 칸이 빨간색인 경우
	}
	
	
	public static void isWhite(ChessMan cur, int curRow, int curColumn, int nextRow, int nextColumn) {
		if(checkMap[nextRow][nextColumn].size() != 0)// 이동하려는 칸에 이미 체스말이 있는 경우
			cur.playing = false;
		
		checkMap[nextRow][nextColumn].addAll(checkMap[curRow][curColumn]); // (이동 후)checkMap 갱신 (체스말 쌓기)
		
		cur.row = nextRow; // 현재 체스말의 위치(행) 갱신
		cur.column = nextColumn; // 현재 체스말의 위치(열) 갱신
		checkMap[curRow][curColumn] = new ArrayList<Integer>(); // (이동 전)checkMap 갱신 (초기화)
	}
	
	
	public static void isRed(ChessMan cur, int curRow, int curColumn, int nextRow, int nextColumn) {
		Collections.reverse(checkMap[curRow][curColumn]); // 순서 뒤집기
		
		if(checkMap[nextRow][nextColumn].size() == 0) { // 이동하려는 칸에 말이 없는 경우
			int nextNo = checkMap[curRow][curColumn].get(0); // (뒤집은 후) 맨 아래 있는 체스말
			
			chessMans[nextNo] = new ChessMan(nextRow, nextColumn, chessMans[nextNo].direction, true); // nextNo번 체스말 정보 갱신
		}
		
		checkMap[nextRow][nextColumn].addAll(checkMap[curRow][curColumn]);
		
		cur.row = nextRow;
		cur.column = nextColumn;
		cur.playing = false;
		checkMap[curRow][curColumn] = new ArrayList<Integer>();
	}
	
	
	public static void isBlue(ChessMan cur, boolean beforeBlue) {
		int direction = cur.direction%2==0 ? cur.direction-1 : cur.direction+1; // 방향 전환
		cur.direction = direction;
		
		if(beforeBlue) // 이전에 파란색이었던 경우
			return; 
		else if(cur.row+D[direction][0] < 1 || cur.row+D[direction][0] > N || cur.row+D[direction][1] < 1 || cur.row+D[direction][1] > N) // 체스판을 벗어나는 경우
			checkColor(cur, false);
		else // 이동하려는 칸이 파란색일 경우
			checkColor(cur, true);
	}
}