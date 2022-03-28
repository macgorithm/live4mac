package Mar_2022.week4;

import java.util.*;

public class programmers_디스크컨트롤러_손수연 {
	
	static class Job implements Comparable<Job> {
		int request, ing;
		Job(int request, int ing) {
			this.request = request; // 요청시각
			this.ing = ing; // 소요시간
		}
		
		public int compareTo(Job o) {
			return this.request-o.request;
		}
	}
	
	public int solution(int[][] jobs) {
		int now = 0; // 현재시각
		int answer = 0;
		
		int finish = 0; // 수행된 작업 개수
		int N = jobs.length; // 작업의 총 개수
		
		PriorityQueue<Job> possibleQueue = new PriorityQueue<>();
		PriorityQueue<Job> jobsQueue = new PriorityQueue<>();
        for(int n = 0; n < N; n++) jobsQueue.offer(new Job(jobs[n][0], jobs[n][1]));
        
        while(finish < N) {
        	while(!jobsQueue.isEmpty() && jobsQueue.peek().request<=now) { // 수행해도 되는 경우
        		Job job = jobsQueue.poll();
        		possibleQueue.offer(new Job(job.ing, job.request));
        	}
        	
        	if(possibleQueue.isEmpty()) { // 수행할 수 있는 작업이 없는 경우
        		now = jobsQueue.peek().request;
        		continue;
        	}
        	
        	Job cur = possibleQueue.poll();
        	int curRequest = cur.ing;
        	int curIng = cur.request;
        	
        	answer += (now-curRequest)+curIng; // 수행하기까지 걸린 시간 누적
        	now += curIng;
        	finish++;
        }
        
        return answer / N;
    }
}