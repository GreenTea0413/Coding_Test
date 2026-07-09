import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Set<String> genre = new HashSet<>();
        Map<String, List<int[]>> play = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            String g = genres[i];
            int p = plays[i];
            
            total.put(g, total.getOrDefault(g, 0) + p);
            play.putIfAbsent(g, new ArrayList<>());
            play.get(g).add(new int[]{i, p});
        }
        
        List<String> key = new ArrayList<>(total.keySet());
        key.sort((a, b) -> total.get(b) - total.get(a));
        
        for(String k : key){
            int count = 0;
            List<int[]> list = new ArrayList<>(play.get(k));
            list.sort((a, b) -> (b[1] - a[1]));
            for(int[] l : list){
                if(count == 2) {break;}
                answer.add(l[0]);
                count++;
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}