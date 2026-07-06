import java.util.*;

class Solution {
    int answer = 0;
    public int solution(String begin, String target, String[] words) {
        dfs(begin, target, words, new boolean[words.length], 0);
        return answer;
    }
    
    public void dfs(String cur, String target, String[] words, boolean[] v, int count){
        if(cur.equals(target)){
            answer = count;
            return;
        }       
        
        for(int i = 0; i < words.length; i++){
            if(!v[i] && check(cur, words[i])){
                v[i] = true;
                dfs(words[i], target, words, v, count + 1);
                v[i] = false;
            }
        }
    }
    public boolean check(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) count++;
            if(count > 1) return false;
        }
        return true;
    }
}