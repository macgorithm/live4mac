package May;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17178_줄서기_경혜안 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		
		String[][] line = new String[n][5];
		
		PriorityQueue<String> order = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] t1 = o1.split("-");
				String[] t2 = o2.split("-");
				
				if(t1[0].equals(t2[0])) { // 알파벳이 같다면 
					return Integer.parseInt(t1[1]) - Integer.parseInt(t2[1]);
				} else {
					return t1[0].compareTo(t2[0]);
				}
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			
			for (int j = 0; j < 5; j++) {
				String ticket = st.nextToken();
				
				line[i][j] = ticket;
				order.add(ticket);
				
			}
		}
		
		Stack<String> wait = new Stack<String>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 5; j++) {
				String now = line[i][j];
				
				while(!wait.empty() && !order.isEmpty() && wait.peek().equals(order.peek())) {
					wait.pop();
					order.poll();
				} 
				
				if(order.peek().equals(now)) {
					order.poll();
				} else {
					wait.push(now);
				}
				
				
			}
		}
		
		while(!wait.empty()) {
			if(wait.peek().equals(order.peek())) {
				order.poll();
				wait.pop();
			} else {
				System.out.println("BAD");
				return;
			}
		}
		
		System.out.println("GOOD");
		
		

	}

}