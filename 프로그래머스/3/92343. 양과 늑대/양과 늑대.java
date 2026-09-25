import java.util.*;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        for(int i = 0; i <= info.length; i++) graph.add(new ArrayList<>());
        for(int[] e : edges) graph.get(e[0]).add(e[1]);
        
        List<Integer> path = new ArrayList<>();
        for(int n : graph.get(0)) path.add(n);
        
        dfs(1, 0, info, path);
        return answer;
    }
    
    void dfs(int sheep, int wolf, int[] info, List<Integer> path){
        if(sheep <= wolf) return;
        else answer = Math.max(sheep, answer);
        
        for(int p : path){
            List<Integer> temp = new ArrayList<>(path);
            temp.remove(Integer.valueOf(p));
            temp.addAll(graph.get(p));
            
            if(info[p] == 0) dfs(sheep + 1, wolf, info, temp);
            else dfs(sheep, wolf + 1, info, temp);
        }
    }
}