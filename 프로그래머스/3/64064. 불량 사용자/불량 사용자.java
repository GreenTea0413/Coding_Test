import java.util.*;

class Solution {
    Set<Set<String>> set = new HashSet<>();
    String[] user;
    String[] ban;
    int uLen;
    int bLen;
    public int solution(String[] user_id, String[] banned_id) {
        user = user_id; ban = banned_id;  uLen = user_id.length; bLen = banned_id.length;
        // dfs 백트래킹 활용해서 전체 경우의 수 만들기
        dfs(new boolean[uLen], 0, new HashSet<>());
        
        // 이제 set에 모은걸로 값 구하기
        return set.size();
    }
    
    void dfs(boolean[] v, int depth, Set<String> cur){
        if(depth == bLen){
            set.add(new HashSet<>(cur));
            return;
        }
        
        for(int i = 0; i < uLen; i++){
            if(!v[i] && check(user[i], ban[depth])){
                cur.add(user[i]);
                v[i] = true;

                dfs(v, depth + 1, cur);

                v[i] = false;
                cur.remove(user[i]);
            }
        }
    }
    
    boolean check(String u, String b){
        if(u.length() != b.length()) return false;
        
        for(int i = 0; i < b.length(); i++){
            if(b.charAt(i) =='*') continue;
            else if(u.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
}