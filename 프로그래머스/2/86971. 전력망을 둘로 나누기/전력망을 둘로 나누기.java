import java.util.*;

class Solution {
    int answer = 101;
    
    int bfs(List<Integer>[] graph, boolean[] visited, int start){
        Queue <Integer> queue = new LinkedList<Integer>();
        
        visited[start] = true;
        queue.add(start);
        int num = 1;
        while(!queue.isEmpty()){
            int s = queue.poll();
            
            for(int next : graph[s]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    num ++;
                }
            }
        }
        return num;
    }
    
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0 ; i < n + 1; i ++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] w : wires){
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        
        for(int[] w : wires){
            int a = w[0];
            int b = w[1];
            
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            
            boolean[] visited = new boolean[n + 1];
            
            int count = bfs(graph,visited,a);
            int diff = Math.abs(n - 2 * count);
            
            answer = Math.min(answer, diff);
            
            graph[a].add(b);
            graph[b].add(a);
        }
        return answer;
    }
}