import java.util.*;

class Solution {
    String[][] tickets;
    List<String> path = new ArrayList<>();
    boolean[] v;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        v = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        path.add("ICN");
        dfs("ICN", 0);
        return path.toArray(new String[0]);
    }
    
    boolean dfs(String now, int depth){
        if(depth == tickets.length) return true;
        
        for(int i = 0; i < tickets.length; i++){
            if(!v[i] && tickets[i][0].equals(now)){
                v[i] = true;
                path.add(tickets[i][1]);
                
                if(dfs(tickets[i][1], depth + 1)) return true;
                
                v[i] = false;
                path.remove(path.size() - 1);
            }
        }
        
        return false;
    }
}