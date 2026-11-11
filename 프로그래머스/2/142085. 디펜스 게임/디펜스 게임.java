import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int count = n;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int i = 0; i < enemy.length; i++){
            count -= enemy[i];
            pq.offer(enemy[i]);
            
            while(count < 0 && k > 0 && !pq.isEmpty()){
                count += pq.poll();
                if(n < count) count = n;
                k --;
            }
            
            if(count < 0) break;
            answer ++;
        }
        return answer;
    }
}