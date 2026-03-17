import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> {return b - a;});
        int sum = 0;
        int answer = 0;
        for(int l : list){
            sum += l;
            answer++;
            if (sum >= k) break;
        }
        
        
        return answer;
    }
}