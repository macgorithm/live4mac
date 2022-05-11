package May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10881_프로도의선물포장_경혜안 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < T; i++) {
			
			int[] width = new int[6];
			int[] height = new int[6];
			
			for (int j = 0; j < 3; j++) {
				
				String[] temp = bf.readLine().split(" ");
				width[j] = height[j+3] = Integer.parseInt(temp[0]);
				height[j] = width[j+3] = Integer.parseInt(temp[1]);
			}
			
			int min = Integer.MAX_VALUE;
			
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 6; k++) {
					for (int l = 0; l < 6; l++) {
						if(j%3 == k%3 || j%3 == l%3 || k%3 == l%3) continue;
						
						int w = Math.max(width[j] + width[k], width[l]);
						int h = Math.max(height[j], height[k]) + height[l];
						
						min = Math.min(min, w*h);
						
						int line = (width[j] + width[k] + width[l]) * Math.max(Math.max(height[j], height[k]), height[l]) ;
						
						min = Math.min(min, line);
					}
				}
			}
			
			System.out.println(min);
			
		}

	}

}
