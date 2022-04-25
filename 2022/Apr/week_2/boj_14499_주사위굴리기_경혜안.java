package Apr;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_14499_주사위굴리기_경혜안 {



		public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n, m, x, y, k, bottom;
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // map input
			
			bottom = 6;
			int[] dice = new int[7]; // 1 은 top, 6 = bottom

			int[] dx = {0, 0, 0, -1, 1}, dy = {0, 1, -1, 0, 0};
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < k; i++) {
				int move = Integer.parseInt(st.nextToken());
				int tx = x + dx[move];
				int ty = y + dy[move];
				if(tx >= 0 && tx < n && ty >= 0 && ty < m ) {
					x = tx;
					y = ty;
					rollDice(move, dice);
					
					bw.write(dice[1] + "\n");
					if(map[x][y] == 0) {
						map[x][y] = dice[6];
					} else {
						dice[6] = map[x][y];
						map[x][y] = 0;
					}
					
				}
				
				
				
			}
			bw.flush();
		}
		
		static void rollDice(int dir, int[] dice) {
			int temp = 0;
			if(dir == 1) { // 동
				temp = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = temp;
			} else if(dir == 2) { // 서
				temp = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = temp;
			} else if(dir == 3) { // 북
				temp = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = temp;
			} else {
				temp = dice[6];
				dice[6] = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[2];
				dice[2] = temp;
			}
		}


}
