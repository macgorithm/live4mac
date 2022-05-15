package May;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 프로그래머스_lv2_오픈채팅방_경혜안 {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		ArrayList<String> answer = new ArrayList<String>();
		Map<String, String> id = new HashMap<String, String>();
		
		for (String order : record) {
			String[] command = order.split(" "); // 명령어를 나눈 후 
			
			if(command[0].equals("Enter") || command[0].equals("Change")) {
				id.put(command[1], command[2]); // map구조에 아이디를 기준으로 입력 
			} 
		}
		
		for (String order : record) {
			String[] command = order.split(" "); // 나가고들어온 경우만 결과 입력 
			
			if(command[0].equals("Enter")) {
				answer.add(id.get(command[1]) + "님이 들어왔습니다.");
			} else if (command[0].equals("Leave")) {
				answer.add(id.get(command[1]) + "님이 나갔습니다.");
			}
					
		}
		
		String[] ans = new String[answer.size()];
		ans = answer.toArray(ans);
		
	}

}
