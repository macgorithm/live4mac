package Apr_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_11265_끝나지않는파티_이예원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] party = new int[N+1][N+1];
		
		//거리 값 입력 받기 
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				party[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//플로이드 와샬 - 최단경로 갱신
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					party[i][j]=Math.min(party[i][j], party[i][k]+party[k][j]);
				}
			}
		}
		
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            //시간 내 도착하는경우 
            if(party[A][B] <= C) {
               System.out.println("Enjoy other party");
            //시간 내 도착하지 못하는 경우 
            }else {
            	System.out.println("Stay here");
            }
        }

	}

}
