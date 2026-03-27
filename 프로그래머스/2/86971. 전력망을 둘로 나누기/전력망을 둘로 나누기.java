import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        // 트리를 끊고 확인해야함
        // 그래프 만들어서 양방향 연결
        // 다 연결한 후에 wires에서 하나씩 꺼내서 제거하고 다시 붙이고 해야할듯
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for(int[] wire : wires){
            int x = wire[0];
            int y = wire[1];
            // 여기서 삭제하고
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));
            // n - 그래프 돌고 온거 확인 갯수
            // 그래서 2개 비교하고 answer랑 비교해서 최솟값
            // dfs에 그러면 삭제한 그래프를 넣고 어떻게 비교하지?
            // 어디서 부터 시작을 돌려야할까..
            boolean[] v = new boolean[n + 1];
            int graph1 = dfs(graph, v, x); 
            int graph2 = n - graph1;
            int gap = Math.abs(graph1 - graph2);
            
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
            
            answer = Math.min(answer, gap);
        }
        return answer;
    }
    
    public int dfs(List<List<Integer>> graph, boolean[] v, int start){
        v[start] = true;
        int count = 1;
        
        for(int next : graph.get(start)){
            if(!v[next]){
                count += dfs(graph, v, next);
            }
        }
        return count;
    }
}