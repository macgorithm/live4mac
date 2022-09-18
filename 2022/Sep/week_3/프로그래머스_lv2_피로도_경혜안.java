package Sep;

public class 프로그래머스_lv2_피로도_경혜안 {
	static int answer = 0;
	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};

		boolean[] visited = new boolean[dungeons.length];
		
		
				
		DFS(k, dungeons, visited, 0);
		
		System.out.println(answer);
	}
	
	static void DFS(int k, int[][] dungeons, boolean[] visited, int cnt) {
		
		for (int i = 0; i < dungeons.length; i++) {
			if(!visited[i] && k >= dungeons[i][0]) {
				visited[i] = true;
				DFS(k-dungeons[i][1], dungeons, visited, cnt+1);
				visited[i] = false;
			}
		}
		
		answer = Math.max(answer, cnt);
	}

}
