package Sep_2022;

public class Solution_Programmers_12904_가장긴팰린드롬 {
	
	public int solution(String s) {
        int ret = 1;
        
		for(int i = 0 ; i < s.length()-1; i++)
			ret = Math.max(ret, Math.max(calculate(i, i, s), calculate(i, i+1, s)));
		
		return ret;
    }
	
    public int calculate(int start, int end, String str) {
		while(start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
			start--;
			end++;
		}
		
		return end - start - 1;
	}
}
