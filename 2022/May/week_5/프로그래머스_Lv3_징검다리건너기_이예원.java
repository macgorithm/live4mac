package May_5;

public class 프로그래머스_Lv3_징검다리건너기_이예원 {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		int answer = 0;
		int min = 0;
		int max = 200000000;

		while(min <= max) {
			//징검다리를 건널 인원 
			int mid = (min+max)/2;

			//징검다리를 건널 수 있는지 확인 
			if(crossRiver(stones, k, mid)) {
				//건널 수 있으면 더 많은 사람이 가능한지 친구 수 증가
				min = mid + 1;
				answer = Math.max(answer, mid);
			} else {
				//건널 수 없으면 수를 감소 
				max = mid -1 ;
			}
		}

		System.out.println(answer);
	}

	static boolean crossRiver(int[] stones, int k, int friends) {
	    //못 건너는 징검다리의 개수
      	int skip = 0;
        
        for (int stone : stones) {
            //디딤돌의 숫자 - 건너는 친구의 수<0이면 건널 수 없음
            if (stone - friends < 0)
                skip++;
            else {
            	skip = 0;
            }
                
            //못 건너는 징검다리의 수가 k를 넘으면 건널 수 없음 
            if (skip == k) {
            	return false;
            }
               
        }
        
        return true;
	}

}
