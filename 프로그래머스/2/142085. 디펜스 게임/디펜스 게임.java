import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {return b - a;});
        if(enemy.length == k){
            return k;
        }
        for(int i = 0; i < enemy.length; i++){
            n -= enemy[i];
            pq.offer(enemy[i]);
            answer++;
            
            if(n < 0){
                if (k > 0 && !pq.isEmpty()){
                    n += pq.poll();
                    k --;
                }
                else {
                    answer --;
                    break;
                }
            }
        }
        return answer;
    }
}