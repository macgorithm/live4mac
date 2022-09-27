package Sep_2022;

import java.util.*;

public class Solution_Programmers_43238_입국심사 {
	
	class Judge implements Comparable<Judge> {
        int time;
        long endTime;
        
        Judge(int time, long endTime){
            this.time = time;
            this.endTime = endTime;
        }
        
        public int compareTo(Judge o){
            if((this.time+this.endTime) == (o.time+o.endTime) && this.time<o.time) return -1;
            else if((this.time+this.endTime) < (o.time+o.endTime)) return -1;
            else return 1;
        }
    }
	    
    public long solution(int n, int[] times) {
        long time = 0;
        PriorityQueue<Judge> judges = new PriorityQueue<>();
        
        for(int i : times) judges.offer(new Judge(i, 0));
        
        while(n-- > 0){
            Judge cur = judges.poll();
            
            time = Math.max(time, cur.time+cur.endTime);

            judges.offer(new Judge(cur.time, cur.endTime+cur.time));
        }
        
        return time;
    }
}