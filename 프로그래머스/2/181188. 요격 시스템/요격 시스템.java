import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // A나라는 가로로 좌표가 주어지는데
        // B나라는 세로로 해서 그 범위 사이를 최소한으로 막아야함
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {return a[1] - b[1];}
            return a[0] - b[0];
        });
        for(int[] target : targets){
            pq.offer(target);
        }
        int start = 0;
        int end = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            start = now[0];
            end = now[1];
            
            while(!pq.isEmpty() && pq.peek()[0] < end){
                int[] next = pq.poll();
                end = Math.min(end, next[1]);
            }
            
            answer ++;
        }
        
        return answer;
    }
}