import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();
        // [고유번호, 횟수]
        Map<String, List<int[]>> play = new HashMap<>();
        int len = plays.length;
        
        for(int i = 0; i < len; i++){
            String g = genres[i];
            int p = plays[i];
            
            total.put(g, total.getOrDefault(g, 0) + p);
            play.putIfAbsent(g, new ArrayList<>());
            play.get(g).add(new int[]{i, p});
        }
        
        List<String> genre = new ArrayList<>(total.keySet());
        genre.sort((a, b) -> {return total.get(b) - total.get(a);});
        
        List<Integer> answer = new ArrayList<>();
        for(String g : genre){
            int count = 0;
            
            List<int[]> list = new ArrayList<>(play.get(g));
            list.sort((a, b) -> {return b[1] - a[1];});
            
            for(int[] arr : list){
                answer.add(arr[0]);
                count++;
                if(count == 2){break;}
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}