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
    public int solution(int N, int[][] road, int K) {
        graph= new ArrayList[N + 1];
        
        for(int i = 0; i <= N; i++){graph[i]= new ArrayList<>();}
        for(int[] r : road){
            graph[r[0]].add(new Node(r[1], r[2]));
            graph[r[1]].add(new Node(r[0], r[2]));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {return a.cost - b.cost;});
        pq.offer(new Node(1, 0));
        dist[1] = 0;
        
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
        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K){answer++;}
        }
        return answer;
    }
}