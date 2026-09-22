import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        // 요청 시간 대로 먼저 오도록 일단 배치하기
        Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));
        
        // 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높음
        // [작업이 요청되는 시점, 작업의 소요시간]
        // pq -> [작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) return a[2] - b[2];
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
    
        // pq에 하나도 담지 않은 상태에서 시작하면 되는거 아닌가?
        // idx 늘려가면서 하나씩 꺼내고 pq에 비어있으면 그냥 pq에 넣고
        // 만약에 pq가 있다면?
        // pq의 최상단에 있는 작업 시간과 비교해서 작업시간이 작다면 q.poll하기
        int time = 0;
        int idx = 0;
        int count = 0;
        
        // 시작하면 작업을 마칠 때까지 그 작업만 수행합니다.
        // pq -> [작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것]
        // now = [요청 시각, 소요시간]
        while(count < len){
            // 현재 인덱스의 요청시각이 time보다 작으면 다 추가하기
            while(idx < len && jobs[idx][0] <= time){
                pq.offer(new int[]{jobs[idx][1], jobs[idx][0], idx});
                idx++;
            }
            
            // 그러고 현재 시각에 대해서 q가 하나라도 있으면 걔 작업 시켜야함
            if(!pq.isEmpty()){
                int[] now = pq.poll();
                count++;
                time += now[0];
                answer += time - now[1];
            }
            // 없으면 지금 젤 빨리 요청 온 값을 time에 대입
            else{
                time = jobs[idx][0];
            }
        }
        
        return answer / len;
    }
}