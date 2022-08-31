package Aug_2022.week5;

import java.util.*;

public class 프로그래머스_lv2_두큐합같게만들기_손수연 {
	public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);
        }

        for(int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }

        int count = 0;
        
        while(sum1 != sum2) {
            count++;

            if(sum1 > sum2) {
                int value = q1.poll();
                sum1 -= value;
                sum2 += value;
                q2.offer(value);
            } else {
                int value = q2.poll();
                sum1 += value;
                sum2 -= value;
                q1.offer(value);
            }

            if(count > (queue1.length + queue2.length) * 2) return -1;
        }

        return count;
    }
}