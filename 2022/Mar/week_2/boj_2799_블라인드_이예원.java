package Mar_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2799_블라인드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); //아파트의 층수
		int N = sc.nextInt(); //한층의 창문 수
		
		int [] res = new int[5];
		int [] cnt = new int[N];
		int idx=0;
		
		for (int k = 0; k < M; k++) {
			sc.next(); //#처리
			for (int i = 0; i < 4; i++) {
				String str = sc.next();
				for (int j = 1; j< (5*N)+1; j+=5) {
					if(str.charAt(j)=='*') {
						cnt[idx]++;
						idx++;
					}
				}
				idx=0;
			}	
			for (int j = 0; j <N; j++) {
				res[cnt[j]]++;
			}
			Arrays.fill(cnt, 0); //배열값 초기
		}

		sc.next(); 
		for (int i = 0; i < 5; i++) {
			System.out.print(res[i] + " ") ;
		}

	}

}
