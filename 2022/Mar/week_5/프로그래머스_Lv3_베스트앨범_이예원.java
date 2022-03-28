package Mar_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 프로그래머스_Lv3_베스트앨범_이예원 {

	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		
		//장르별 플레이 횟수 저장 
		for (int i = 0; i < genres.length; i++) {
			hmap.put(genres[i], hmap.getOrDefault(genres[i], 0)+plays[i]); 
		}
		
		//key값만 장르에 넣어주기 
		ArrayList<String> genre = new ArrayList<String>();
		
		for(String key : hmap.keySet()) {
			genre.add(key);
		}
		Collections.sort(genre, (o1,o2)->(hmap.get(o2)-hmap.get(o1)));
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < genre.size(); i++) {
            String Genres = genre.get(i);
            
            int idx1 = 0;
            int idx2 = 0;
            int max = 0;
            
            //첫번째 값 구하기 
            for(int j = 0; j < genres.length; j++) {
                if(Genres.equals(genres[j]) && plays[j] >max) { //높은 순으로 가져온 장르와 genres배열의 값이 같고 max와 비교해서 최대값 갱신 
                   max = plays[j];
                   idx1 = j;
                }
            }
            
            max = -1; 
            
            //두번째 값 구하기 
            for(int j = 0; j < genres.length; j++) { //두번째 값 구하기
                if(Genres.equals(genres[j]) && j != idx1 && plays[j] > max) {
                   max = plays[j];
                   idx2 = j;
                }
            }
            
            list.add(idx1); //제일 큰 값 추가
            
            if(max != -1) {
            	list.add(idx2); //다음 큰 값 추가
            }
        }
        
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        
        return result;
		

	}

}
