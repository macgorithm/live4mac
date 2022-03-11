package Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_2234_성곽_경혜안 {
	static int[][] room, map; 
	static int N, M, maxRoomSize = 0;
	static ArrayList<Integer> roomSize;
	// 인접한 방 정보를 얻기 위한 hash map 
	static HashMap<Integer, Set<Integer>> side = new HashMap<Integer, Set<Integer>>();
	static class Pos {
		int x, y;
		
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 방 갯수, 가장 넓은 방 넓이, 하나의 벽을 허물고 얻을 수 있는 가장 큰 방의 크기 
		
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken()); // 열 
		M = Integer.parseInt(st.nextToken()); // 행 
		
		map = new int[M][N];
		roomSize = new ArrayList<Integer>(); // 방 사이즈를 담을 리스트 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //방 정보 입력 
		
		room = new int[M][N]; // 방 번호 저장 
		int num = 1; // 방 번호 (1로 지정하는 이유는 중복 변수 피하기 위해 )
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(room[i][j] == 0) { // 아직방문을 안한 방이라면 BFS실행 
					bfs(i, j, num++);
				}
			}
		}
		int maxSize = 0; // 최대 사이즈 저장 
		for (int i = 1; i <= num; i++) { // 1번 방부터 돌면서 
			if(side.get(i) != null) { // 비어 있지 않다면  
				for (int j : side.get(i)) { // 각 방의 인접한 방 번호를 체크하여 갱신 
					maxSize = Math.max(roomSize.get(i-1) + roomSize.get(j-1), maxSize);
				}
			}
		}
		
		System.out.println(num-1);
		System.out.println(maxRoomSize);
		System.out.println(maxSize);
		
		
	}
	
	static void bfs(int i, int j, int num) {
		// 방향 정보 저장 
		int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0}, dir = {1, 2, 4, 8};
		int x, y, size;
		Queue<Pos> que = new LinkedList<Pos>();
		que.add(new Pos(i, j));
		room[i][j] = num; // 현재 무슨 방에 위치하는지 저장 
		Set<Integer> set = new HashSet<>(); // 중복을 피하기 위해 set 자료 구조 사용하여 인접한 방저장 
		Pos cur;
		size = 0;
		
		while(!que.isEmpty()) {
			cur = que.poll();
			size++;
			for (int k = 0; k < 4; k++) {
				x = cur.x + dx[k];
				y = cur.y + dy[k];
				
				if(x < 0 || x >= M || y < 0 || y >= N) continue; // 범위 넘어가는지 확인 
				else if (room[x][y] != 0 && room[x][y] != num) { // 방문한 방인데 현재 방이 아닐경우 (즉 , 인접할 경우) 
					set.add(room[x][y]); // 인접한 방에 추가 
				} else if((map[cur.x][cur.y] & dir[k]) == 0 && room[x][y] == 0) { // 방향 체크 및 아직 방문 전인 방인 경우 
					que.add(new Pos(x, y));
					room[x][y] = num;
					
				}
			}
			
		}
		side.put(num, set); // 인접한 방 정보 넣기 
		roomSize.add(size); // 방의 크기 넣기 
		maxRoomSize = Math.max(maxRoomSize, size); // 가장 큰 방 넓이 구하기 
	}

}
