import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int len = jobs.length;
        int count = 0;
        int idx = 0;
        //도착하는 순서대로 정렬
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        // PQ는 도착 순서 전에 실행 가는 한 것들을 기준으로 실행시간 빠른거 먼저
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        while(count < len){
            //도착한 애들 넣기 
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