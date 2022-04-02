package Mar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 프로그래머스_Lv3_베스트앨범_경혜안 {
	static class Music implements Comparable<Music> {
		int idx; 
		int cnt;
		
		Music (int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
		
		public int compareTo(Music o) {
			if(this.cnt == o.cnt) {
				return this.idx - o.idx;
			}
			return o.cnt - this.cnt;
		}
	}
	public static void main(String[] args) {
		
		// temp inputs
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		Map<String, Integer> genre = new HashMap<String, Integer>();
		Map<String, ArrayList<Music>> list = new HashMap<String, ArrayList<Music>>();
		for (int i = 0; i < genres.length; i++) {
			String g = genres[i];
			if(genre.containsKey(g)) genre.put(g, genre.get(g) + plays[i]);
			else genre.put(g, plays[i]);
			
			if(list.containsKey(g)) {
				ArrayList<Music> temp = list.get(g);
				temp.add(new Music(i, plays[i]));
				list.put(g, temp);
			} else {
				ArrayList<Music> temp = new ArrayList<Music>();
				temp.add(new Music(i, plays[i]));
				list.put(g, temp);
			}
		}
		
		List<Map.Entry<String, Integer>> eList = new LinkedList<>(genre.entrySet());
		eList.sort(new Comparator<Map.Entry<String, Integer>>() {
		    @Override
		    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
			return o2.getValue() - o1.getValue();
		    }
		});
		
		for (String key : list.keySet()) {
			Collections.sort(list.get(key));
		}
		for (Map.Entry<String, Integer> entry : eList) {
			ArrayList<Music> print = list.get(entry.getKey());
			for (int i = 0; i < 2 && i < print.size() ; i++) {
				System.out.println(print.get(i).idx);
			}
		}
		
		

	}

}
