import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> graph = new ArrayList<>();
        
        // 그래프 만들기
        for(int i = 0; i <= n; i++){graph.add(new ArrayList<>());}
        for(int[] w : wires){
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        // 그래프 선 하나씩 끊기
        for(int[] w : wires){
            int a = w[0];
            int b = w[1];
            
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            
            int countA = bfs(graph, a, new boolean[n + 1]);
            int countB = bfs(graph, b, new boolean[n + 1]);
            int gap = Math.abs(countA - countB);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
               
            answer = Math.min(answer, gap);
        }
        
        return answer;
    }
    
    public int bfs(List<List<Integer>> graph, int start, boolean[] v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        v[start] = true;
        int count = 1;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : graph.get(now)){
                if(!v[next]){
                    v[next] = true;
                    count++;
                    q.offer(next);
                }
            }
        }
        
        return count;
    }
}