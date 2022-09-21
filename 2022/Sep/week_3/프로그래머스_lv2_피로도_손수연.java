package Sep_2022;

public class Solution_Programmers_87946_피로도 {
	
	static boolean[] checked;
	static int answer;
    
	public static int solution(int k, int[][] dungeons) {
		checked = new boolean[dungeons.length];
		answer = 0;
		
		return solve(dungeons, k, checked, 0);
	}
	
	private static int solve(int[][] dungeons, int k, boolean[] checked, int count) {
		for(int i = 0; i < dungeons.length; i++) {
			if(k >= dungeons[i][0] && !checked[i]) {
				checked[i] = true;
				
				solve(dungeons, k-dungeons[i][1], checked, count+1);
				
				checked[i] = false;
			}
		}
		
		answer = Math.max(answer, count);
		
		return answer;
	}
}