package Oct_2022;

import java.util.*;

public class Solution_Programmers_42890_후보키 {
	
	static ArrayList<HashSet<Integer>> candidate;
	
    public int solution(String[][] relation){
        candidate = new ArrayList<HashSet<Integer>>();
        solve(0, new HashSet<Integer>(), relation);

        return candidate.size();
    }

    static void solve(int n, HashSet<Integer> hashSet, String[][] relation){
        if(n == relation[0].length) {
            for(int i =0; i < candidate.size(); i++)
                if(hashSet.containsAll(candidate.get(i))) return;
            
            HashSet<String> set = new HashSet<>();
            
            for(int r = 0; r < relation.length; r++){
                String temp = "";
                
                for(int c : hashSet) temp += relation[r][c] + ",";
                
                if(set.contains(temp)) return;
                
                set.add(temp);
            }
            
            candidate.add(hashSet);
            
            return;
        }
        
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for(Integer value : hashSet){
            set1.add(value);
            set2.add(value);
        }

        solve(n+1, set2, relation);
        set1.add(n);
        solve(n+1, set1, relation);
    }
}
