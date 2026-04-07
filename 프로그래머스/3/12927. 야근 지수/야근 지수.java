import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        // 남은 일의 제곱량의 합
        // n은 내가 지금 할 수 있는 작업
        // 그러면 works에 값에서 n만큼 빼서 최솟값을 반환
        // [4, 3, 3] -> [2, 2, 2] -> 12
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {return b-a;});
        for(int work : works){
            pq.offer(work);
        }
        
        while(n > 0){
            int num = pq.poll();
            
            if(num == 0) break;
            pq.offer(num - 1);
            n--;
        }
        
        for(int num : pq){
            answer += num * num;
        }
        return answer;
    }
}