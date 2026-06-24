import java.util.*;

class Solution {
    static class Node{
        int to;
        int cost;
        
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    List<Node>[] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        
        for(int i = 0; i <= n; i++){graph[i] = new ArrayList<>();}
        
        for(int[] fare : fares){
            graph[fare[0]].add(new Node(fare[1], fare[2]));
            graph[fare[1]].add(new Node(fare[0], fare[2]));
        }
        
        int[] distS = dijkstra(n, s);
        int[] distA = dijkstra(n, a);
        int[] distB = dijkstra(n, b);
        
        int answer = Integer.MAX_VALUE;
        for (int k = 1; k <= n; k++) {
            answer = Math.min(answer, distS[k] + distA[k] + distB[k]);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int n, int start){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {return a.cost - b.cost;});
        dist[start] = 0;
        pq.offer(new Node(start, 0));        
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(now.cost > dist[now.to]){continue;}
            
            for(Node next : graph[now.to]){
                int nextCost = now.cost + next.cost;
                
                if(nextCost < dist[next.to]){
                    dist[next.to] = nextCost;
                    pq.offer(new Node(next.to, nextCost));
                }
            }
        }
        
        return dist;
    }
}