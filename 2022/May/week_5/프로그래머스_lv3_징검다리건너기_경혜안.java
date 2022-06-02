package May;

public class 프로그래머스_lv3_징검다리건너기_경혜안 {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3, answer = 0;
		int min = 0, max = 200000000;
		
		while(min <= max) {
			int mid = (min+max)/2;
			
			if(checkCnt(stones, k, mid)) { // 건널 수 있는가를 확인 
				min = mid + 1;
				answer = Math.max(answer, mid);
			} else {
				max = mid -1 ;
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean checkCnt(int[] s, int k, int mid) {
		int cnt = 0; 
		
		for (int i : s) {
			if (i - mid < 0) { // 징검다리를 건널 수 없다면 
				cnt++;
			} else { // 건널 수 있다면 다시 초기화 
				cnt = 0; 
			}
			
			if(cnt == k) return false; // 건널수 없음을 반환 
		}
		return true;
	}
	

}
