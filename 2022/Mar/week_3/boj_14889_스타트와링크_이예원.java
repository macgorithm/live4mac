package Mar_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14889_스타트와링크_이예원 {
	
	static int N;
	static int[][] S;
	static boolean[] isChecked;
	
	static int res=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S= new int [N][N];
		isChecked = new boolean [N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				S[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		makeTeam(0,0);
		System.out.println(res);
	}

	private static void makeTeam(int idx, int cnt) {
		//팀 조합이 완성된 경우 
		if(cnt==N/2) {
			calDiff();
			return;
		}
		
		//true=start팀, false=link팀으로 나눈다 
		for (int i = idx; i <N; i++) {
			if(isChecked[i]==false) {
				isChecked[i]=true;
				makeTeam(i+1, cnt+1);
				isChecked[i]=false;
			}
		}
		
	}

	private static void calDiff() {
		int start=0;
		int link=0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				//i번째 사람과 j번째 사람이 tur라면 스타트팀으로 점수 더하고 
				if(isChecked[i]==true && isChecked[j]==true) {
					start += S[i][j];
					start += S[j][i]; 
				}
				//i번째 사람과 j번째 사람이 tur라면 링크팀으로 점수 더하기   
				else if(isChecked[i]==false && isChecked[j]==false) {
					link += S[i][j];
					link += S[j][i]; 
				}
			}
		}
		int sub = Math.abs(start-link);
		
		//차이의 최소값이 0이면 0출력하고 종료 
		if(sub==0) {
			System.out.println(sub);
			System.exit(0);
		}
		
		res=Math.min(sub, res);
	}

}
