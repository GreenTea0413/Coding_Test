import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        // 전체
        // int[] -> 고유번호, 플레이 횟수
        Map<String, Integer> total = new HashMap<>();
        Map<String, List<int[]>> play = new HashMap<>();
        
        for(int i = 0; i < len; i++){
            String g = genres[i];
            int p = plays[i];
            
            total.put(g, total.getOrDefault(g, 0) + p);
            
            play.putIfAbsent(g, new ArrayList<>());
            play.get(g).add(new int[]{i, p});
        }
        
        List<String> genKey = new ArrayList<>(total.keySet());
        genKey.sort((a,b) -> total.get(b) - total.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        for(String gen : genKey){
            List<int[]> list = play.get(gen);
            list.sort((a,b) -> {
                if(a[1] == b[1]) return a[0] - b[0];
                return b[1] - a[1];
            });
            
            int count = 0;
            for(int[] l : list){
                answer.add(l[0]);
                count++;
                
                if(count == 2){
                    break;
                }
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}