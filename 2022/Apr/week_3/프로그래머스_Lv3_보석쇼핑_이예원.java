package Apr_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 프로그래머스_Lv3_보석쇼핑_이예원 {
	
    public static void main(String[] args)  {
//        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
//        String[] gems = {"XYZ", "XYZ", "XYZ"};
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};


        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(gems)));
    }

    static class Solution {
        public int[] solution(String[] gems) {
        	int[] answer = new int[2];
        	
            HashSet<String> set = new HashSet<>();

            for (String s : gems) {
                set.add(s);
            }
            
            int n = gems.length;

            int distance = Integer.MAX_VALUE;
            //범위
            int left = 0;
            int right = 0;

            //정답
            int start = 0;
            int end = 0;

            HashMap<String, Integer> map = new HashMap<>();
            
            while (true) {

                if (set.size() == map.size()) {
                    //크기가 같은 경우 원하는 범위 좁히기
                    map.put(gems[left], map.get(gems[left])-1);

                    if (map.get(gems[left]) == 0) {
                        map.remove(gems[left]);
                    }
                    left++;
                } else if (right == n) {
                    break;
                } else {
                    //right 오른쪽으로 이동
                    //set에 해당하는 보석들을 다 찾아야함
                    //해당 보석의 개수 +1
                    map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                    right++;
                }

                if (map.size() == set.size()) {
                    if (right-left < distance){
                        distance = right-left;
                        start = left+1;
                        end = right;
                    }
                }

            }
            
            answer[0] = start;
            answer[1] = end;
            
        	return answer;
        }
    }
}


