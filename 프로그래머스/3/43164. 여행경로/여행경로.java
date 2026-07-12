import java.util.*;

class Solution {
    int len;
    String[] answer;
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        answer = new String[len + 1];
        // 경로대 경로로 못 이으니까 경로가 가는 index들 저장하기
        // INC -> 0
        // HND -> 1
        // JFK -> 2
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            String start = tickets[i][0];
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(i);
        }
        
        
        // 그리고 이제 값들 불러온거에서 각각 출발지로부터 알파벳 순으로 정렬
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
        
        for(int next : map.get(now)){
            if(!v[next] && !found){
                v[next] = true;
                path[depth + 1] = tickets[next][1];
                
                dfs(tickets, map, v, tickets[next][1], depth + 1, path);
                
                v[next] = false;
            }
        }
    }
}