import java.util.*;

class Solution {
    String[] answer;
    boolean finished = false;
    int count;
    public String[] solution(String[][] tickets) {
        count = tickets.length;
        answer = new String[count+1];
        Map<String, List<String>> graph = new HashMap<>();
        
        for(String[] s : tickets){
            String from = s[0];
            String to = s[1];            
            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
        }
        
        for(List<String> l : graph.values()){
            Collections.sort(l);
        }
        
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", graph, path);
        
        return answer;
    }
    
    void dfs(String current, Map<String, List<String>> graph, List<String> path){
        if (finished) return;
        
        if (path.size() == count + 1){
            for(int i = 0; i < path.size(); i++){
                answer[i] = path.get(i);
            }
            finished = true;
            return;
        }
        
        List<String> destinations = graph.getOrDefault(current, new ArrayList<>());
        for (int i = 0; i < destinations.size(); i++){
            String next = destinations.get(i);
            
            destinations.remove(i);
            path.add(next);
            
            dfs(next, graph, path);
            
            path.remove(path.size() -1);
            destinations.add(i, next);
        }
        
    }
}