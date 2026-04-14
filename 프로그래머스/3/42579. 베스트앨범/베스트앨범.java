import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, List<int[]>> map = new HashMap<>();
        
        int len = plays.length;
        for(int i = 0; i < len; i++){
            String gen = genres[i];
            int p = plays[i];
            
            total.put(gen, total.getOrDefault(gen, 0) + p);
            
            map.putIfAbsent(gen, new ArrayList<>());
            map.get(gen).add(new int[]{i, p});
        }
        
        List<String> genKey = new ArrayList<>(total.keySet());
        genKey.sort((a, b) -> {return total.get(b) - total.get(a);});
        
        List<Integer> answer = new ArrayList<>();
        
        for(String key : genKey){
            // 고유번호랑 플레이 시간 가져오기
            List<int[]> playList = map.get(key);
            
            playList.sort((a, b) -> {
                // 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
                if(a[1] == b[1]) return a[0] - b[0];
                return b[1] - a[1];
            });
            
            int count = 0;
            for(int[] play : playList){
                answer.add(play[0]);
                count++;
                
                if(count == 2) break;
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}