import java.util.*;

class Solution {
    List<List<Integer>> graph;
    int[] arr;
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        
        // 그래프 만들기
        graph = new ArrayList<>();
        arr = info.clone();
        for(int i = 0; i <= n; i++){graph.add(new ArrayList<>());}
        for(int[] e : edges){graph.get(e[0]).add(e[1]);}
        
        // 양늑은 처음에 무조건 양으로 시작하기에
        // 경로들을 다음 목적지들을 담아서 dfs 시키기
        
        List<Integer> path = new ArrayList<>();
        for(int next : graph.get(0)){path.add(next);}
        
        dfs(1, 0, path);
        return answer;
    }
    
    public void dfs(int sheep, int wolf, List<Integer> path){
        if(sheep <= wolf) return;
        else{answer = Math.max(answer, sheep);}
        
        // 현재 경로안에서 다음으로 갈 수 있는 경우들
        for(int p : path){
            List<Integer> pClone = new ArrayList<>(path);
            pClone.remove(Integer.valueOf(p));  // 지금 값 바로 삭제
            pClone.addAll(graph.get(p));        // 현재 다음 값들 이동하는거
            
            if(arr[p] == 0){dfs(sheep + 1, wolf, pClone);}
            else{dfs(sheep, wolf + 1, pClone);}
        }
    }
}