import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long total= 0;
        for(int w : works){
            total += w;
            pq.offer(w);
        }
        
        if (total < n) {return 0;}
        
        while (n > 0){
            int max = pq.poll();
            max -= 1;
            pq.offer(max);
            n--;
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            long w = pq.poll();
            answer += w * w;
        }
        return answer;
    }
}