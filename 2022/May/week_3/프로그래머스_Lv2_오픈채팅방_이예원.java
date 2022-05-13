package May_3;

import java.util.ArrayList;
import java.util.HashMap;

public class 프로그래머스_Lv2_오픈채팅방_이예원 {

	public static void main(String[] args) {
		String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		ArrayList<String> list = new ArrayList();
		HashMap<String,String> map = new HashMap();
		
		for (int i = 0; i < record.length; i++) {
			String[] chat = record[i].split(" ");
			
			if(chat[0].equals("Enter")) {
				list.add(chat[1] + "님이 들어왔습니다.");
				map.put(chat[1], chat[2]);
			}else if(chat[0].equals("Change")) {
				map.put(chat[1],chat[2]);
			}else {
				list.add(chat[1]+"님이 나갔습니다.");
			}
	        
		}
		
		String[] ans = new String[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			int idx = list.get(i).indexOf("님"); //님을 찾아서 index 반환 
			
			String nickname = list.get(i).substring(0, idx);
			String[] commend = list.get(i).split(" ");
			
			ans[i] = map.get(nickname) + "님이 " + commend[1];
		    
			System.out.println(ans[i]);
		}


	}

}
