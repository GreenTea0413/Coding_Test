import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int w : works) {
            pq.offer(w);
            total += w;
        }
        
        if(n >= total) {return 0;}
        
        while(n > 0){
            int num = pq.poll();
            num--;
            n--;
            pq.offer(num);
        }
        
        for(int p : pq){
            answer += p * p;
        }
        return answer;
    }
}