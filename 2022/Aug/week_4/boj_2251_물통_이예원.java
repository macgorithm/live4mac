package Aug_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2251_물통_이예원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		boolean [][][] isVisited = new boolean[A+1][B+1][C+1];
		
		ArrayList<int[]> list = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<int[]>queue = new LinkedList<>();
		
		queue.add(new int[] {0,0,C});
		
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			//확인했던 용량이면 패스
			if(isVisited[temp[0]][temp[1]][temp[2]])
					continue;
			//확인 안 했으면 체크 
			isVisited[temp[0]][temp[1]][temp[2]] = true;
			
			//만약 a물통이 비었다면 c물통에 담긴 양을 답에 저장
			if(temp[0]==0) {
				ans.add(temp[2]);
			}
			
			//a,b물통
			if(temp[0]+temp[1]>A) {
				queue.add(new int[] {A,temp[0]+temp[1]-A,temp[2]});
			}else {
				queue.add(new int[] {temp[0]+temp[1],0,temp[2]});
			}
			
			if(temp[0]+temp[1]>B) {
				queue.add(new int[] {temp[0]+temp[1]-B,B,temp[2]});
			}else {
				queue.add(new int[] {0,temp[0]+temp[1],temp[2]});
			}
			
			//a,c물통
			if(temp[0]+temp[2]>A) {
				queue.add(new int[] {A,temp[1],temp[0]+temp[2]-A});
			}else {
				queue.add(new int[] {temp[0]+temp[2],temp[1],0});
			}
			
			if(temp[0]+temp[2]>C) {
				queue.add(new int[] {temp[0]+temp[2]-C,temp[1],C});
			}else {
				queue.add(new int[] {0,temp[1],temp[0]+temp[2]});
			}
			
			//b,c물통
			if(temp[1]+temp[2]>B) {
				queue.add(new int[] {temp[0],B,temp[1]+temp[2]-B});
			}else {
				queue.add(new int[] {temp[0],temp[1]+temp[2],0});
			}
			
			if(temp[1]+temp[2]>C) {
				queue.add(new int[] {temp[0],temp[1]+temp[2]-C,C});
			}else {
				queue.add(new int[] {temp[0],0,temp[1]+temp[2]});
			}
 		}
		
		Collections.sort(ans);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}	
	}

}
