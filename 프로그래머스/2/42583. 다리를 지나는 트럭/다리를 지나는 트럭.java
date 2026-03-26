import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cur_weight = 0;
        // 다리 길이 미리 정하기
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {bridge.offer(0);}
        
        // 이제 트럭 위치를 기반으로 하나씩 보내기
        // 추가로 하나씩 0을 넣으면 알아서 한칸씩 이동하는 느낌임 (대박)
        int idx = 0;
        while(idx < truck_weights.length){
            cur_weight -= bridge.poll();
            answer ++;
            
            int t = truck_weights[idx];
            if (cur_weight +  t<= weight){
                bridge.offer(t);
                cur_weight += t;
                idx ++;
            }
            else{
                bridge.offer(0);
            }
        }
        
        answer += bridge_length;
        return answer;
    }
}