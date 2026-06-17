import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int idx = 0;
        int count = 0;
        int len = jobs.length;
        int time = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return a[1] - b[1];});
        
        while(count < len){
            while(idx < len && jobs[idx][0] <= time){
                pq.offer(new int[]{jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            
            if(!pq.isEmpty()){
                int[] now = pq.poll();
                time += now[1];
                answer += time - now[0];
                count++;
            }
            else{
                time = jobs[idx][0];
            }
        }
        
        return answer / len;
    }
}