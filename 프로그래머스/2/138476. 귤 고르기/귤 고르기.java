import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int t :tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        // 1,1 2,2 3,2 4,1 5,2
        for(int key : map.keySet()) pq.offer(map.get(key));
        
        while(k > 0){
            if(!pq.isEmpty()){
                k -= pq.poll();
                if(k <= 0){
                    answer++;
                    return answer;
                }
                answer++;
                
            }
            else break;
        }
    
        return answer;
    }
}