import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 도착시간, 소요시간
        Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));
        
        // 작업 번호, 요청시각, 소요시간
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[2] == b[2]){
                if(a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });
        
        int len = jobs.length;
        int count = 0;
        int idx = 0;
        int time = 0;
        int answer = 0;
        
        while(count < len){
            // 도착 시간이 현재 시간보다 빠르면 pq에 다 넣어주기
            while(idx < len && jobs[idx][0] <= time){
                pq.offer(new int[]{idx, jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            
            if(!pq.isEmpty()){
                int[] now = pq.poll();
                time += now[2];
                answer += time - now[1];
                count ++;
            }
            else time = jobs[idx][0];
        }
        return answer / len;
    }
}