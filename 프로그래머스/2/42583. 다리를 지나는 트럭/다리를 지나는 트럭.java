import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int len = truck_weights.length;
        int idx = 0;
        int sum = 0;
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){q.offer(0);}
        
        while(idx < len){
            int t = truck_weights[idx];
            sum -= q.poll(); 
                 
            if(sum + t <= weight){
                sum += t;
                q.offer(t);
                idx++;
            }
            else{
                q.offer(0);
            }
            answer++;
        }
        return answer + bridge_length;
    }
}