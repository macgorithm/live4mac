package Mar_2022.week4;

import java.util.*;

class programmers_베스트앨범_손수연 {
    
    public static class Song implements Comparable<Song> {
		String genre;
		int no, plays;
		Song(int no, String genre, int plays){
			this.no = no; // 고유번호
			this.genre = genre; // 장르
			this.plays = plays; // 재생횟수
		}
		
		public int compareTo(Song o) {
			return o.plays-this.plays; // 재생횟수 기준 내림차순
		}
    }
        
    public int[] solution(String[] genres, int[] plays) {
        int size = genres.length;
		
		Song[] songs = new Song[size];
		TreeMap<String, Integer> genreMap = new TreeMap<>(); // 장르, 장르 당 총 재생횟수
		ArrayList<Integer> answerList = new ArrayList<>();
		
		for(int i = 0; i < genres.length; i++) {
			songs[i] = new Song(i, genres[i], plays[i]); // 노래 정보 추가
			int value = plays[i];
            
			if(genreMap.containsKey(genres[i])) // 등록된 장르인 경우
				value += genreMap.get(genres[i]);
			
			genreMap.put(genres[i], value);
		}
	
		Arrays.sort(songs); // 재생횟수 기준 내림차순 정렬
		
		Song[] genreArr = new Song[genreMap.size()];
		int idx = 0;
        
		while(genreMap.size() != 0) { // TreeMap(genreMap)을 배열(genreArr)로 변환
			String key = genreMap.firstKey();
			
			genreArr[idx++] = new Song(-1, key, genreMap.get(key));
			genreMap.remove(key);
		}
        
		Arrays.sort(genreArr); // 재생횟수 기준 내림차순 정렬
		
		for(int i = 0; i < genreArr.length; i++) {
			String key = genreArr[i].genre; // 장르
			int cnt = 0; // 장르 당 수록된 노래 개수
			
			for(int j = 0; j < size; j++) {
				if(cnt == 2) break;
				
				if(songs[j].genre.equals(key)) {
					answerList.add(songs[j].no); // 수록
					cnt++;
				}
			}
		}
		
		int[] answer = new int[answerList.size()];
		for(int i = 0; i < answerList.size(); i++) answer[i] = answerList.get(i); // ArrayList를 배열로 변환
		
		return answer;
    }
}