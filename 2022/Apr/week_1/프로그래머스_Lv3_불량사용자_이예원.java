package Apr_1;
import java.util.HashSet;

public class 프로그래머스_Lv3_불량사용자_이예원 {

    static HashSet<String> bUserIdx;
    
    public int solution(String[] user_id, String[] banned_id) {
    	boolean isVisited[] = new boolean[user_id.length]; // 방문체크
    	
    	bUserIdx = new HashSet<String>(); // 중복제거
    	dfs(user_id, banned_id, 0, isVisited); // 경우의 수 찾기
    	
        return bUserIdx.size();
    }

	private void dfs(String[] user_id, String[] banned_id, int bIdx, boolean[] isVisited) {
		if(bIdx == banned_id.length) { // ban된 id 모두 선택
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < user_id.length; i++) {
				if(isVisited[i]) {
					sb.append(i);
				}
			}
			
			bUserIdx.add(sb.toString()); // 중복된 값 없는 모든 인덱스
			return ;
		}
		for(int i = 0; i < user_id.length; i++) {
			if(isVisited[i]) continue;
			boolean flag = false;
			
            // 유저와 밴 된 유저의 길이가 같은 경우만 체크
			if(user_id[i].length() == banned_id[bIdx].length()) {
				for(int s = 0; s < user_id[i].length(); s++) {
					if(banned_id[bIdx].charAt(s) == '*') continue;
                    
					// 하나라도 다른 글자가 포함되어 있다면 멈추고 다음 유저로
					if(user_id[i].charAt(s) != banned_id[bIdx].charAt(s)) {
						flag = true;
						break;
					}
				}
				if(!flag) { // 모든 글자가 맞았다면 
					isVisited[i] = true;
					dfs(user_id, banned_id, bIdx+1, isVisited); // 다음 탐색
					isVisited[i] = false;
				}
			}
		}
	}

}





