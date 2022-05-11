package May;

import java.util.regex.Pattern;

public class 프로그래머스_신규아이디추천_경혜안 {

	public static void main(String[] args) {
		String new_id = "z-+.^.";
		
		new_id = lv1(new_id);
		new_id = lv2(new_id);
		new_id = lv3(new_id);
		new_id = new_id.length() == 0 ? new_id : lv4_1(new_id);
		new_id = new_id.length() == 0 ? new_id : lv4_2(new_id);
		new_id = new_id.length() == 0 ? "a" : new_id;
		new_id = new_id.length() > 15 ? new_id.substring(0,15) : new_id;
		new_id = lv4_2(new_id);
		new_id = new_id.length() <= 2 ? lv7(new_id) : new_id ;
		System.out.println(new_id);
		
	}
	
	static String lv1(String old) {
		return old.toLowerCase();
	}
	
	static String lv2(String old) {
		StringBuilder sb = new StringBuilder();
		String pattern = "^[0-9a-z\\.\\-\\_]*$";
		boolean regex;
		
		for (char c : old.toCharArray()) {
			regex = Pattern.matches(pattern, Character.toString(c));
			if(regex) sb.append(c);
		}
		
		return sb.toString();
	}
	
	static String lv3(String old) {
		while(old.contains("..")) {
			old = old.replace("..", ".");
		}
		
		return old;
	}
	
	static String lv4_1(String old) {
		
		if(old.charAt(0) == '.')  old = old.substring(1);
		
		return old;
	}
	
	static String lv4_2(String old) {
		
		int len= old.length();
		if(old.charAt(len-1) == '.') old = old.substring(0,len-1);
		
		return old;
	}
	
	static String lv7(String old) {
		
		StringBuilder sb = new StringBuilder(old);
		int len = old.length();
		
		String last = Character.toString(old.charAt(len-1));

		while(sb.length() < 3) {
			sb.append(last);
		}
		
		return sb.toString();
	}
	
}
