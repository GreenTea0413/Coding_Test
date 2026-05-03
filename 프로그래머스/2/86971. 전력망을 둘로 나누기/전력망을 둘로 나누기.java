import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){graph.add(new ArrayList<>());}
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        // 이제 wire를 하나씩 자르면서 비교
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            
            int count1 = bfs(a, graph, new boolean[n + 1]);
            int count2 = bfs(b, graph, new boolean[n + 1]);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
            
            int gap = Math.abs(count2 - count1); 
            answer = Math.min(gap, answer);
        }
        return answer;
    }
    
    public int bfs(int start, List<List<Integer>> graph, boolean[] v){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        v[start] = true;
        q.offer(start);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : graph.get(now)){
                if(!v[next]){
                    q.offer(next);
                    v[next] = true;
                    count++;
                }
            }
        }
        return count;
    }
}