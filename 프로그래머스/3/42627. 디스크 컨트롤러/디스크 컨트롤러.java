import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        // 정렬 순서 : 1. 소요시간 2. 시각 3. 번호
        // 딱 하나만
        // 종료한 시점에서 들어온게 겹치면 우선순위대로 먼저 작업 시키기
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){
                if(a[1] == b[1]) return a[2] - b[2];
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int time = 0;
        int count = 0;
        int idx = 0;
        
        while(count < len){
            while(idx < len && jobs[idx][0] <= time){
                // 정렬 순서 : 1. 소요시간 2. 시각 3. 번호
                pq.offer(new int[]{jobs[idx][1], jobs[idx][0], idx});
                idx++;
            }
            
            if(!pq.isEmpty()){
                int[] now = pq.poll();
                count++;
                time += now[0];
                answer += time - now[1];
            }
            else{
                time = jobs[idx][0];
            }
        }
        
        return answer / len;
    }
}