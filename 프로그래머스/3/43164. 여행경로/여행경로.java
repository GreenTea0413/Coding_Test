import java.util.*;

class Solution {
    String[] answer;
    int count;
    boolean found = false;
    public String[] solution(String[][] tickets) {
        count = tickets.length;
        answer = new String[count + 1];
        
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < tickets.length; i++){
            String start = tickets[i][0];
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(i);
        }
        
        for(List<Integer> list : map.values()){
            Collections.sort(list, (a, b) -> tickets[a][1].compareTo(tickets[b][1]));
        }
        
        String[] path = new String[count + 1];
        boolean[] v = new boolean[count + 1];
        path[0] = "ICN";
 
        
        dfs(map, tickets, path, v, 0, "ICN");
        
        return answer;
    }
    
    public void dfs(Map<String, List<Integer>> map, String[][] tickets, String[] path, boolean[] v, int depth, String now){
        if(count == depth){
            found = true;
            answer = path.clone();
            return;
        }
        
        if(!map.containsKey(now)) return;
        
        for(int next : map.get(now)){
            if(!v[next] && !found){
                v[next] = true;
                path[depth + 1] = tickets[next][1];
                
                dfs(map, tickets, path, v, depth + 1, tickets[next][1]);
                
                v[next] = false;
            }
        }
    }
}