package Apr_2022.week3;

import java.util.*;

public class Solution_Programmers_67258_보석쇼핑 {
	
	public int[] solution(String[] gems) {
        HashSet<String> juwelry = new HashSet<>();
        HashSet<String> check = new HashSet<>();
        HashMap<String, Integer> num = new HashMap<>();
        
        for(int i = 0; i < gems.length; i++) juwelry.add(gems[i]); // -> 보석의 종류 : juwelry.size()
        	
        int start = 0, end = gems.length;
        int tempStart = -1, tempEnd = -1;
        
        while(tempStart <= tempEnd && tempEnd < gems.length) {
        	if(check.size() != juwelry.size()) { // 모든 보석이 포함되지 않은 경우
        		tempEnd++;
        		
        		if(tempEnd < gems.length) {
	        		num.put(gems[tempEnd], num.getOrDefault(gems[tempEnd], 0)+1);
		        	check.add(gems[tempEnd]);
        		}
        	}
        	
        	if(check.size() == juwelry.size()) { // 모든 보석이 포함된 경우
        		if(end-start > tempEnd-tempStart) // 길이가 최소인 경우
        			start = tempStart+1; end = tempEnd; // start, end값 갱신
        		
        		tempStart++;
        			
        		num.put(gems[tempStart], num.get(gems[tempStart])-1);
            		
            	if(num.get(gems[tempStart]) == 0)
            		check.remove(gems[tempStart]);
        	}
        }
        
        return new int[] {start+1, end+1};
    }
}