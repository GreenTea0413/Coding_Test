import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 작업 번호, 요청시각, 소요시간
        // 우선순위가 가장 높은 -> 소요 시간 짧은거, 요청시각이 빠른거, 번호가 작은 순
        // 비선점이여서 못뺏음
        Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            if(a[2] == b[2]){
                if(a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });
        int idx = 0;
        int count = 0;
        int time = 0;
        int len = jobs.length;
        while(count < len){
            while(idx < len && jobs[idx][0] <= time){
                // 작업 번호, 요청시각, 소요시간
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