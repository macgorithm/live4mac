package May_2022.week4;

public class Solution_Programmers_64062_징검다리건너기 {

	class Solution {
	    public int solution(int[] stones, int k) {
	        int answer = 0; // 징검다리를 건넌 니니즈 친구들 수
	        
	        int min = 0; // 건널 수 있는 친구들 수의 최솟값
	        int max = 200000000; // 건널 수 있는 친구들 수의 최댓값
	        
	        while(min <= max) {
	        	int mid = (min+max) / 2;
	        	
	        	if(possible(stones, k, mid)) { // mid명이 건널 수 있는 경우
	        		answer = Math.max(mid, answer);
	        		min = mid + 1;
	        	}
	        	else max = mid - 1; // 건널 수 없는 경우
	        }
	        
	        return answer;
	    }
	    
	    public boolean possible(int[] stones, int k, int mid) {
	    	int zeroCnt = 0; // 0인 디딤돌 개수
	    	
	    	for(int stone : stones) {
                if(stone - mid < 0) zeroCnt++; // mid명이 건널 수 없는 경우
                else zeroCnt = 0;
                
                if(zeroCnt >= k) return false;
            }
            
            return true;
	    }
	}
}