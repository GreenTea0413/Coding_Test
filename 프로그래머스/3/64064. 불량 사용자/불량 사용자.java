import java.util.*;

class Solution {
    Set<Set<String>> ban = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int len = user_id.length;
        boolean[] v = new boolean[len];
        
        dfs(v, user_id, banned_id, 0, new HashSet<>());
        return ban.size();
    }
    
    public void dfs(boolean[] v, String[] user_id, String[] banned_id, int depth, Set<String> cur){
        if(depth == banned_id.length) {
            ban.add(new HashSet<>(cur));
            return;
        }
        
        
        for(int j = 0; j < user_id.length; j++){
            if(!v[j]){
                if(isCheck(user_id[j], banned_id[depth])){
                    v[j] = true;    
                    cur.add(user_id[j]);
                    dfs(v, user_id, banned_id, depth + 1, cur);

                    v[j] = false;
                    cur.remove(user_id[j]);
                }
            }
        }
        
    }
    
    public boolean isCheck(String a, String b){
        if(a.length() != b.length()) return false;
        for(int i = 0; i < a.length(); i++){
            if(b.charAt(i) == '*') continue;
            if(a.charAt(i) != b.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}