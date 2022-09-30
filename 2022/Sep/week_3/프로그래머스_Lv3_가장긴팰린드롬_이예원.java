package Sep_3;

public class 프로그래머스_Lv3_가장긴팰린드롬_이예원 {

	public static void main(String[] args) {
		String s = "abcdcba";
		int answer = 0;
		
		char[] ch = s.toCharArray();
		
		
		for (int length =  s.length(); length >1; length--) {
			
			for (int start = 0; start+length <= s.length(); start++) {
				boolean check =true;
				
				for (int j = 0; j < length/2; j++) {
					if(ch[start+j] != ch[start+length-j-1]) {
						check = false;
						break;
					}
				}
				if(check) System.out.println(length);
//				if(check) return length;
			}
		}
		
//		return 1;
		System.out.println(1);

	}

}
