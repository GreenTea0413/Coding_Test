import java.util.*;

class Solution {
    Set<Set<String>> answer = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        // fr*d*에 대해서 몇개가 되는지
        // abc1**에 대해서 몇개가 되는지를 찾으면 됨
        boolean[] v = new boolean[user_id.length];
        // banned_id를 하나씩 내려가면서 Set에 담아서 보관하기
        dfs(user_id, banned_id, v, 0, new HashSet<>());
        
        return answer.size();
    }
    
    public void dfs(String[] user_id, String[] banned_id, boolean[] v, int depth, Set<String> set){
        if(depth == banned_id.length){
            answer.add(new HashSet<>(set));
            return;
        }
        
        for(int i = 0; i < user_id.length; i++){
            if(!v[i]){
                if(check(user_id[i], banned_id[depth])){
                    v[i] = true;
                    set.add(user_id[i]);
                    
                    dfs(user_id, banned_id, v, depth + 1, set);
                    
                    v[i] = false;
                    set.remove(user_id[i]);
                }
            }
        }
    }
    
    public boolean check(String u, String b){
        if(u.length() != b.length()) return false;
        for(int i = 0; i < u.length(); i++){
            if(b.charAt(i) == '*') continue;
            else if(u.charAt(i) != b.charAt(i)) return false;
        }
        
        return true;
    }
}