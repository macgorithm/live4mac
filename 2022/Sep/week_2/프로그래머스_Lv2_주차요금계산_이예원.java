package Sep_2;

import java.util.*;

public class 프로그래머스_Lv2_주차요금계산_이예원 {

	public static void main(String[] args) {
		int[] fees = {1,461,1,10};
		String[] records = {"00:00 1234 IN"};

		Map<String,String> map = new HashMap<>();
		Map<String,Integer> feeMap = new HashMap<>();
		
		for (int i = 0; i < records.length; i++) {
			feeMap.put(records[i].split(" ")[1],0);
		}
		
		for (int i = 0; i < records.length; i++) {
			String[] info = records[i].split(" ");
			
			if(map.containsKey(info[1])) {
				String[] inTime = map.remove(info[1]).split(":");
				String[] outTime = info[0].split(":");
				
				int h = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
				int m = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
				
				feeMap.replace(info[1], feeMap.get(info[1]) + 60 * h + m);
				
			}else {
				map.put(info[1],info[0]);  //차번호, 시간
			}
		}
		
		// 남은 차는 23:59에 출차한 것으로 계산
        for(String key : map.keySet()){
            String[] inTime = map.get(key).split(":");
            
            int h = 23 - Integer.parseInt(inTime[0]);
            int m = 59 -Integer.parseInt(inTime[1]);
            
            feeMap.replace(key, feeMap.get(key) + 60 * h + m);
        }
        
        // 저장된 차량마다 계산시간을 List하여 차량번호로 list 정렬하고 요금 계산 
        List<Map.Entry<String, Integer>> list = new ArrayList(feeMap.entrySet());
        
        Collections.sort(list, (o1, o2) -> {
            return Integer.parseInt(o1.getKey()) > Integer.parseInt(o2.getKey())?1 : 
            Integer.parseInt(o1.getKey()) < Integer.parseInt(o2.getKey())?-1 : 0;
        });
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++){
            if(list.get(i).getValue() > fees[0]){
                answer[i] = fees[1] + (int) Math.ceil((list.get(i).getValue() - fees[0]) / (double)fees[2]) * fees[3];
            }else{
                answer[i] = fees[1];
            }
        }
        
        for (int j = 0; j < answer.length; j++) {
        	 System.out.println(answer[j]);
		}
       
		
	}

}
