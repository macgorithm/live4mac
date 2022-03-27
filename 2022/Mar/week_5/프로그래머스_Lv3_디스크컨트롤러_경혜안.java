package Mar;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 프로그래머스_Lv3_디스크컨트롤러_경혜안 {
	static class Job {
		int req;
		int work;
		
		public Job(int req, int work) {
			this.req = req;
			this.work = work;
		}
	}
	
	static class shortWaiting implements Comparator<Job> {
		public int compare(Job j1, Job j2) {
			return j1.req - j2.req;
		}
	}
	
	static class shortWorking implements Comparator<Job> {
		public int compare(Job j1, Job j2) {
			return j1.work - j2.work;
		}
	}
	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		
		PriorityQueue<Job> wait = new PriorityQueue<Job>(new shortWaiting());
		
		for (int[] j: jobs) {
			wait.add(new Job(j[0], j[1]));
		}
		
		int cnt = 0; 
		int total = 0; 
		int cur = wait.peek().req;
		
		PriorityQueue<Job> work = new PriorityQueue<Job>(new shortWorking());
		while(cnt < jobs.length) {
			while(!wait.isEmpty() && cur >= wait.peek().req) {
				work.add(wait.poll());
			}
			
			if(!work.isEmpty()) {
				Job j = work.poll();
				
				cur += j.work;
				total += cur - j.req;
				cnt++;
			} else {
				cur++;
			}
		}
		
		System.out.println(total / cnt);
	}
	

}
