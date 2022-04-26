package Apr_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17178_줄서기_이예원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<String> order = new PriorityQueue<String>(new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				String[] tickets1 = o1.split("-");
				String[] tickets2 = o2.split("-");

				if(tickets1[0].equals(tickets2[0])) { //알파벳이 같다면 
					//숫자가 작은 순서대로 A-102보다 A-4가 더 빠르게
					return Integer.parseInt(tickets1[1]) - Integer.parseInt(tickets2[1]); //숫자가 작은 순서대로 
				} else {
					return tickets1[0].compareTo(tickets2[0]); //알파벳 순서대로
				}
			}
		});
		
		Queue<String> line = new LinkedList<>(); // 줄
		Stack<String> wait = new Stack<>(); // 대기 공간

		for(int n = 0; n < N; n++) {
		StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i = 0; i < 5; i++) {
				String ticket = st.nextToken();

				line.offer(ticket);
				order.offer(ticket);
			}
		}

		while(!order.isEmpty()) {
			String cur = order.poll(); // 들어가야 하는 사람의 티켓

			// 들어가야 하는 사람이 줄 맨 앞 사람도 아니고 대기 공간 마지막 사람도 아닌 경우 
			while((!line.isEmpty() && !cur.equals(line.peek())) && ((!wait.isEmpty() && !cur.equals(wait.peek())) || wait.isEmpty())) { 
				wait.add(line.poll()); // 대기 공간으로 이동
			}
			
			// 들어갈 차례인 사람이 줄 맨 앞에 있는 경우
			if(cur.equals(line.peek())) 
				line.poll();
			else if(!wait.isEmpty() && cur.equals(wait.peek())) // 대기 공간에 사람이 있고, 들어갈 차례인 사람이 대기 공간 마지막에 있는 경우
				wait.pop();
		}

		if(wait.isEmpty()) System.out.println("GOOD");
		else System.out.println("BAD");
	}

}