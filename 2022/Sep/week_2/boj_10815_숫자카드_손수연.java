package Sep_2022;

import java.io.*;
import java.util.*;

public class Main_BJ_10815_숫자카드 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.valueOf(st.nextToken());
        
        Arrays.sort(arr);
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) {
            if (Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) // 이분탐색
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");     
        }
        
        System.out.println(sb);
	}
}