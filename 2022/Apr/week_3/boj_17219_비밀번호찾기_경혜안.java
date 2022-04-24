package Apr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_17219_비밀번호찾기_경혜안 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N, M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> notes = new HashMap<String, String>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			notes.put(st.nextToken(), st.nextToken());
		}
		
		for (int i = 0; i < M; i++) bw.append(notes.get(bf.readLine()) + "\n");
		
		bw.flush();
		
	}

}
