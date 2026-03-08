import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        long total = 0;
        long sum1 = 0;
        long sum2 = 0;
        long answer = 0;
        Queue<Integer>q1 = new LinkedList<>();
        Queue<Integer>q2 = new LinkedList<>();
        
        for(int i = 0; i < len; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
            total += queue1[i] + queue2[i];
        }
        
        if(total % 2 == 1){return -1;}
        if(sum1 == sum2) {return 0;}
        
        while(answer < len * 2){
            while(!q1.isEmpty() && sum1 > sum2){
                int n = q1.poll();
                q2.offer(n);
                sum1 -= n;
                sum2 += n;
                answer++;
            }
            while(!q2.isEmpty() && sum2 > sum1){
                int m = q2.poll();
                q1.offer(m);
                sum1 += m;
                sum2 -= m;
                answer++;
            }
            if (sum1 == sum2){
                return (int) answer;
            }
        }
        
        return -1;
    }
}