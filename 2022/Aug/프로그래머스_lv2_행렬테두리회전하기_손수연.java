package Aug_2022.week4;

public class Solution_Programmers_77485_행렬테두리회전하기 {
	
	public static int[][] matrix;
	
	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		matrix = new int[rows+1][columns+1];
		
		// 행렬 초기화
		for(int i = 1; i <= rows*columns; i++)
				matrix[(i-1)/columns+1][i-((i-1)/columns)*columns] = i;
		
		// 회전
		for(int i = 0; i < queries.length; i++)
			answer[i] = rotate(queries[i]);
		
		return answer;
	}
	
	public static int rotate(int[] queries) {
		int tmp = matrix[queries[0]][queries[1]];
		int min = tmp;
		
		for(int i = queries[0]; i < queries[2]; i++) { // 왼쪽
			matrix[i][queries[1]] = matrix[i+1][queries[1]];
			min = Math.min(matrix[i+1][queries[1]], min);
		}

		for(int i = queries[1]; i < queries[3]; i++) { // 아래쪽
			matrix[queries[2]][i] = matrix[queries[2]][i+1];
			min = Math.min(matrix[queries[2]][i+1], min);
		}

		for(int i = queries[2]-1; i >= queries[0]; i--) { // 오른쪽
			matrix[i+1][queries[3]] = matrix[i][queries[3]];
			min = Math.min(matrix[i][queries[3]], min);
		}

		for(int i = queries[3]-1; i >= queries[1]; i--) { // 위쪽
			matrix[queries[0]][i+1] = matrix[queries[0]][i];
			min = Math.min(matrix[queries[0]][i], min);
		}

		matrix[queries[0]][queries[1]+1] = tmp;
		
		return min;
	}
}
