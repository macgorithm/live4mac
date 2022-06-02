package May_2022.week4;

public class Solution_Programmers_62048_멀쩡한사각형 {

	public long solution(int w, int h) {
		
        double grade = (double)w / h; // 기울기
        long cnt = 0;
        
        for(int i = 1; i < h; i++)
            cnt += (long)Math.floor(grade * i);
        
        return cnt * 2;
    }
}
