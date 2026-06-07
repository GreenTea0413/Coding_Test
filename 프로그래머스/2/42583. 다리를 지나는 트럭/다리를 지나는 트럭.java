import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 다리 완성
        int cur_weight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){bridge.offer(0);}
        
        int idx = 0;
        while(idx < truck_weights.length){
            cur_weight -= bridge.poll();
            int t = truck_weights[idx];
            // 트럭에서 제일 위에 있는 값 + 현재 다리 값 < weight보다 작으면 추가
            if(cur_weight + t <= weight){
                cur_weight += t;
                bridge.offer(t);
                idx ++;
            }
            else{
                bridge.offer(0);
            }
            answer++;
        }
        
        
        
        return answer + bridge_length;
    }
}