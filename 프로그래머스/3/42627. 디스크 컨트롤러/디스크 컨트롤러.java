import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[2] == b[2]) {
                if(a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });
                                                      
           
        int time = 0;
        int idx = 0;
        int count = 0;
        int len = jobs.length;
        int answer = 0;
        // pq = 요청번호, 요청 시각, 소요 시간
        // jobs = 요청 시각, 소요 시간
        while(count < len){
            while(idx < len && jobs[idx][0] <= time){
                pq.offer(new int[]{idx, jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            
            if(!pq.isEmpty()){
                int[] now = pq.poll();
                time += now[2];
                answer += time - now[1];
                count++;
            }
            else{
                time = jobs[idx][0];
            }
        }
        
        return answer / len;
    }
}