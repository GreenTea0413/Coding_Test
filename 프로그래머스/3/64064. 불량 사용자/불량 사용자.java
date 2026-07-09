import java.util.*;

class Solution {
    Set<Set<String>> answer = new HashSet<>();
    int len = 0;
    public int solution(String[] user_id, String[] banned_id) {
        len = user_id.length;
        boolean[] v = new boolean[len];
        
        dfs(v, user_id, banned_id, 0, new HashSet<>());
        
        return answer.size();
    }
    
    public void dfs(boolean[] v, String[] user_id, String[] banned_id, int depth, Set<String> cur){
        if(depth == banned_id.length){
            answer.add(new HashSet<>(cur));
            return;
        }
        
        for(int i = 0; i < len; i++){
            if(!v[i]){
                if(check(user_id[i], banned_id[depth])){
                    v[i] = true;
                    cur.add(user_id[i]);
                    
                    dfs(v, user_id, banned_id, depth + 1, cur);
                    
                    cur.remove(user_id[i]);
                    v[i] = false;
                }
            }
        }
    }
    
    public boolean check(String user, String ban){
        if(user.length() != ban.length()) return false;
        for(int i = 0; i < ban.length(); i++){
            if(ban.charAt(i) == '*'){continue;}
            if(ban.charAt(i) != user.charAt(i)){return false;}
        }
    
        return true;
    }
}