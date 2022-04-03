package Mar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

public class 프로그래머스_Lv3_불량사용자_경혜안 {
	static int N;
	static ArrayList<ArrayList<String>> comb = new ArrayList<ArrayList<String>>();
	static HashSet<HashSet<String>> answer = new HashSet<HashSet<String>>();
	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"*rodo", "*rodo", "******"};
		
		N = banned_id.length;
		
		for (int i = 0; i < N; i++) {
			String reg = getPattern(banned_id[i]);
			ArrayList<String> temp = new ArrayList<String>();
			for (String string : user_id) {
				if(Pattern.matches(reg, string)) temp.add(string);
			}
			comb.add(temp);
		}
		DFS(0, new HashSet<String>());
		System.out.println(answer.size());	

	}
	static void DFS(int dept, HashSet<String> temp) {
		if (dept == N) {
			// answer.add(temp);
			answer.add(new HashSet<String>(temp));
			return;
		}
		
		for (String id : comb.get(dept)) {
			if(!temp.contains(id)) {
				temp.add(id);
				DFS(dept+1, temp);
				temp.remove(id);
			}
		}
		
		
	}
	static String getPattern(String str) {
		
		return str.replace("*", ".");
	}

}
