package Oct_1;

import java.util.*;

public class 프로그래머스_Lv2_후보키_이예원 {

	static List<String> ans = new ArrayList<>();
	
	public static void main(String[] args) {
		
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},
				{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},
				{"600","apeach","music","2"}};

        for (int i = 0; i < relation[0].length; i++) {
            boolean[] visited = new boolean[relation[0].length];
            dfs(visited, 0, 0, i + 1, relation);
        }
        
//        return ans.size();
        System.out.println(ans.size());
	}

	public static void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            List<Integer> list = new ArrayList<>();
            
            String key = "";
            
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    key += String.valueOf(i);
                    list.add(i);
                }
            }
            
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < relation.length; i++) {
                String s = "";
                
                for (Integer j : list) {
                    s += relation[i][j];
                }

                if (map.containsKey(s)) {
                    return;
                } else {
                    map.put(s, 0);
                }
            }
            
            // 후보키 추가
            for (String s : ans) { 
                int count = 0;
                for(int i = 0; i < key.length(); i++){
                    String subS = String.valueOf(key.charAt(i));
                    if(s.contains(subS)) count++;
                }
                if (count == s.length()) return;
            }
            ans.add(key);

            return;
        }
        
        for (int i = start; i < visited.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(visited, i, depth + 1, end, relation);
            visited[i] = false;
        }
		
	}

}
