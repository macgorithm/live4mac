package May_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 프로그래머스_Lv1_신규아이디추천_이예원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String new_id = br.readLine();
		
		//step1
		String ans = new_id.toLowerCase();
		
		//step2
		ans = ans.replaceAll("[^-_.a-z0-9]", "");
		
		//step3
		ans = ans.replaceAll("[.]{2,}", ".");
		
		//step4
		ans = ans.replaceAll("^[.]|[.]$", ""); 
		
		//stpe5
        if (ans.equals("")) {
            ans += "a";
        }
		
        //step6
        if (ans.length() >= 16) {
        	ans = ans.substring(0, 15);
        	ans = ans.replaceAll("[.]$","");
        }
        
        //stpe7
        if (ans.length() <= 2) { 
            while (ans.length() < 3) {
            	ans += ans.charAt(ans.length()-1);
            }
        }
        
        System.out.println(ans);
	}	

}
