import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        dfs(begin, target, words, 0, new boolean[words.length]);
        
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int depth, boolean[] v){
        if(depth > answer) return;
        
        if(begin.equals(target)){
            answer = Math.min(answer, depth);
        }
        
        for(int i = 0; i < words.length; i++){
            if(!v[i]){
                if(isCheck(begin, words[i])){
                    v[i] = true;
                    dfs(words[i], target, words, depth + 1, v);
                    v[i] = false;
                }
            }
        }
    }
    
    public boolean isCheck(String a, String b){
        int gap = 0;
        int len = a.length();
        for(int i = 0; i < len; i++){
            if(a.charAt(i) != b.charAt(i)) gap++;
            if(gap > 1) return false;
        }
        
        return true;
        
    }
}