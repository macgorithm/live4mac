package Aug_4;

import java.util.Arrays;

public class 프로그래머스_Lv2_행렬테두리회전하기 {

	public static void main(String[] args) {
		
		int rows = 3;
		int columns = 3;
		int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		
		int [] answer = new int[queries.length];
		int [][] arr = new int[rows+1][columns+1];
		
		// 1 행렬 초기화
		int n = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = ++n;
			}
		}
		
		// 2 회전
		int index=0;
		for (int i = 0; i < queries.length; i++) {
			int x1 = queries[i][0]-1;
			int y1 = queries[i][1]-1;
			int x2 = queries[i][2]-1;
			int y2 = queries[i][3]-1;
			
			
			int temp = arr[x1][y1];
			int min = temp;
			
		
			
			// 2-1 좌측 회전
			for (int j = x1+1; j <= x2; j++) {
				arr[j-1][y1] = arr[j][y1];
				if(min > arr[j][y1]) min = arr[j-1][y1];
			}
			
			//2-2 top 회전
			for (int j = y1+1; j <= y2; j++) {
				arr[x2][j-1] = arr[x2][j];
				if(min > arr[x2][j]) min = arr[x2][j-1];
			}
			
			//2-3 우측 회전
			for (int j = x2-1; j >= x1; j--) {
				arr[j+1][y2] = arr[j][y2];
				if(min>arr[j][y2]) min = arr[j+1][y2];
			}
			
			//2-4 바닥 회전
			for (int j = y2-1; j >= y1; j--) {
				arr[x1][j+1] = arr[x1][j];
				if(min>arr[x1][j]) min = arr[x1][j+1];
			}
			
			arr[x1][y1+1] = temp;
			
			answer[i]=min;
			
		}
//		return answer;
		System.out.println(Arrays.toString(answer));
	}

}
