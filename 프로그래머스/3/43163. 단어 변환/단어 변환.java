import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        dfs(begin, target, words, new boolean[words.length], 0);
        
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] v, int depth){
        if(begin.equals(target)){
            answer = Math.min(answer, depth);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(!v[i] && check(begin, words[i])){
                v[i] = true;
                dfs(words[i], target, words, v, depth + 1);
                v[i] = false;
            }
        }
    }
    
    public boolean check(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
            if (count >= 2) return false;
        }
        return true;
    } 
}