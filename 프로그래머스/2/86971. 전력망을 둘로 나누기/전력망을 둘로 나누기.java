import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for(int[] w : wires){
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        // 그래프를 만들었으면 이제 wires에 있는거 하나씩 없애고 나서 bfs로 갯수 구할거임
        for(int[] w : wires){
            int a = w[0]; int b = w[1];
            
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            
            // 이렇게 없애고 나서
            int num1 = bfs(graph, new boolean[n + 1] , a);
            int num2 = n - num1;
            int gap = Math.abs(num2 - num1);
            
            answer = Math.min(answer, gap);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        return answer;
    }
    
    int bfs(List<List<Integer>> graph, boolean[] v, int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        v[start] = true;
        
        int count = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : graph.get(now)){
                if(!v[next]){
                    v[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}