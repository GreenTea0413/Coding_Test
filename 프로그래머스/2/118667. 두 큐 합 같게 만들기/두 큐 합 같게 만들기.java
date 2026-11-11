import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int len = queue1.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < len; i++) {
            q1.offer(queue1[i]); q2.offer(queue2[i]);
            sum1 += queue1[i]; sum2 += queue2[i];
        }
        
        if((sum1 + sum2) % 2 != 0) return -1;
        if(sum1 == sum2) return 0;
        // 두 개의 큐가 계속 해서 각각 바꿔가면서 값 빼고 더했을 때 같아 지는가?
        while(answer < len * 2){
            // q1이 더 클 때 
            while(sum2 < sum1 && !q1.isEmpty()){
                int n = q1.poll();
                q2.offer(n);
                sum1 -= n;
                sum2 += n;
                answer++;
            }
            
            while(sum1 < sum2 && !q2.isEmpty()){
                int n = q2.poll();
                q1.offer(n);
                sum1 += n;
                sum2 -= n;
                answer++;
            }
            
            
            if(sum1 == sum2) return answer;
        }
        return -1;
    }
}