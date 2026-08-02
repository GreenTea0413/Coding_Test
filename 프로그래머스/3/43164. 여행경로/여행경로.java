import java.util.*;

class Solution {
    int l;
    String[] answer;
    boolean find = false;
    public String[] solution(String[][] tickets) {
        l = tickets.length;
        answer = new String[l + 1];
        boolean[] v = new boolean[l + 1];
        // map으로 해당 티켓으로 다음 지역 가는거 확인
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < l; i++){
            String start = tickets[i][0];
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(i);
        }
        
        for(List<Integer> list : map.values()){
            Collections.sort(list, (a, b) -> tickets[a][1].compareTo(tickets[b][1]));
        }
        
        String[] path = new String[l + 1];
        path[0] = "ICN";
        dfs(tickets, v, path, "ICN", map, 0);
        return answer;
    }
    
    public void dfs(String[][] tickets, boolean[] v, String[] path, String start, Map<String, List<Integer>> map, int depth){
        if(depth == l){
            answer = path.clone();
            find = true;
            return;
        }
        
        if(!map.containsKey(start)) return;
        
        for(int next : map.get(start)){
            if(!v[next] && !find){
                v[next] = true;
                path[depth + 1] = tickets[next][1];
                
                dfs(tickets, v, path, tickets[next][1], map, depth + 1);
                
                v[next] = false;        
            }
        }
    }
}