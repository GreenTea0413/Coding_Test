import java.util.*;
class Solution {
    Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        boolean[] v = new boolean[user_id.length];
        dfs(user_id, banned_id, v, 0, new HashSet<>());
        return result.size();
    }
    
    public void dfs(String[] user_id, String[] bannded_id, boolean[] v, int depth, Set<String> current){
        if(depth == bannded_id.length){
            result.add(new HashSet<>(current));
            return;
        }
        
        for(int i = 0; i < user_id.length; i++){
            if (v[i]) continue;
            
            if(match(user_id[i], bannded_id[depth])){
                v[i] = true;
                current.add(user_id[i]);
                
                dfs(user_id, bannded_id, v, depth + 1, current);
                
                v[i] = false;
                current.remove(user_id[i]);
            }
        }
    }
    
    public boolean match(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        
        for(int i = 0; i < s1.length(); i++){
            if(s2.charAt(i) == '*') continue;
            if(s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}