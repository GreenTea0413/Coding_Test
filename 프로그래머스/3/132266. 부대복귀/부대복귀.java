import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i ++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] r : roads){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{destination, 0}); // 시작점, 비용
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int node = now[0];
            int cost = now[1];

            for(int next : graph.get(node)){
                if (dist[next] == -1){
                    queue.offer(new int[]{next, cost + 1});
                    dist[next] = cost + 1;
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i ++){
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}