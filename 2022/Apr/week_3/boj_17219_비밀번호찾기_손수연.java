package Apr_2022.week3;

import java.util.*;
import java.io.*;

public class Main_BJ_17219_비밀번호찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소의 수
		int M = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수
		
		HashMap<String, String> map = new HashMap<>(); // Key:사이트 주소, Value:비밀번호
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		for(int m = 0; m < M; m++)
			System.out.println(map.get(br.readLine()));
	}
}