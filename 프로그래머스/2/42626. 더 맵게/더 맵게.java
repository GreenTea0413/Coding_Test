import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.offer(s);
        }
        
        while(pq.peek() < K){
            if (pq.size() < 2) return -1;
            int num1 = pq.poll();
            int num2 = pq.poll();
            
            pq.offer(num1 + num2 * 2);
            answer++;
        }
        return answer;
    }
}