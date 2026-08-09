import java.util.*;

class Solution {
    List<List<int[]>> graph = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        // 무방향 그래프 [출발] {도착, 비용}
        for(int[] f : fares){
            graph.get(f[0]).add(new int[]{f[1], f[2]});
            graph.get(f[1]).add(new int[]{f[0], f[2]});
        }
        
        // 3개 다 한번씩 돌아가면서 합 구하기
        // s에서 1 a에서 1 b에서 1가고 다 더한다음에 answer랑 최소 비교
        int[] sn = dfs(s, n);
        int[] an = dfs(a, n);
        int[] bn = dfs(b, n);
        
        // 마무리로 해당 목적지까지 길이 다 합쳐서 비교하기
        for(int i = 1; i <= n; i++){
            answer = Math.min(sn[i] + an[i] + bn[i], answer);
        }
        return answer;
    }
    
    public int[] dfs(int start, int n){
        int[] dist = new int[n + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            if(now[1] > dist[now[0]]) continue;
            for(int[] next : graph.get(now[0])){
                int p = next[0];
                int d = next[1];
                int nDist = d + now[1];
                
                if(nDist < dist[p]){
                    q.offer(new int[]{p, nDist});
                    dist[p] = nDist;
                }
            }
        }
        return dist;
    }
}