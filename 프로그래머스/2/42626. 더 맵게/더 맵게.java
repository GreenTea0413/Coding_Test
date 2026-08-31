import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {return a - b;});
        
        for(int s : scoville) pq.offer(s);
        
        while(true){
            boolean check = false;
            for(int p : pq) if(p < K) {check = true; break;}
            
            if(!check) break;
            if(pq.size() < 2) break;
            
            int n1 = pq.poll();
            int n2 = pq.poll();
            int num = n1 + n2 * 2;
            pq.offer(num);
            answer ++;
        }
        
        if(pq.peek() < K) return -1;
        return answer;
    }
}