import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for(int[] r : road){
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }

        // 1번 마을에서 출발해서 K보다 작거나 같으면 배달가유~
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        // 번호, 거리
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[]{1, 0});
            
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            if(dist[now[0]] < now[1]) continue;
            
            for(int[] next : graph.get(now[0])){
                int nextDist = now[1] + next[1];
                if(dist[next[0]] > nextDist) dist[next[0]] = nextDist;
                pq.offer(new int[]{next[0], nextDist});
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K) answer ++;
        }
        return answer;
    }
}