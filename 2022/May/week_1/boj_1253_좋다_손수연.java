package Apr_2022.week5;

import java.io.*;
import java.util.*;

public class Main_BJ_1253_좋다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 수의 개수
		int[] num = new int[N];
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) num[n] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(num);
		
		for(int n = 0; n < N; n++) {
			int minIdx = 0;
			int maxIdx = N-1;
			
			while(minIdx < maxIdx) {
				if(minIdx == n) minIdx++; // 해당 수와 minIdx 위치가 같은 경우
				if(maxIdx == n) maxIdx--; // 해당 수와 maxIdx 위치가 같은 경우

				if(minIdx==maxIdx || minIdx<0 || maxIdx>= N) break; // minIdx와 maxIdx의 위치가 같거나 범위를 벗어난 경우
				
				if(num[n] == num[minIdx]+num[maxIdx]) {
					cnt++;
					break;
				}
				else if(num[n]-num[minIdx] > num[maxIdx]) minIdx++;
				else if(num[n]-num[minIdx] < num[maxIdx]) maxIdx--;
			}
		}
			
		
		System.out.println(cnt);
	}
}
