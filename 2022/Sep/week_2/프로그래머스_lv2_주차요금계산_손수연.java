package Sep_2022;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_Programmers_92341_주차요금계산 {

	public int[] solution(int[] fees, String[] records) {
        HashMap<String, List<String>> logs = new HashMap<>();
        
        for (String record : records) {
            String[] split = record.split(" ");
            List<String> time = logs.getOrDefault(split[1], new ArrayList<>());
            
            time.add(split[0]);
            logs.put(split[1], time);
        }

        List<String> keys = logs.keySet().stream().sorted().collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>();
        
        for (String key : keys) answer.add(calculate(fees, logs.get(key)));

        return answer.parallelStream().mapToInt(Integer::intValue).toArray();
    }
	
    private int calculate(int[] fees, List<String> times) { // fees[0]:기본시간(분), fees[1]:기본요금(원), fees[2]:단위시간(분), fees[3]:단위요금(원)
    	
        if (times.size()%2 == 1) times.add("23:59");

        int totalTime = 0;
        int amount = 0;
        
        for (int t = 1; t < times.size(); t+=2)
            totalTime += timeToMinutes(times.get(t)) - timeToMinutes(times.get(t - 1));

        amount = fees[1];
        
        if (totalTime > fees[0])
        	amount = fees[1] + (int)(Math.ceil((totalTime-fees[0]) / (double)fees[2])) * fees[3];

        return amount;
    }

    private int timeToMinutes(String time) { // 분 단위로 변환
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}