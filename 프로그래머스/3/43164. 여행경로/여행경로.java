import java.util.*;

class Solution {
    int l;
    String[] answer;
    boolean found;
    public String[] solution(String[][] tickets) {
        l = tickets.length;
        answer = new String[l + 1];
        String[] path = new String[l + 1];
        path[0] = "ICN";
        
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < l; i++){
            String start = tickets[i][0];
            
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(i);
        }
        
        for(List<Integer> list : map.values()){
            Collections.sort(list, (a, b) -> tickets[a][1].compareTo(tickets[b][1]));
        }
        
        dfs(map, tickets, path, 0, new boolean[l + 1], "ICN");
        return answer;
    }
    
    public void dfs(Map<String, List<Integer>> map, String[][] tickets, String[] path, int depth, boolean[] v, String start){
        if(depth == l){
            answer = path.clone();
            found = true;
            return;
        }
        if(!map.containsKey(start)) return;
        
        for(int next : map.get(start)){
            if(!v[next] && !found){
                v[next] = true;
                path[depth + 1] = tickets[next][1];
                
                dfs(map, tickets, path, depth + 1, v, tickets[next][1]);
                
                v[next] = false;
            }
        }
    }
}