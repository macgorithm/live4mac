package Apr_1;
import java.util.Arrays;

public class 프로그래머스_Lv3_불량사용자_이예원2 {

    static int ans = 0;
    static boolean[] chk = new boolean[1 << 8];
    static String[] patterns;
    
    public int solution(String[] user_id, String[] banned_id) {
        patterns = Arrays.stream(banned_id)
                .map(b -> b.replace("*", "."))
                .toArray(String[]::new);
            
            solve(0, 0, user_id);
            return ans;
    }

	private void solve(int cnt, int visit, String[] user_id) {
        if(cnt == patterns.length) {
           	if(!chk[visit]) {
        		chk[visit] = true;
                ans++;
            }
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if((visit & (1 << i)) == 0 && user_id[i].matches(patterns[cnt]))
                solve(cnt + 1, visit | (1 << i), user_id);
        }
		
	}



}





