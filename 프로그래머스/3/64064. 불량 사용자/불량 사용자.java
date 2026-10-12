import java.util.*;

class Solution {
    Set<Set<String>> answer = new HashSet<>();
    String[] user;
    String[] ban;
    int uLen;
    int bLen;
    public int solution(String[] user_id, String[] banned_id) {
        // [fradi, abc123] [frodo, abc123]
        user = user_id; ban = banned_id;
        uLen = user_id.length; bLen = banned_id.length;
        
        dfs(new HashSet<>(), 0, new boolean[uLen]);
        
        return answer.size();
    }
    
    void dfs(Set<String> set, int depth, boolean[] v){
        if(depth == bLen){
            answer.add(new HashSet<>(set));
            return;
        }
        
        for(int i = 0; i < uLen; i++){
            if(check(ban[depth], user[i])){
                if(!v[i]){
                    v[i] = true;
                    set.add(user[i]);
                    dfs(set, depth + 1, v);

                    set.remove(user[i]);
                    v[i] = false;
                }
            }
        }
    }
    
    boolean check(String a, String b){
        if(a.length() != b.length()) return false;
        
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == '*') continue;
            if(a.charAt(i) != b.charAt(i)) return false;
        }
        
        return true;
    }    
}