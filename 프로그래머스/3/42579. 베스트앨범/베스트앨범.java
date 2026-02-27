import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // [장르, [고유번호, 횟수]] -> [String, [Integer, Integer]]
        Map<String, List<int[]>> map = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        int len = plays.length;
        for (int i = 0; i < len; i++){
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            
            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        List<String> list = new ArrayList<>(total.keySet());
        list.sort((a, b) -> total.get(b) - total.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        for(String l : list){
            List<int[]> song = map.get(l);
            
            song.sort((a,b) -> {
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                else 
                    return b[1] - a[1];
            });
                
            int count = 0;
            for (int[] s : song) {
                answer.add(s[0]);
                count++;
                if (count == 2) break;
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}