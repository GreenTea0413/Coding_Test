import java.util.*;

class Solution {
    List<List<int[]>> graph = new ArrayList<>();
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int[] p : paths){
            graph.get(p[0]).add(new int[]{p[1], p[2]});
            graph.get(p[1]).add(new int[]{p[0], p[2]});
        }
        
        // 산봉우리인지 확인
        boolean[] isSummit = new boolean[n + 1];
        for(int s : summits) isSummit[s] = true;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 위치, intensity값
        for(int g : gates){
            dist[g] = 0;
            pq.offer(new int[]{g, 0});
        }
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int node = now[0];
            int intensity = now[1];
            
            // 차피 지금 값이 더 크면 안해도 됨
            if(intensity > dist[node]) continue;
            if(isSummit[node]) continue;
            
            for(int[] next : graph.get(node)){
                int nextIntensity = Math.max(next[1], intensity);
                    
                if(dist[next[0]] > nextIntensity){
                    dist[next[0]] = nextIntensity;
                    pq.offer(new int[]{next[0], nextIntensity});
                }
            }
        }
        
        Arrays.sort(summits);
        int[] answer = {-1, Integer.MAX_VALUE};
        for(int s : summits){
            if(dist[s] < answer[1]){
                answer[0] = s;
                answer[1] = dist[s];
            }
        }
        return answer;
    }
}