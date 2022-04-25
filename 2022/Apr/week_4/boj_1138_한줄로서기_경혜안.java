package May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_1138_한줄로서기_경혜안 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		ArrayList<Integer> order = new ArrayList<Integer>();
		String[] line = new String[num];
		line = bf.readLine().split(" ");
		
		for (int i = num-1; i >= 0; i--) {
			order.add(Integer.parseInt(line[i]), i+1);
		}
		
		for (int i : order) {
			System.out.print(i + " ");
		}
	}

}
