package Jun;

import java.util.ArrayList;

public class 프로그래머스_lv2_기능개발_경혜안 {

	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		int day = leftDays(progresses[0] , speeds[0]); 
		int cnt = 0;
		for (int i = 0; i < speeds.length; i++) {
			
			if(progresses[i] + (day * speeds[i]) >= 100) {
				cnt++;
			} else {
				ans.add(cnt);
				day = leftDays(progresses[i] , speeds[i]);
				cnt = 1;
			}
		}
		ans.add(cnt);
		int[] answer = new int[ans.size()];
		
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
			System.out.println(answer[i]);
		}
		
	}
	
	static int leftDays(int p, int s) {
		int mod = (100-p) / s;
		
		if((100-p) % s == 0) return mod;
		else return mod+1;
	}
	

}
