package Sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 프로그래머스_lv2_주차요금계산_경혜안 {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		
		Map<String, Integer> times = new TreeMap<String, Integer>(); 
		Map<String, String> in = new HashMap<String, String>(); 
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		for (String rec : records) {
			String[] temp = rec.split(" ");
			
			if(temp[2].equals("IN")) {
				in.put(temp[1], temp[0]);
			} else {
				String inTime = in.get(temp[1]);
				String outTime = temp[0];
				
				times.put(temp[1], times.getOrDefault(temp[1], 0) + calcTime(inTime, outTime));
				in.remove(temp[1]);
			}
		}
		
		for (String k :in.keySet()) {
			times.put(k, times.getOrDefault(k, 0) + calcTime(in.get(k), "23:59"));
		}
		
		for (String k : times.keySet()) {
			int m = times.get(k);
			
			if(m <= fees[0]) {
				answer.add(fees[1]);
			} else {
				int extra = (m - fees[0]) % fees[2] == 0 ?  (m - fees[0]) / fees[2]  : (m - fees[0]) / fees[2] + 1;
				answer.add(fees[1] + extra * fees[3]);
			}
		}
		
	}
	
	static int calcTime(String s, String e) {
		String[] in = s.split(":");
		String[] out = e.split(":");
		
		int time = 0;
		
		time += (Integer.parseInt(out[0]) - Integer.parseInt(in[0])) * 60;
		
		if(Integer.parseInt(out[1]) >= Integer.parseInt(in[1])) {
			time += (Integer.parseInt(out[1]) - Integer.parseInt(in[1]));
		} else {
			time += (60 - Integer.parseInt(in[1]) + Integer.parseInt(out[1]));
			time -= 60;
		}
		
		return time;
				
	}

}
