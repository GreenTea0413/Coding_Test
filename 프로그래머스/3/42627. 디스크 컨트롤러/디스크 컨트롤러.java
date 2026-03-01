import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        // 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위
        // 시간 같으면 요청 시각
        // 요청 시각 같으면 번호 작은거
        int time = 0;
        int idx = 0;
        int count = 0;
        int answer = 0;
        int len = jobs.length;
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        
        while (count < len){
            while (idx < len && jobs[idx][0] <= time){
                pq.offer(jobs[idx]);
                idx ++;
            }
            
            
            if (!pq.isEmpty()) {
                int[] now = pq.poll();
                time += now[1];              
                answer += time - now[0];        
                count++;
            } else {
                time = jobs[idx][0];
            }
        }
        
        return answer / len;
    }
}