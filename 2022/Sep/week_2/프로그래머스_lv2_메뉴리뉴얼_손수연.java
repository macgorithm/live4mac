package Sep_2022;

import java.util.*;

public class Solution_Programmers_72411_메뉴리뉴얼 {
	
    public String[] solution(String[] orders, int[] course) {
    	
    	HashMap<String, Integer> hashMap = new HashMap<>();
    	List<String> answerList = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for (int c : course) {
            for (String order : orders) combination("", order, c, hashMap);

            if (!hashMap.isEmpty()) {
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList);

                if (max > 1) {
                    for (String key : hashMap.keySet())
                        if (hashMap.get(key) == max) answerList.add(key);
                }
                
                hashMap.clear();
            }
        }

        Collections.sort(answerList);

        return answerList.toArray(new String[0]);
    }
    
    public void combination(String order, String others, int count, HashMap<String, Integer> hashMap) {
        if (count == 0) {
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            return;
        }

        for (int i = 0; i < others.length(); i++)
            combination(order+others.charAt(i), others.substring(i+1), count - 1, hashMap);
    }
}
