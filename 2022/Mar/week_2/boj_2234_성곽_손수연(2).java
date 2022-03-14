package Mar_2022.week1;

import java.io.*;
import java.util.*;

public class boj_2234_성곽_손수연(2) {
	
	static int[][] D = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; // 서, 북, 동, 남

	static int M, N, roomNum, maxArea, removeMaxArea;
	static int[][] castle, roomNo;
	
	static ArrayList<int[]> roomInfo;
	static boolean[][] checked;

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 성곽의 크기(가로)
		M = Integer.parseInt(st.nextToken()); // 성곽의 크기(세로)
		
		castle = new int[M][N]; // 성곽에 대한 정보
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++)
				castle[m][n] = Integer.parseInt(st.nextToken()); // +1:서쪽 벽, +2:북쪽 벽, +4:동쪽 벽, +8:남쪽 벽
		}
		
		roomNum = maxArea = removeMaxArea = 0;
		roomNo = new int[M][N]; // 각 방의 번호
		roomInfo = new ArrayList<>(); // 방의 시작점, 방들의 넓이
		checked = new boolean[M][N];
		
		// 각 방의 넓이 구하기
		for(int m = 0; m < M; m++) {
			for(int n = 0; n < N; n++) {
				if(!checked[m][n]) {
					findArea(m, n);
					roomNum++; // 방 개수 갱신
				}
			}
		}
		
		checked = new boolean[M][N];
		
		// 벽 한 개를 제거했을 때 방 넓이의 최대값 구하기
		for(int i = 0; i < roomInfo.size(); i++)
			checkNext(i, roomInfo.get(i)[0], roomInfo.get(i)[1]);
		
		System.out.println(roomNum + "\n" + maxArea + "\n" + removeMaxArea);
	}
	
	
	public static void findArea(int row, int column) {
		Queue<int[]> queue = new LinkedList<>();
		int area = 1; // 방 넓이
		
		queue.offer(new int[] {row, column});
		checked[row][column] = true;
		roomNo[row][column] = roomNum; // 방 번호 표시
		 
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curR = cur[0];
			int curC = cur[1];
			int num = castle[curR][curC];
			
			for(int b = 0; b < 4; b++) {
				int nextR = curR+D[b][0];
				int nextC = curC+D[b][1];
				
				if(num != (num | 1<<b) && !checked[nextR][nextC]) {
					queue.offer(new int[] {nextR, nextC}); 
					checked[nextR][nextC] = true;
					
					roomNo[nextR][nextC] = roomNum; // 방 번호 표시
					area++; // 방 넓이 갱신
				}
			}
		}
		
		roomInfo.add(new int[] {row, column, area}); // 방의 시작점, 방의 넓이 저장
		maxArea = Math.max(area, maxArea); // 방 넓이의 최대값 갱신
	}
	
	
	public static void checkNext(int no, int row, int column) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {row, column});
		checked[row][column] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nextR = cur[0] + D[d][0];
				int nextC = cur[1] + D[d][1];
				
				if(nextR<0 || nextR>=M || nextC<0 || nextC>=N || checked[nextR][nextC]) continue;
				
				if(roomNo[row][column] == roomNo[nextR][nextC]) { // 같은 방인 경우
					queue.offer(new int[] {nextR, nextC});
					checked[nextR][nextC] = true;
				}
				else // 다른 방인 경우
					removeMaxArea = Math.max(roomInfo.get(no)[2]+roomInfo.get(roomNo[nextR][nextC])[2], removeMaxArea);
			}
		}
	}
}
