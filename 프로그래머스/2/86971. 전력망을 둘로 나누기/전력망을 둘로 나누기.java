import java.util.*;

class Solution {
    public int bfs(List<Integer>[] graph, boolean[] v, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        v[start] = true;
        
        int count = 1;
        
        while(!q.isEmpty()){
            int n = q.poll();
            
            for(int next : graph[n]){
                if(!v[next]){
                    v[next] =true;
                    count++;
                    q.add(next);
                }
            }
        }
        return count;
        
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 101;
        List<Integer>[] graph = new ArrayList[n+1];
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
            
            boolean[] v = new boolean[n+1];
            int count = bfs(graph,v,a);
            int diff = Math.abs(n - 2 * count);
            
            answer = Math.min(answer ,diff);
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        if(answer == 101) return 0;
        return answer;
    }
}