import java.util.*;

class Solution {
    public int answer = 101;
    public int bfs(List<Integer>[] graph, boolean[] visited, int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);
        int count = 1;
        
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int next : graph[x]){
                if(!visited[next]){
                    visited[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        // 그래프 생성~
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i ++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] w : wires){
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        // 간선 만들기 끝
        for(int[] w : wires){
            int a = w[0];
            int b = w[1];
            
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            // 간선 지우고 이제 얼마나 연결 되어있는 지
            boolean[] visited = new boolean[n + 1];
            int count = bfs(graph, visited, a);
            int diff = Math.abs(n - 2 * count);
            
            answer = Math.min(answer, diff);
            
            graph[a].add(b); 
            graph[b].add(a);
        }
        return answer;
    }
}