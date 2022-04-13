package Apr_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_17219_비밀번호찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String,String> hmap = new HashMap<String, String>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String url = st.nextToken();
			String pw = st.nextToken()
;
			hmap.put(url, pw);
		}
		
		for (int i = 0; i < M; i++) {
			System.out.println(hmap.get(br.readLine()));
		}
	}

}
