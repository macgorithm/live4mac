package May_2022.week3;

import java.util.*;

public class Solution_Programmers_42888_오픈채팅방 {
	public String[] solution(String[] record) {
        HashMap<String, String> info = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        
        for(String s : record){
            String[] r = s.split(" ");
            
            switch (r[0]) {
                case "Enter" :
                    result.add(r[1] + "  님이 들어왔습니다.");
                case "Change" :
                    info.put(r[1], r[2]);
                    break;
                case "Leave" :
                    result.add(r[1] + "  님이 나갔습니다.");
                    break;
            }
        }
        
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++) {
            String[] arr = result.get(i).split("  ");
            answer[i] = info.get(arr[0]) + arr[1];
        }
        
        return answer;
    }
}
