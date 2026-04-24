import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= N ; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] r : road){
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }
        
        // 1번 마을에서 시작해서 배달이 가능한 마을의 개수
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        
        while(!q.isEmpty()){
            // 현재 위치랑, 현재까지 걸어온 거리
            int[] now = q.poll();
            
            for(int[] next : graph.get(now[0])){
                // next[0]이 다음, next[1]이 거리
                if(dist[next[0]] > now[1] + next[1] && dist[next[0]] != 0){
                    dist[next[0]] = now[1] + next[1];
                    q.offer(new int[]{next[0], now[1] + next[1]});
                }                 
            }
        }

        for(int d : dist){
            if(d <= K) answer++;
        }
        return answer;
    }
}