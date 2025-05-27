import java.util.*;

class Solution {
    public int bfs(boolean[] visited,List<Integer>[] graph, int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start]  = true;
        queue.add(start);
        int count = 1;
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            
            for(int next : graph[num]){
                if(!visited[next]){
                    count ++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return count;
    }
    public int solution(int n, int[][] wires) {
        int answer = 101;
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i ++){
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
            int count = bfs(visited, graph, a);
            if(count == -1) return 0;
            int diff = Math.abs(n - 2 * count);
            answer = Math.min(answer , diff);
            
            graph[a].add(b);
            graph[b].add(a);
        }
        return answer;
    }
}