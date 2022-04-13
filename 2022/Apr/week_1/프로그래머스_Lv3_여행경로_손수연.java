package Mar_2022.week5;

import java.util.*;

class Solution_Programmers_43164_여행경로 {
	
	ArrayList<String> list = new ArrayList<>();
	PriorityQueue<String> queue = new PriorityQueue<>();
	boolean[] checked;
	
    public String[] solution(String[][] tickets) {
    	checked = new boolean[tickets.length];
        dfs("ICN", 0, tickets);
        
        return queue.poll().split(" ");
    }
    
    public void dfs(String desc, int len, String[][] tickets) {
    	list.add(desc);
    	
    	if(len == tickets.length) { // 모든 티켓을 사용한 경우
    		queue.offer(String.join(" ", list));
    		return;
    	}
    	
    	for(int i = 0; i < tickets.length; i++) {
    		if(!checked[i] && tickets[i][0].equals(desc)) {// 티켓을 사용하지 않았고, 해당 도착지(desc)가 티켓의 출발지와 같은 경우
    			checked[i] = true;
    			dfs(tickets[i][1], len+1, tickets);
    			checked[i] = false;
    			list.remove(list.size()-1);
    		}
    	}
    }
}