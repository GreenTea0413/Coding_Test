import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long answer = 0;
        // 다 합치면 30이고
        // 하나당 15가 되어야함
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        int len = queue1.length;
        long sum1 = 0;
        long sum2 = 0;
        long total = 0;
        for(int i = 0; i < len; i++) {
            long n1 = queue1[i];
            long n2 = queue2[i];
            
            q1.offer(n1);
            q2.offer(n2);
            
            sum1 += n1;
            sum2 += n2;
        }
        total = sum1 + sum2;
        
        if(total % 2 != 0) return -1;
        if(sum1 == sum2) return 0;
            
        while(answer < len * 2){
            // 큐1이 더 크면?
            while(!q1.isEmpty() && sum1 > sum2){
                long n = q1.poll();
                sum1 -= n;
                sum2 += n;
                q2.offer(n);
                answer++;
            }
            while(!q2.isEmpty() && sum2 > sum1){
                long n = q2.poll();
                sum1 += n;
                sum2 -= n;
                q1.offer(n);
                answer++;
            }
            
            if(sum1 == sum2) return (int) answer;
            
        }
        
        
        return (int) -1;
    }
}