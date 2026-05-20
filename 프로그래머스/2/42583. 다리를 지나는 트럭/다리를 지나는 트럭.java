import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){q.offer(0);}
        
        int idx = 0;
        int cur_weight = 0;
        int answer = 0;
        // 끝 시작
        // 0  0 -> 0  7
        // 0  7
        // 7  0
        // 1초마다 한칸씩 앞으로 가서 처리한다고 보면됨
        while(idx < truck_weights.length){
            cur_weight -= q.poll();
            int t = truck_weights[idx];
            
            if(cur_weight + t <= weight){
                cur_weight += t;
                q.offer(t);
                idx++;
            }
            else{
                q.offer(0);
            }
            answer++;
        }
        // 우리는 한칸씩 앞으로 가면서 값을 계산했고 이제 다 빠져나왔을 경우에 다리길이 더해주면 끝
        return answer + bridge_length;
    }
}