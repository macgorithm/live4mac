package Apr_2022.week4;

import java.io.*;
import java.util.*;

public class boj_17178_줄서기_손수연 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 줄에서 기다리고 있는 사람들의 줄 수
		PriorityQueue<String> order = new PriorityQueue<>(new Comparator<String>() { // 모든 사람의 티켓
			public int compare(String o1, String o2) {
				String[] ticket1 = o1.split("-");
				String[] ticket2 = o2.split("-");
				
				if(!ticket1[0].equals(ticket2[0])) return ticket1[0].charAt(0) - ticket2[0].charAt(0); // 알파벳 순서대로
				else return Integer.parseInt(ticket1[1]) - Integer.parseInt(ticket2[1]); // 알파벳이 같다면 숫자가 작은 순서대로
			}
		});  
		Queue<String> line = new LinkedList<>(); // 줄
		Stack<String> wait = new Stack<>(); // 대기 공간
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 5; i++) {
				String ticket = st.nextToken();
						
				line.offer(ticket);
				order.offer(ticket);
			}
		}
		
		while(!order.isEmpty()) {
			String cur = order.poll(); // 들어가야 하는 사람의 티켓
			
			while((!line.isEmpty() && !cur.equals(line.peek())) && ((!wait.isEmpty() && !cur.equals(wait.peek())) || wait.isEmpty())) { // 들어가야 하는 사람이 줄 맨 앞 사람도 아니고 대기 공간 마지막 사람도 아닌 경우 
				wait.add(line.poll()); // 대기 공간으로 이동
			}
			
			if(cur.equals(line.peek())) // 들어갈 차례인 사람이 줄 맨 앞에 있는 경우
				line.poll();
			else if(!wait.isEmpty() && cur.equals(wait.peek())) // 대기 공간에 사람이 있고, 들어갈 차례인 사람이 대기 공간 마지막에 있는 경우
				wait.pop();
		}
		
		if(wait.isEmpty()) System.out.println("GOOD");
		else System.out.println("BAD");
	}
}
