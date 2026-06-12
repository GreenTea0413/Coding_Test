import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        long total = 0;
        int len = works.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {return b - a;});
        for(int w : works){
            total += w; 
            pq.offer(w);
        }
        
        if(total < n) return 0;
        
        while(n > 0){
            int num = pq.poll();
            num -= 1;
            pq.offer(num);
            n --;
        }
        
        for(int p : pq){
            answer += p * p;
        }
        return answer;
    }
}