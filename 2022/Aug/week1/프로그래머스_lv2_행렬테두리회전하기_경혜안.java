package Agust;

import java.util.PriorityQueue;

public class 프로그래머스_lv2_행렬테두리회전하기_경혜안 {

	public static void main(String[] args) {
		
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		
		int[] answer = new int[queries.length];
		
		int[][] arr = new int[rows+1][columns+1];
		
		// 행렬 초기화 
		int num = 1;
		for (int i = 1; i <= rows; i++) { 
			for (int j = 1; j <= columns; j++) {
				arr[i][j] = num++;
			}
		}
		int index = 0;
		for (int[] rotate : queries) {
			int x1 = rotate[0] ,y1 = rotate[1], x2 = rotate[2], y2 = rotate[3];
			
			PriorityQueue<Integer> min = new PriorityQueue<Integer>();
			// move to up
			int temp;
			temp = arr[x1][y1];
			min.offer(temp);
			
			for (int i = x1+1; i <= x2; i++) {
				min.offer(arr[i][y1]);
				arr[i-1][y1] = arr[i][y1];
			}
			
			// move to left
			for (int i = y1+1; i <= y2; i++) {
				min.offer(arr[x2][i]);
				arr[x2][i-1] = arr[x2][i];
			}
			
			// move to down
			for (int i = x2-1; i >= x1; i--) {
				min.offer(arr[i][y2]);
				arr[i+1][y2] = arr[i][y2];
			}
			
			// move to right
			for (int i = y2-1; i > y1; i--) {
				min.offer(arr[x1][i]);
				arr[x1][i+1] = arr[x1][i];
			}
			
			arr[x1][y1+1] = temp;
			
			answer[index++] = min.peek();
			
			
		}
		
		
		
	}

}
