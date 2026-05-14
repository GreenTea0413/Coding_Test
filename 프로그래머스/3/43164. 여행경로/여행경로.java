import java.util.*;
class Solution {
    String[] answer;
    int len;
    boolean found = false;

    public String[] solution(String[][] tickets) {
        len = tickets.length;
        
        // ICN이 가는 idx 저장해놓기
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            String start = tickets[i][0];
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(i);
        }
        
        for(List<Integer> list : map.values()){
            Collections.sort(list, (a, b) -> tickets[a][1].compareTo(tickets[b][1]));
        }
        
        String[] path = new String[len + 1];
        path[0] = "ICN";
        dfs(tickets, map, new boolean[len], "ICN", 0, path);
        
        return answer;
    }
    
    public void dfs(String[][] tickets, Map<String, List<Integer>> map, boolean[] v, String now, int depth, String[] path){
        if(depth == len){
            answer = path.clone();
            found = true;
            return;
        }
        
        if(!map.containsKey(now)) return;
        
        for(int idx : map.get(now)){
            if(!v[idx] && !found){
                v[idx] = true;
                path[depth + 1] = tickets[idx][1];
                dfs(tickets, map, v, tickets[idx][1], depth + 1, path);
                v[idx] = false;
            }
        }
    }
}