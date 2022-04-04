package Apr_1;

import java.util.ArrayList;
import java.util.Collections;

public class 프로그래머스_Lv3_여행경로_이예원 {

	boolean [] isVisited;
	ArrayList<String>answers;
	
    public String[] solution(String[][] tickets) {
    	isVisited = new boolean[tickets.length];
    	answers = new ArrayList<String>();
    	
    	int cnt=0; //몇개의 공항을 들리는지 
    	dfs(cnt,"ICN","ICN",tickets);
    	
    	Collections.sort(answers); //알파벳순으로 정답 정렬 
    	
        String[] answer = answers.get(0).split(" "); //가장 빠른 배열 뽑기 
        return answer;
    }

	void dfs(int cnt, String now, String answer, String[][] tickets) {
		if(cnt==tickets.length) {
			answers.add(answer); //모든 공항에 들렸다면 answers에 추가해주기 
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			if(!isVisited[i] && tickets[i][0].equals(now)) { //now와 같고 들리지 않은 공항을 찾으면  
				isVisited[i]=true; //들린 공항으로 만들 
				dfs(cnt+1, tickets[i][1],answer+" "+tickets[i][1], tickets); //cnt+1,도착 공항을 now로 넣어주고 answer에 도착공항을 추가
				isVisited[i]=false;
			}
		}
		return;
	}

}


