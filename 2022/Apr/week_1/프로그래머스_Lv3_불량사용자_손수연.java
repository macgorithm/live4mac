package Mar_2022.week5;

import java.util.*;

public class Solution_Programmers_64064_불량사용자 {
	
	int answer = 0;
    boolean[] checked = new boolean[1 << 8];
    String[] banForm;
    
    public int solution(String[] user_id, String[] banned_id) {
        banForm = Arrays.stream(banned_id)
            .map(s -> s.replace("*", "."))
            .toArray(String[]::new);
        
        solve(0, 0, user_id);
        return answer;
    }
    
    public void solve(int cnt, int check, String[] user_id) { // check: i번째 응모자가 불량 사용자인 경우, i번째 비트가 1
        if(cnt == banForm.length) { // 불량 사용자 목록이 완성된 경우
           	if(!checked[check]) { // 해당 목록이 처음인 경우
        		checked[check] = true;
                answer++;
            }
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if((check & (1 << i)) == 0 && user_id[i].matches(banForm[cnt])) // 체크가 안됐고, 응모자 아이디가 불량 사용자와 매핑되는 경우
                solve(cnt + 1, check | (1 << i), user_id);
        }
    }
}