package Mar_5;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 프로그래머스_Lv3_디스크컨트롤러_이예원 {

	public int solution(int[][] jobs) {

		int ans = 0;
		int end = 0; //수행되고난 직후의 시간
		int idx = 0; //jobs 배열의 인덱스
		int cnt = 0; //수행된 요청 갯수

		//요청시간 순으로 오름차순 정렬 
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		//처리시간 순으로 오름차순 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		//요청이 모두 진행될 때까지 반복
		while (cnt < jobs.length) {

			//하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
			while (idx < jobs.length && jobs[idx][0] <= end) {
				pq.add(jobs[idx++]);
			}

			//큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어옴 
			//(end를 요청의 가장 처음으로 맞춰줌)
			if (pq.isEmpty()) {
				end = jobs[idx][0];

			// 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
			} else {

				int[] temp = pq.poll();
				ans += temp[1] + end - temp[0];
				end += temp[1];
				cnt++;
			}
		}

		return ans / jobs.length;
	}

}
