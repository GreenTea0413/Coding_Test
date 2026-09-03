import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int idx = 0;
        int sum = 0;
        int len = truck_weights.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) q.offer(0);
        
        // q에다가 다리 길이만큼 0 넣어놓기
        // 그리고 이제 1초 지날때 마다 하나씩 앞당겨지는 구조로 계산
        while(idx < len){
            // 처음에 q 젤 앞에 있는거 빼고 다음꺼 넣을건데 만약에 합이 더 크면 못넣고 아니면 넣고
            sum -= q.poll(); 
            int num = truck_weights[idx];
        
            // 무게 넘어가면 그냥 넘어가기
            if(sum + num > weight) q.offer(0);
            // 무게 안넘어가면 그대로 넣어주고 합도 다시 추가
            else{ 
                q.offer(num); 
                sum += num;
                idx++;
            }
            answer++;
        }
        return answer + bridge_length;
    }
}