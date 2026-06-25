import java.util.*;

class Solution {
    List<List<Integer>>graph;
    int[] info;
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        graph = new ArrayList<>();
        this.info = info;
        for(int i = 0; i < info.length; i++){graph.add(new ArrayList<>());}
        for(int[] e : edges){graph.get(e[0]).add(e[1]);}
        
        List<Integer> list = new ArrayList<>();
        for(int next : graph.get(0)){list.add(next);}
        // 이걸 처음부터 시작해서 양의 갯수가 잘 맞는지 확인하면서 이동해야함
        dfs(1, 0, list);
        return answer;
    }
    
    public void dfs(int sheep, int wolf, List<Integer> list){
        if(wolf >= sheep) return;
        answer = Math.max(answer, sheep);
        
        for(int next : list){
            List<Integer> nextList = new ArrayList<>(list);
            nextList.remove(Integer.valueOf(next));
            nextList.addAll(graph.get(next));

            if(info[next] == 0){dfs(sheep + 1, wolf, nextList);}
            else{dfs(sheep, wolf + 1, nextList);}
        }
    }
}