package Mar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class 프로그래머스_Lv3_여행경로_경혜안 {
	static int N;
	static ArrayList<String[]> answer = new ArrayList<String[]>();
	public static void main(String[] args) {
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		N = tickets.length;
		
		boolean[] visited = new boolean[N];
		Stack<String> st = new Stack<String>();
		st.push("ICN");
		
		DFS(visited, 0, "ICN", tickets, st);
		
		// 2차원 문자열 배열 정렬 
		Collections.sort(answer, new Comparator<String[]>() { 
			@Override
			public int compare(String[] o1, String[] o2) {
				for (int i = 0; i <= N; i++) {
                    String s1 = o1[i];
                    String s2 = o2[i];

                    if (!s1.equals(s2)) {
                        return s1.compareTo(s2);
                    }
                }
				return 0;
			}
		});
//		System.out.println(answer.size());
		for (int i = 0; i <= N; i++) {
			System.out.print(answer.get(0)[i] + " ");
		}
	
	}
	
	static void DFS(boolean[] visited, int dept, String from, String[][] tickets, Stack<String> st) {
		if(dept == N) {
			// 기저조건 
			String[] temp = new String[N];
			temp = st.toArray(temp);
			answer.add(temp);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			String[] ticket = tickets[i];
			
			if(ticket[0].equals(from) && !visited[i]) {
				visited[i] = true;
				st.push(ticket[1]);
				DFS(visited, dept+1, ticket[1], tickets, st);
				visited[i] = false;
				st.pop();
			}
		}
	
	}

}
