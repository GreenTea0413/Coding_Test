import java.util.*;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int[] e : edges) graph.get(e[0]).add(e[1]);
        
        List<Integer> path = new ArrayList<>();
        for(int p : graph.get(0)) path.add(p);
        
        dfs(1, 0, path, info);
        
        return answer;
    }
    
    public void dfs(int sheep, int wolf, List<Integer> path, int[] info){
        if(sheep <= wolf) return;
        else answer = Math.max(answer, sheep);
        
        for(int p : path){
            List<Integer> c = new ArrayList<>(path);
            c.remove(Integer.valueOf(p));
            c.addAll(graph.get(p));
            
            if(info[p] == 0) dfs(sheep + 1, wolf, c, info);
            else dfs(sheep, wolf + 1, c, info);
        }
    }
}