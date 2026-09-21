import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    List<String> answer = new ArrayList<>();
    boolean found = false;
    int len;
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        for(int i = 0; i < len; i++){
            String[] t = tickets[i];
            
            map.putIfAbsent(t[0], new ArrayList<>());
            map.get(t[0]).add(i);
        }        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs(tickets, "ICN", path, 0, new boolean[len + 1]);
        return answer.toArray(new String[0]);
    }
    
    void dfs(String[][] tickets, String start, List<String> path, int depth, boolean[] v){
        if(depth == len){
            answer = new ArrayList<>(path);
            found = true;
            return;
        }
        if(!map.containsKey(start)) return;
        
        if(!found){
            for(int next : map.get(start)){
                if(!v[next]){
                    path.add(tickets[next][1]);
                    v[next] = true;
                    
                    dfs(tickets, tickets[next][1], path, depth + 1, v);
                
                    v[next] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
        
    }
}