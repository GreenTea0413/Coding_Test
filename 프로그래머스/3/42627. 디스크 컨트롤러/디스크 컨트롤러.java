import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 이러면 일단 요청 시간이 빠른 순으로 넣기
        Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));
        
        // 우선순위 -> 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[2] == b[2]){
                if(a[1] == b[1]) return a[0] - b[0];
                else return a[1] - b[1];
            }
            return a[2] - b[2];
        });
        
        int time = 0;
        int answer = 0;
        int len = jobs.length;
        int idx = 0;
        int count = 0;
        // 작업의 번호, 요청시간, 소요시간
        while(count < len){
            // 일단 바로 넣고 여기서 time이랑 현재 들어온 값의 요청시간 call과 time이 맞는지 비교
            // 비교해서 바로 넣기
            while(idx < len && jobs[idx][0] <= time){
                pq.offer(new int[]{idx, jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            
            // 그럼 현재 시간에 맞게 들어온 것들이 있을거임
            // 0,0,3
            // 2 3 5
            // 1 1 9
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